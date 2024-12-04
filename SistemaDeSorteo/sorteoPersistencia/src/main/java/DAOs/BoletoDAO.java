package DAOs;

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

    private final long LIMITE_APARTADO_MINUTOS = 30;

    @Override
    public void marcarComoPagado(Integer idBoleto) {
        Boleto boleto = entityManager.find(Boleto.class, idBoleto);
        if (boleto != null) {
            boleto.setEstado(EstadoBoleto.PAGADO); // Actualiza el estado a "PAGADO"
            entityManager.merge(boleto); // Guarda los cambios en la base de datos
        }
    }

    public Boleto obtenerBoletoPorNumero(String numeroBoleto) {
        try {
            return entityManager.createQuery(
                "SELECT b FROM Boleto b WHERE b.numeroBoleto = :numeroBoleto", Boleto.class)
                .setParameter("numeroBoleto", numeroBoleto)
                .getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    public List<Boleto> obtenerBoletosPorSorteo(int idSorteo) {
        String jpql = "SELECT b FROM Boleto b WHERE b.idSorteo = :idSorteo";
        TypedQuery<Boleto> query = entityManager.createQuery(jpql, Boleto.class);
        query.setParameter("idSorteo", idSorteo);
        return query.getResultList();
    }

    public void actualizarBoleto(Boleto boleto) {
        entityManager.merge(boleto);
    }

    public List<Boleto> obtenerBoletosApartados() {
        return entityManager.createQuery(
                "SELECT b FROM Boleto b WHERE b.estado = :estado", Boleto.class)
                .setParameter("estado", EstadoBoleto.APARTADO)
                .getResultList();
    }

    public void cancelarApartados() {
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

    public List<Object[]> obtenerBoletosDisponibles() {
        String query = "SELECT b.numeroBoleto, b.precio " +
                       "FROM Boleto b WHERE b.estado = 'DISPONIBLE'";
        return entityManager.createQuery(query, Object[].class).getResultList();
    }

    public void apartarBoleto(String numeroBoleto) {
        entityManager.getTransaction().begin();
        try {
            String updateQuery = "UPDATE Boleto b SET b.estado = :estado, b.tiempoApartado = :tiempo " +
                                 "WHERE b.numeroBoleto = :numero AND b.estado = :estadoDisponible";
            int rowsUpdated = entityManager.createQuery(updateQuery)
                    .setParameter("estado", EstadoBoleto.APARTADO)
                    .setParameter("tiempo", LocalDateTime.now())
                    .setParameter("numero", numeroBoleto)
                    .setParameter("estadoDisponible", EstadoBoleto.DISPONIBLE)
                    .executeUpdate();

            if (rowsUpdated == 0) {
                throw new IllegalStateException("El boleto no está disponible o ya fue apartado.");
            }

            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            throw e;
        }
    }
}
