/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "usuarios")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idUsuario;

    private String nombre;
   
    private String apellido;

    private String email;

    @Enumerated(EnumType.STRING)
    private TipoUsuario tipoUsuario;

    private LocalDateTime fechaRegistro;

    @Enumerated(EnumType.STRING)
    private EstadoUsuario estadoUsuario;
    private String contrasena;

    public Usuario() {
    }

    public Usuario(String nombre, String apellido, String email, TipoUsuario tipoUsuario, String contrasena) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.tipoUsuario = tipoUsuario;
        this.contrasena = contrasena;
    }

    
    public Usuario(Integer idUsuario, String nombre,String apellido, String email, TipoUsuario tipoUsuario, LocalDateTime fechaRegistro, EstadoUsuario estadoUsuario, String contrasena) {
        this.idUsuario = idUsuario;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.tipoUsuario = tipoUsuario;
        this.fechaRegistro = fechaRegistro;
        this.estadoUsuario = estadoUsuario;
        this.contrasena = contrasena;
    }

    public Usuario(Integer idUsuario, String nombre,String apellido, String email, TipoUsuario tipoUsuario, String contrasena) {
        this.idUsuario = idUsuario;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.tipoUsuario = tipoUsuario;
        this.contrasena = contrasena;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    
    

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public TipoUsuario getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(TipoUsuario tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public LocalDateTime getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(LocalDateTime fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public EstadoUsuario getEstadoUsuario() {
        return estadoUsuario;
    }

    public void setEstadoUsuario(EstadoUsuario estadoUsuario) {
        this.estadoUsuario = estadoUsuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

}
