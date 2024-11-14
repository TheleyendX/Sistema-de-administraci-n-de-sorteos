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
public class SorteoDTO {

    private int idSorteo;
    private String imagenRepresentativa;
    private String rangoNumeros;
    private float precioNumero;
    private LocalDateTime fechaSorteo;
    private LocalDateTime fechaFin;

    public SorteoDTO() {
    }

    public SorteoDTO(int idSorteo, String imagenRepresentativa, String rangoNumeros, float precioNumero, LocalDateTime fechaSorteo, LocalDateTime fechaFin) {
        this.idSorteo = idSorteo;
        this.imagenRepresentativa = imagenRepresentativa;
        this.rangoNumeros = rangoNumeros;
        this.precioNumero = precioNumero;
        this.fechaSorteo = fechaSorteo;
        this.fechaFin = fechaFin;
    }

    public int getIdSorteo() {
        return idSorteo;
    }

    public void setIdSorteo(int idSorteo) {
        this.idSorteo = idSorteo;
    }

    public String getImagenRepresentativa() {
        return imagenRepresentativa;
    }

    public void setImagenRepresentativa(String imagenRepresentativa) {
        this.imagenRepresentativa = imagenRepresentativa;
    }

    public String getRangoNumeros() {
        return rangoNumeros;
    }

    public void setRangoNumeros(String rangoNumeros) {
        this.rangoNumeros = rangoNumeros;
    }

    public float getPrecioNumero() {
        return precioNumero;
    }

    public void setPrecioNumero(float precioNumero) {
        this.precioNumero = precioNumero;
    }

    public LocalDateTime getFechaSorteo() {
        return fechaSorteo;
    }

    public void setFechaSorteo(LocalDateTime fechaSorteo) {
        this.fechaSorteo = fechaSorteo;
    }

    public LocalDateTime getFechaFin() { // Getter para fechaFin
        return fechaFin;
    }

    public void setFechaFin(LocalDateTime fechaFin) { // Setter para fechaFin
        this.fechaFin = fechaFin;
    }

    public void validar() throws IllegalArgumentException {
        if (idSorteo <= 0) {
            throw new IllegalArgumentException("El ID del sorteo debe ser un número positivo.");
        }
        if (rangoNumeros == null || rangoNumeros.isEmpty()) {
            throw new IllegalArgumentException("El rango de números no puede estar vacío.");
        }
        if (precioNumero <= 0) {
            throw new IllegalArgumentException("El precio del número debe ser mayor a cero.");
        }
        if (fechaSorteo == null) {
            throw new IllegalArgumentException("La fecha del sorteo no puede estar vacía.");
        }
    }
}
