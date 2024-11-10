/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAOs;

import Entidades.EstadoUsuario;
import Entidades.Usuario;

/**
 *
 * @author ruben
 */
public interface IUsuario {

    public void guardarUsuario(Usuario usuario);

    public Usuario obtenerUsuarioPorId(Integer idUsuario);

    public Usuario obtenerUsuarioPorEmail(String email);

    public void cambiarEstadoUsuario(Integer idUsuario, EstadoUsuario estadoUsuario);
}
