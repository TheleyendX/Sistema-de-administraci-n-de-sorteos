/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOs;

import Conexion.ConexionBD;

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
            Sorteo sorteo = entityManager.find(Sorteo.class, id); // Busca el sorteo por su ID
            if (sorteo != null) {
                entityManager.remove(sorteo); // Elimina el sorteo
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
