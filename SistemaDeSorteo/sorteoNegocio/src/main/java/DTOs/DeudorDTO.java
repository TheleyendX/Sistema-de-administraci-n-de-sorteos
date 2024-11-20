/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTOs;

import java.time.LocalDateTime;

/**
 *
 * @author ruben
 */
public class DeudorDTO {

    private String nombreUsuario;
    private String email;
    private String numerosApartados;
    private float montoPendiente;
    private LocalDateTime fechaLimitePago;

    public DeudorDTO() {
    }

    public DeudorDTO(String nombreUsuario, String email, String numerosApartados, float montoPendiente, LocalDateTime fechaLimitePago) {
        this.nombreUsuario = nombreUsuario;
        this.email = email;
        this.numerosApartados = numerosApartados;
        this.montoPendiente = montoPendiente;
        this.fechaLimitePago = fechaLimitePago;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNumerosApartados() {
        return numerosApartados;
    }

    public void setNumerosApartados(String numerosApartados) {
        this.numerosApartados = numerosApartados;
    }

    public float getMontoPendiente() {
        return montoPendiente;
    }

    public void setMontoPendiente(float montoPendiente) {
        this.montoPendiente = montoPendiente;
    }

    public LocalDateTime getFechaLimitePago() {
        return fechaLimitePago;
    }

    public void setFechaLimitePago(LocalDateTime fechaLimitePago) {
        this.fechaLimitePago = fechaLimitePago;
    }
}
