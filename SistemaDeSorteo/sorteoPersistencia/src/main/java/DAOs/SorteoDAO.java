package DAOs;

import Conexion.ConexionBD;
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

    @Override
    public void crearSorteo(Sorteo sorteo) {
        EntityManager entityManager = ConexionBD.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        try {
            transaction.begin();
            entityManager.persist(sorteo);
            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            throw new RuntimeException("Error al crear el sorteo", e);
        } finally {
            entityManager.close();
        }
    }

    @Override
    public Sorteo obtenerSorteoPorId(int id) {
        EntityManager entityManager = ConexionBD.getEntityManager();

        try {
            return entityManager.find(Sorteo.class, id);
        } catch (Exception e) {
            throw new RuntimeException("Error al obtener el sorteo con ID " + id, e);
        } finally {
            entityManager.close();
        }
    }

    @Override
    public void actualizarSorteo(Sorteo sorteo) {
        EntityManager entityManager = ConexionBD.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        try {
            transaction.begin();
            entityManager.merge(sorteo);
            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            throw new RuntimeException("Error al actualizar el sorteo", e);
        } finally {
            entityManager.close();
        }
    }

    @Override
    public void eliminarSorteo(int id) {
        EntityManager entityManager = ConexionBD.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        try {
            transaction.begin();
            Sorteo sorteo = entityManager.find(Sorteo.class, id);
            if (sorteo != null) {
                if (sorteo.getEstadoSorteo() == EstadoSorteo.FINALIZADO || sorteo.getEstadoSorteo() == EstadoSorteo.INACTIVO) {
                    entityManager.remove(sorteo);
                } else {
                    throw new IllegalStateException("El sorteo no puede ser eliminado porque está activo o no ha finalizado.");
                }
            } else {
                throw new IllegalArgumentException("El sorteo con ID " + id + " no existe.");
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            throw new RuntimeException("Error al eliminar el sorteo", e);
        } finally {
            entityManager.close();
        }
    }

    @Override
    public String mostrarBoletos(int idSorteo) {
        EntityManager entityManager = ConexionBD.getEntityManager();
        try {
            String query = "SELECT COUNT(b) FROM Boleto b WHERE b.idSorteo = :idSorteo AND b.estado = 'DISPONIBLE'";
            Long count = entityManager.createQuery(query, Long.class)
                    .setParameter("idSorteo", idSorteo)
                    .getSingleResult();
            return "Boletos disponibles: " + count;
        } catch (Exception e) {
            throw new RuntimeException("Error al obtener los boletos del sorteo con ID " + idSorteo, e);
        } finally {
            entityManager.close();
        }
    }

    @Override
    public int obtenerBoletosApartados(int idSorteo) {
        EntityManager entityManager = ConexionBD.getEntityManager();
        try {
            String query = "SELECT COUNT(b) FROM Boleto b WHERE b.idSorteo = :idSorteo AND b.estado = 'APARTADO'";
            Long count = entityManager.createQuery(query, Long.class)
                    .setParameter("idSorteo", idSorteo)
                    .getSingleResult();
            return count.intValue();
        } finally {
            entityManager.close();
        }
    }

    @Override
    public int obtenerTotalBoletos(int idSorteo) {
        EntityManager entityManager = ConexionBD.getEntityManager();
        try {
            String query = "SELECT COUNT(b) FROM Boleto b WHERE b.idSorteo = :idSorteo";
            Long count = entityManager.createQuery(query, Long.class)
                    .setParameter("idSorteo", idSorteo)
                    .getSingleResult();
            return count.intValue();
        } finally {
            entityManager.close();
        }
    }

    public List<Sorteo> obtenerTodosSorteos() {
        EntityManager entityManager = ConexionBD.getEntityManager();
        try {
            String query = "SELECT s FROM Sorteo s";
            return entityManager.createQuery(query, Sorteo.class).getResultList();
        } finally {
            entityManager.close();
        }
    }

    @Override
    public String consultarEstadoSorteo(int idSorteo) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String calcularRecaudacion(int idSorteo) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public long calcularDiasRestantes(int idSorteo) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int obtenerBoletosVendidos(int idSorteo) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
