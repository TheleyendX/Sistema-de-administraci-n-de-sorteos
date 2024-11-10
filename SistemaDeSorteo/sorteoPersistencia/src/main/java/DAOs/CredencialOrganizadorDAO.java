
package DAOs;

import Conexion.ConexionBD;
import Entidades.CredencialOrganizador;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

/**
 *
 * @author Acer
 */
public class CredencialOrganizadorDAO implements ICredencialOrganizador {

    @Override
    public void crearCredencialOrganizador(CredencialOrganizador credencialOrganizador) {
        EntityManager entityManager = ConexionBD.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        try {
            transaction.begin();
            entityManager.persist(credencialOrganizador); // Guarda la credencial del organizador
            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback(); // Deshacer cambios en caso de error
            }
            e.printStackTrace(); // Considera usar un framework de logging
        } finally {
            entityManager.close(); // Cerrar el EntityManager
        }
    }

    @Override
    public CredencialOrganizador obtenerCredencialOrganizadorPorId(Long id) {   
        EntityManager entityManager = ConexionBD.getEntityManager();
        CredencialOrganizador credencialOrganizador = null;

        try {
            credencialOrganizador = entityManager.find(CredencialOrganizador.class, id); // Busca la credencial del organizador por su ID
        } catch (Exception e) {
            e.printStackTrace(); // Considera usar un framework de logging
        } finally {
            entityManager.close(); // Cerrar el EntityManager
        }

        return credencialOrganizador;
    }

    @Override
    public void actualizarCredencialOrganizador(CredencialOrganizador credencialOrganizador) {
        EntityManager entityManager = ConexionBD.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        try {
            transaction.begin();
            entityManager.merge(credencialOrganizador); // Actualiza la credencial del organizador
            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback(); // Deshacer cambios en caso de error
            }
            e.printStackTrace(); // Considera usar un framework de logging
        } finally {
            entityManager.close(); // Cerrar el EntityManager
        }
    }

    @Override
    public void eliminarCredencialOrganizador(Long id) {
        EntityManager entityManager = ConexionBD.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        try {
            transaction.begin();
            CredencialOrganizador credencialOrganizador = entityManager.find(CredencialOrganizador.class, id); // Busca la credencial del organizador por su ID
            if (credencialOrganizador != null) {
                entityManager.remove(credencialOrganizador); // Elimina la credencial del organizador
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback(); // Deshacer cambios en caso de error
            }
            e.printStackTrace(); // Considera usar un framework de logging
        } finally {
            entityManager.close(); // Cerrar el EntityManager
        }
    }
}