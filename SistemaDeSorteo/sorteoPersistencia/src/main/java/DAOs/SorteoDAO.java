package DAOs;

import Conexion.ConexionBD;
import Entidades.EstadoSorteo;

import Entidades.Sorteo;
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
}
