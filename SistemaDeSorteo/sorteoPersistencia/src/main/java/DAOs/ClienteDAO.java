package DAOs;

import Conexion.ConexionBD;
import Entidades.Cliente;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

/**
 *
 * @author Acer
 */
public class ClienteDAO implements ICliente{

    @Override
    public void crearCliente(Cliente cliente) {
        EntityManager entityManager = ConexionBD.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        try {
            transaction.begin();
            entityManager.persist(cliente); // Guarda el cliente
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
    public Cliente obtenerClientePorId(Long id) {
                EntityManager entityManager = ConexionBD.getEntityManager();
        Cliente cliente = null;

        try {
            cliente = entityManager.find(Cliente.class, id); // Busca el cliente por su ID
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            entityManager.close(); // Cerrar el EntityManager
        }

        return cliente;
    }

    @Override
    public void actualizarCliente(Cliente cliente) {
        EntityManager entityManager = ConexionBD.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        try {
            transaction.begin();
            entityManager.merge(cliente); // Actualiza el cliente
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
    public void eliminarCliente(Long id) {
            EntityManager entityManager = ConexionBD.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        try {
            transaction.begin();
            Cliente cliente = entityManager.find(Cliente.class, id); // Busca el cliente por su ID
            if (cliente != null) {
                entityManager.remove(cliente); // Elimina el cliente
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
