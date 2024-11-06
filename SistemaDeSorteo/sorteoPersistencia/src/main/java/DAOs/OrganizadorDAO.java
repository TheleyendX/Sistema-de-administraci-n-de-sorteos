package DAOs;

import Conexion.ConexionBD;
import Entidades.Organizador;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

/**
 *
 * @author Acer
 */
public class OrganizadorDAO implements IOrganizador{

    @Override
    public void crearOrganizador(Organizador organizador) {
    
        EntityManager entityManager = ConexionBD.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        try {
            transaction.begin();
            entityManager.persist(organizador); // Guarda el organizador
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
    public Organizador obtenerOrganizadorPorId(Long id) {
        
        EntityManager entityManager = ConexionBD.getEntityManager();
        Organizador organizador = null;

        try {
            organizador = entityManager.find(Organizador.class, id); // Busca el organizador por su ID
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            entityManager.close(); // Cerrar el EntityManager
        }

        return organizador;
    }

    @Override
    public void actualizarOrganizador(Organizador organizador) {

        EntityManager entityManager = ConexionBD.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        try {
            transaction.begin();
            entityManager.merge(organizador); // Actualiza el organizador
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
    public void eliminarOrganizador(Long id) {

        EntityManager entityManager = ConexionBD.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        try {
            transaction.begin();
            Organizador organizador = entityManager.find(Organizador.class, id); // Busca el organizador por su ID
            if (organizador != null) {
                entityManager.remove(organizador); // Elimina el organizador
            }
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
    
}
