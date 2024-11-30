/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

import java.io.Serializable;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import javax.persistence.*;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.bson.types.ObjectId;
import org.eclipse.persistence.jpa.jpql.parser.DateTime;
import org.jfree.data.time.DateRange;

/**
 *
 * @author ruben
 */

/**
 * Entidad que representa un Sorteo.
 */
@Entity
@Table(name = "sorteos")
public class Sorteo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_sorteo")
    private Long idSorteo;

    @Column(name = "imagen_representativa")
    private String imagenRepresentativa;

    @Column(name = "rango_numeros", nullable = false)
    private String rangoNumeros;

    @Column(name = "precio_numero", nullable = false)
    private float precioNumero;

    @Column(name = "periodo_venta")
    private Duration periodoVenta;

    @Column(name = "fecha_sorteo", nullable = false)
    private Date fechaSorteo;

    @Enumerated(EnumType.STRING)
    @Column(name = "estado_sorteo", nullable = false)
    private EstadoSorteo estadoSorteo;

    @Temporal(TemporalType.DATE)
    @Column(name = "fecha_inicio", nullable = false)
    private Date fechaInicio;

    @Temporal(TemporalType.DATE)
    @Column(name = "fecha_fin", nullable = false)
    private Date fechaFin;

    public Sorteo() { this.estadoSorteo = EstadoSorteo.ACTIVO;}
    

    public Sorteo(Long idSorteo, String imagenRepresentativa, String rangoNumeros, float precioNumero, Duration periodoVenta, Date fechaSorteo, EstadoSorteo estadoSorteo, Date fechaInicio, Date fechaFin) {
        this.idSorteo = idSorteo;
        this.imagenRepresentativa = imagenRepresentativa;
        this.rangoNumeros = rangoNumeros;
        this.precioNumero = precioNumero;
        this.periodoVenta = periodoVenta;
        this.fechaSorteo = fechaSorteo;
        this.estadoSorteo = estadoSorteo;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
    }

    public Sorteo(String imagenRepresentativa, String rangoNumeros, float precioNumero, 
                  Duration periodoVenta, Date fechaSorteo, EstadoSorteo estadoSorteo, 
                  Date fechaInicio, Date fechaFin) {
        this.imagenRepresentativa = imagenRepresentativa;
        this.rangoNumeros = rangoNumeros;
        this.precioNumero = precioNumero;
        this.periodoVenta = periodoVenta;
        this.fechaSorteo = fechaSorteo;
        this.estadoSorteo = estadoSorteo;
        this.fechaInicio = fechaInicio;
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

    public Duration getPeriodoVenta() {
        return periodoVenta;
    }

    public void setPeriodoVenta(Duration periodoVenta) {
        this.periodoVenta = periodoVenta;
    }

    public Date getFechaSorteo() {
        return fechaSorteo;
    }

    public void setFechaSorteo(Date fechaSorteo) {
        this.fechaSorteo = fechaSorteo;
    }

    public EstadoSorteo getEstadoSorteo() {
        return estadoSorteo;
    }

    public void setEstadoSorteo(EstadoSorteo estadoSorteo) {
        this.estadoSorteo = estadoSorteo;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    
}

