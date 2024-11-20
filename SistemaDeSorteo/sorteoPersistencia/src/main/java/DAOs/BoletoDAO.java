/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOs;

import DTOs.BoletoDTO;
import DTOs.LiberarNumerosDTO;
import DTOs.PagoDTO;
import Entidades.Boleto;
import Entidades.EstadoBoleto;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import javax.persistence.TypedQuery;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

/**
 *
 * @author ruben
 */
public class BoletoDAO implements IBoleto {

    @PersistenceContext
    private EntityManager entityManager;
    SorteoDAO sorteoDAO = new SorteoDAO();
    private final long LIMITE_APARTADO_MINUTOS = 30;

    // Método para pagar un boleto
    public String pagarBoletoApartados(PagoDTO pagoDTO) {
        // Obtener el boleto por su número
        Boleto boleto = obtenerBoletoPorNumero(pagoDTO.getNumeroBoleto());

        if (boleto == null) {
            return "Boleto no encontrado";
        }

        // Cambiar el estado del boleto a PAGADO
        boleto.setEstado(EstadoBoleto.PAGADO);

        // Actualizar el boleto en la base de datos
        actualizarBoleto(boleto);

        return "Boleto pagado exitosamente";
    }

    @Override
    public void marcarComoPagado(Integer idBoleto) {
        Boleto boleto = entityManager.find(Boleto.class, idBoleto);
        if (boleto != null) {
            boleto.setEstado(EstadoBoleto.PAGADO); // Actualiza el estado a "PAGADO"
            entityManager.merge(boleto); // Guarda los cambios en la base de datos
        }
    }

    public void liberarNumerosApartados(LiberarNumerosDTO liberarNumerosDTO) {
        liberarNumerosDTO.validar();

        // Cambiar el estado de los números a "DISPONIBLE"
        boolean exito = sorteoDAO.actualizarEstadoNumeros(
                liberarNumerosDTO.getIdSorteo(),
                liberarNumerosDTO.getRangoNumeros(),
                "DISPONIBLE"
        );

        if (!exito) {
            throw new RuntimeException("No se pudieron liberar los números apartados.");
        }
    }

    public List<Boleto> obtenerBoletosPorSorteo(Long idSorteo) {
        String jpql = "SELECT b FROM Boleto b WHERE b.sorteo.idSorteo = :idSorteo";
        TypedQuery<Boleto> query = entityManager.createQuery(jpql, Boleto.class);
        query.setParameter("idSorteo", idSorteo);
        return query.getResultList();
    }

    public List<BoletoDTO> obtenerBoletosDisponiblesPorSorteo(Long idSorteo) {
        List<Boleto> boletos = obtenerBoletosPorSorteo(idSorteo);

        return boletos.stream()
                .map(boleto -> new BoletoDTO(
                boleto.getNumeroBoleto(),
                boleto.getEstado().name()))
                .collect(Collectors.toList());
    }

    public boolean apartarBoleto(String numeroBoleto) {
        Boleto boleto = obtenerBoletoPorNumero(numeroBoleto);
        if (boleto != null && boleto.getEstado() == EstadoBoleto.DISPONIBLE) {
            boleto.setEstado(EstadoBoleto.APARTADO);
            boleto.setTiempoApartado(LocalDateTime.now());
            actualizarBoleto(boleto);  // Método que persiste el boleto actualizado
            return true;
        }
        return false;  // Si no se encuentra el boleto o no está disponible
    }

    // Método para obtener un boleto por su número
    public Boleto obtenerBoletoPorNumero(String numeroBoleto) {
        try {
            return entityManager.createQuery("SELECT b FROM Boleto b WHERE b.numeroBoleto = :numeroBoleto", Boleto.class)
                    .setParameter("numeroBoleto", numeroBoleto)
                    .getSingleResult();
        } catch (NoResultException e) {

            return null;
        }
    }

    public void actualizarBoleto(Boleto boleto) {
        entityManager.merge(boleto);
    }

    public List<Boleto> obtenerBoletosApartados() {
        return entityManager.createQuery("SELECT b FROM Boleto b WHERE b.estado = :estado", Boleto.class)
                .setParameter("estado", EstadoBoleto.APARTADO)
                .getResultList();
    }

    public void cancelarApartado() {
        // Obtén todos los boletos apartados
        List<Boleto> boletosApartados = obtenerBoletosApartados();

        for (Boleto boleto : boletosApartados) {
            if (boleto.getTiempoApartado() != null) {
                Duration duration = Duration.between(boleto.getTiempoApartado(), LocalDateTime.now());
                if (duration.toMinutes() > LIMITE_APARTADO_MINUTOS) {
                    boleto.setEstado(EstadoBoleto.CANCELADO);
                    actualizarBoleto(boleto);
                }
            }
        }
    }
}
