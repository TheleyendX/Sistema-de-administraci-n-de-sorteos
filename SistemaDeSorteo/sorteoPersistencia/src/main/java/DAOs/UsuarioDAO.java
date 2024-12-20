/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOs;

import Entidades.EstadoUsuario;
import Entidades.TipoUsuario;
import Entidades.Usuario;
import java.time.LocalDateTime;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;

/**
 *
 * @author ruben
 */
public class UsuarioDAO implements IUsuario {

    @PersistenceContext
    private EntityManager entityManager;

    public UsuarioDAO() {
        // Crear la fábrica de EntityManager
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("sorteo");
        // Crear el EntityManager
        entityManager = entityManagerFactory.createEntityManager();
    }

    // Guardar o actualizar un usuario
    @Override
    public void guardarUsuario(Usuario usuario) {
        // Iniciar una transacción
        entityManager.getTransaction().begin();
        try {
            usuario.setFechaRegistro(LocalDateTime.now());
            if (usuario.getIdUsuario() == null) {
                entityManager.persist(usuario);  // Persistir si no tiene ID
            } else {
                entityManager.merge(usuario);  // Actualizar si ya existe
            }
            // Confirmar la transacción
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            // Si ocurre un error, revertir la transacción
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            throw e;  // Relanzar el error para manejo posterior
        }
    }

    // Obtener un usuario por ID
    @Override
    public Usuario obtenerUsuarioPorId(Integer idUsuario) {
        return entityManager.find(Usuario.class, idUsuario);
    }

    // Obtener un usuario por correo electrónico
@Override
public Usuario obtenerUsuarioPorEmail(String email) {
    try {
        // Usamos una consulta nativa SQL
        String sql = "SELECT * FROM sorteo.usuarios where email = ?";
        return (Usuario) entityManager.createNativeQuery(sql, Usuario.class)
                                      .setParameter(1, email)
                                      .getSingleResult();
    } catch (NoResultException e) {
        return null;  // Usuario no encontrado
    }
}

    // Cambiar el estado de un usuario
    @Override
    public void cambiarEstadoUsuario(Integer idUsuario, EstadoUsuario estadoUsuario) {
        Usuario usuario = obtenerUsuarioPorId(idUsuario);
        if (usuario != null) {
            usuario.setEstadoUsuario(estadoUsuario);
            entityManager.merge(usuario);
        }
    }

}
