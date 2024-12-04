package DTOs;

import DAOs.SorteoDAO;
import Entidades.EstadoSorteo;
import Entidades.Sorteo;
import java.time.LocalDateTime;
import java.util.Date;

/**
 *
 * @author ruben
 */
public class SorteoDTO {

    private int idSorteo;
    private String imagenRepresentativa;
    private String rangoNumeros;
    private float precioNumero;
    private Date fechaInicio;
    private Date fechaFin;
    private EstadoSorteo estadoSorteo;

    public SorteoDTO() {}

    public SorteoDTO(int idSorteo, String imagenRepresentativa, String rangoNumeros, float precioNumero, Date fechaInicio, Date fechaFin, EstadoSorteo estadoSorteo) {
        this.idSorteo = idSorteo;
        this.imagenRepresentativa = imagenRepresentativa;
        this.rangoNumeros = rangoNumeros;
        this.precioNumero = precioNumero;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.estadoSorteo = estadoSorteo;
    }

    public SorteoDTO(String imagenRepresentativa, String rangoNumeros, float precioNumero, Date fechaInicio, Date fechaFin, EstadoSorteo estadoSorteo) {
        this.imagenRepresentativa = imagenRepresentativa;
        this.rangoNumeros = rangoNumeros;
        this.precioNumero = precioNumero;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.estadoSorteo = estadoSorteo;
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

    public EstadoSorteo getEstadoSorteo() {
        return estadoSorteo;
    }

    public void setEstadoSorteo(EstadoSorteo estadoSorteo) {
        this.estadoSorteo = estadoSorteo;
    }

    public void validar() throws IllegalArgumentException {
        if (rangoNumeros == null || rangoNumeros.isEmpty()) {
            throw new IllegalArgumentException("El rango de números no puede estar vacío.");
        }
        if (precioNumero <= 0) {
            throw new IllegalArgumentException("El precio del número debe ser mayor a cero.");
        }
        if (fechaInicio == null) {
            throw new IllegalArgumentException("La fecha de inicio no puede estar vacía.");
        }
        if (fechaFin == null) {
            throw new IllegalArgumentException("La fecha de fin no puede estar vacía.");
        }
        if (!fechaFin.after(fechaInicio)) {
            throw new IllegalArgumentException("La fecha de fin debe ser posterior a la fecha de inicio.");
        }
    }
}