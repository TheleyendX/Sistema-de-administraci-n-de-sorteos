/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTOs;

import java.time.LocalDateTime;
import java.util.Date;

/**
 *
 * @author ruben
 */
public class SorteoDTO {

    private Long idSorteo;
    private String imagenRepresentativa;
    private String rangoNumeros;
    private float precioNumero;
    private Date fechaSorteo;
    private Date fechaFin;

    public SorteoDTO() {
    }

    public SorteoDTO(Long idSorteo, String imagenRepresentativa, String rangoNumeros, float precioNumero, Date fechaSorteo, Date fechaFin) {
        this.idSorteo = idSorteo;
        this.imagenRepresentativa = imagenRepresentativa;
        this.rangoNumeros = rangoNumeros;
        this.precioNumero = precioNumero;
        this.fechaSorteo = fechaSorteo;
        this.fechaFin = fechaFin;
    }

    public Long getIdSorteo() {
        return idSorteo;
    }

    public void setIdSorteo(Long idSorteo) {
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

    public Date getFechaSorteo() {
        return fechaSorteo;
    }

    public void setFechaSorteo(Date fechaSorteo) {
        this.fechaSorteo = fechaSorteo;
    }
    
    

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public void validar() throws IllegalArgumentException {
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
