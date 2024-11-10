/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOs;

import Entidades.EstadoUsuario;
import Entidades.Usuario;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author ruben
 */
public class UsuarioDAO implements IUsuario {

    @PersistenceContext
    private EntityManager entityManager;

    // Guardar o actualizar un usuario
    @Override
    public void guardarUsuario(Usuario usuario) {
        if (usuario.getIdUsuario() == null) {
            entityManager.persist(usuario);  // Persistir si no tiene ID
        } else {
            entityManager.merge(usuario);  // Actualizar si ya existe
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
            return entityManager.createQuery("SELECT u FROM Usuario u WHERE u.email = :email", Usuario.class)
                    .setParameter("email", email)
                    .getSingleResult();
        } catch (Exception e) {
            return null;  // En caso de que no se encuentre el usuario
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
