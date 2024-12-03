package DAOs;

import Conexion.ConexionBD;
import DTOs.DeudorDTO;
import DTOs.SorteoDTO;
import Entidades.EstadoSorteo;
import Entidades.Sorteo;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

/**
 *
 * @author ruben
 */
public class SorteoDAO implements ISorteoDAO {

    EntityManager entityManager = ConexionBD.getEntityManager();
    EntityTransaction transaction = entityManager.getTransaction();

    @Override
    public void crearSorteo(Sorteo sorteo) {
        EntityManager entityManager = ConexionBD.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        try {
            transaction.begin();
            entityManager.persist(sorteo); // Guarda el sorteo
            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback(); // Deshacer cambios en caso de error
            }
            e.printStackTrace();
        } finally {
            entityManager.close(); // Cerrar el EntityManager
        }
    }

    @Override
    public Sorteo obtenerSorteoPorId(Long id) {
        EntityManager entityManager = ConexionBD.getEntityManager();
        Sorteo sorteo = null;

        try {
            sorteo = entityManager.find(Sorteo.class, id); // Busca el sorteo por su ID
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            entityManager.close(); // Cerrar el EntityManager
        }

        return sorteo;
    }

    @Override
    public void actualizarSorteo(Sorteo sorteo) {
        EntityManager entityManager = ConexionBD.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        try {
            transaction.begin();
            entityManager.merge(sorteo); // Actualiza el sorteo
            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback(); // Deshacer cambios en caso de error
            }
            e.printStackTrace();
        } finally {
            entityManager.close(); // Cerrar el EntityManager
        }
    }

    @Override
    public void eliminarSorteo(Long id) {
        EntityManager entityManager = ConexionBD.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        try {
            transaction.begin();
            Sorteo sorteo = entityManager.find(Sorteo.class, id);
            if (sorteo != null) {
                if (sorteo.getEstadoSorteo() == EstadoSorteo.FINALIZADO || sorteo.getEstadoSorteo() == EstadoSorteo.INACTIVO) {
                    entityManager.remove(sorteo);
                } else {
                    System.out.println("El sorteo no puede ser eliminado porque esta activo o no ha finalizado.");
                }
            } else {
                System.out.println("El sorteo no existe.");
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            entityManager.close();
        }
    }


    @Override
    public void registrarSorteo(SorteoDTO sorteoDTO) {
        // Validar el DTO
        sorteoDTO.validar();

        // Convertir DTO a Entidad
        Sorteo sorteo = convertirDTOaEntidad(sorteoDTO);

        // Delegar la persistencia al DAO
        crearSorteo(sorteo);
    }

    @Override
    public Sorteo convertirDTOaEntidad(SorteoDTO dto) {
        Sorteo sorteo = new Sorteo();
        sorteo.setRangoNumeros(dto.getRangoNumeros());
        sorteo.setPrecioNumero(dto.getPrecioNumero());
        sorteo.setFechaSorteo(dto.getFechaSorteo());
        sorteo.setFechaInicio(dto.getFechaSorteo());
        sorteo.setFechaFin(dto.getFechaFin());
        return sorteo;
    }

    @Override
    public String consultarEstadoSorteo(Long idSorteo) {
        Sorteo sorteo = obtenerSorteoPorId(idSorteo);
        if (sorteo != null) {
            return sorteo.getEstadoSorteo().toString();
        } else {
            throw new IllegalArgumentException("Sorteo no encontrado con ID: " + idSorteo);
        }
    }

    @Override
    public String calcularRecaudacion(Long idSorteo) {
        Sorteo sorteo = obtenerSorteoPorId(idSorteo);
        if (sorteo != null) {
            int boletosVendidos = obtenerBoletosVendidos(idSorteo);
            float montoRecaudado = boletosVendidos * sorteo.getPrecioNumero();
            return "Monto recaudado: " + montoRecaudado + ", Boletos vendidos: " + boletosVendidos;
        } else {
            throw new IllegalArgumentException("No se encontró el sorteo con ID: " + idSorteo);
        }
    }

    @Override
    public String mostrarBoletos(Long idSorteo) {
        int boletosApartados = obtenerBoletosApartados(idSorteo);
        int boletosTotales = obtenerTotalBoletos(idSorteo);
        int boletosDisponibles = boletosTotales - boletosApartados;
        return "Boletos apartados: " + boletosApartados + ", Boletos disponibles: " + boletosDisponibles;
    }

    @Override
    public long calcularDiasRestantes(Long idSorteo) {
        Sorteo sorteo = obtenerSorteoPorId(idSorteo);
        if (sorteo != null) {
            LocalDateTime fechaActual = LocalDateTime.now();
            Duration duracion = Duration.between(fechaActual, sorteo.getFechaFin().toInstant());
            return duracion.toDays();
        } else {
            throw new IllegalArgumentException("No se encontró el sorteo con ID: " + idSorteo);
        }
    }

    @Override
    public int obtenerBoletosVendidos(Long idSorteo) {
        Long count = entityManager.createQuery(
                "SELECT COUNT(b) FROM Boleto b WHERE b.sorteo.idSorteo = :idSorteo AND b.estado = 'VENDIDO'", Long.class)
                .setParameter("idSorteo", idSorteo)
                .getSingleResult();
        return count.intValue();
    }

    @Override
    public int obtenerBoletosApartados(Long idSorteo) {
        Long count = entityManager.createQuery(
                "SELECT COUNT(b) FROM Boleto b WHERE b.sorteo.idSorteo = :idSorteo AND b.estado = 'APARTADO'", Long.class)
                .setParameter("idSorteo", idSorteo)
                .getSingleResult();
        return count.intValue();
    }

    @Override
    public int obtenerTotalBoletos(Long idSorteo) {
        Long count = entityManager.createQuery(
                "SELECT COUNT(b) FROM Boleto b WHERE b.sorteo.idSorteo = :idSorteo", Long.class)
                .setParameter("idSorteo", idSorteo)
                .getSingleResult();
        return count.intValue();
    }

    public boolean actualizarEstadoNumeros(Long idSorteo, String rangoNumeros, String nuevoEstado) {
        try {
            entityManager.getTransaction().begin();

            // Actualización del estado de los números apartados
            int actualizados = entityManager.createQuery(
                    "UPDATE Boleto b SET b.estado = :nuevoEstado "
                    + "WHERE b.sorteo.idSorteo = :idSorteo AND b.numero IN (:rangoNumeros) AND b.estado = 'APARTADO'"
            )
                    .setParameter("nuevoEstado", nuevoEstado)
                    .setParameter("idSorteo", idSorteo)
                    .setParameter("rangoNumeros", rangoNumeros.split(","))
                    .executeUpdate();

            entityManager.getTransaction().commit();
            return actualizados > 0;
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            e.printStackTrace();
            return false;
        }
    }

    public List<DeudorDTO> generarReporteDeDeudores(Long idSorteo) {

        List<DeudorDTO> deudores = obtenerDeudoresPorSorteo(idSorteo);

        return deudores;
    }

    public List<DeudorDTO> obtenerDeudoresPorSorteo(Long idSorteo) {
        return entityManager.createQuery(
                "SELECT NEW DTOs.DeudorDTO(u.nombre, u.email, GROUP_CONCAT(b.numero), SUM(b.precio), b.fechaLimitePago) "
                + "FROM Boleto b JOIN b.usuario u "
                + "WHERE b.sorteo.idSorteo = :idSorteo AND b.estado = 'APARTADO' "
                + "GROUP BY u.idUsuario",
                DeudorDTO.class
        )
                .setParameter("idSorteo", idSorteo)
                .getResultList();
    }
    
    
     // Método para obtener todos los sorteos
    public List<Sorteo> obtenerTodosSorteos() {
        String query = "SELECT s FROM Sorteo s";
        return entityManager.createQuery(query, Sorteo.class).getResultList();
    }


}
