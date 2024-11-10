package DAOs;

import Conexion.ConexionBD;
import Entidades.CredencialCliente;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

/**
 *
 * @author Acer
 */
public class CredencialClienteDAO implements ICredencialCliente{

    @Override
    public void crearCredencialCliente(CredencialCliente credencialCliente) { 
    
        EntityManager entityManager = ConexionBD.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        try {
            transaction.begin();
            entityManager.persist(credencialCliente); // Guarda la credencial del cliente
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
    public CredencialCliente obtenerCredencialClientePorId(Long id) {     
    
        EntityManager entityManager = ConexionBD.getEntityManager();
        CredencialCliente credencialCliente = null;

        try {
            credencialCliente = entityManager.find(CredencialCliente.class, id); // Busca la credencial del cliente por su ID
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            entityManager.close(); // Cerrar el EntityManager
        }

        return credencialCliente;
    }

    @Override
    public void actualizarCredencialCliente(CredencialCliente credencialCliente) {
        EntityManager entityManager = ConexionBD.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        try {
            transaction.begin();
            entityManager.merge(credencialCliente); // Actualiza la credencial del cliente
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
    public void eliminarCredencialCliente(Long id) {    
        EntityManager entityManager = ConexionBD.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        try {
            transaction.begin();
            CredencialCliente credencialCliente = entityManager.find(CredencialCliente.class, id); // Busca la credencial del cliente por su ID
            if (credencialCliente != null) {
                entityManager.remove(credencialCliente); // Elimina la credencial del cliente
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
