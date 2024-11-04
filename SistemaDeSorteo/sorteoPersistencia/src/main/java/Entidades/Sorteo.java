/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

import java.io.Serializable;
import java.time.Duration;
import java.time.LocalDateTime;
import org.bson.types.ObjectId;
import org.eclipse.persistence.jpa.jpql.parser.DateTime;
import org.jfree.data.time.DateRange;

/**
 *
 * @author ruben
 */

public class Sorteo implements Serializable {

    private ObjectId idSorteo;
    private String imagenRepresentativa;
    private String rangoNumeros;
    private float precioNumero; 
    private Duration periodoVenta;
    private LocalDateTime fechaSorteo;
    private EstadoSorteo estadoSorteo; 

    

    public Sorteo() {
    }

    public Sorteo(ObjectId idSorteo, String imagenRepresentativa, String rangoNumeros, float precioNumero, Duration periodoVenta, LocalDateTime fechaSorteo, EstadoSorteo estadoSorteo) {
        this.idSorteo = idSorteo;
        this.imagenRepresentativa = imagenRepresentativa;
        this.rangoNumeros = rangoNumeros;
        this.precioNumero = precioNumero;
        this.periodoVenta = periodoVenta;
        this.fechaSorteo = fechaSorteo;
        this.estadoSorteo = estadoSorteo;
    }

    public ObjectId getIdSorteo() {
        return idSorteo;
    }

    public void setIdSorteo(ObjectId idSorteo) {
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

    public Duration getPeriodoVenta() {
        return periodoVenta;
    }

    public void setPeriodoVenta(Duration periodoVenta) {
        this.periodoVenta = periodoVenta;
    }

    public LocalDateTime getFechaSorteo() {
        return fechaSorteo;
    }

    public void setFechaSorteo(LocalDateTime fechaSorteo) {
        this.fechaSorteo = fechaSorteo;
    }

    public EstadoSorteo getEstadoSorteo() {
        return estadoSorteo;
    }

    public void setEstadoSorteo(EstadoSorteo estadoSorteo) {
        this.estadoSorteo = estadoSorteo;
    }

    
   

}

