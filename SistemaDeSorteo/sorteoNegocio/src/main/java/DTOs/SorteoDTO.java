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
    private int numeroInicial;
    private int numeroFinal;
    private float precioNumero;
    private Date fechaInicio;
    private Date fechaFin;
    private EstadoSorteo estadoSorteo;

    public SorteoDTO() {
    }

    public SorteoDTO(int idSorteo, int numeroInicial, int numeroFinal, float precioNumero, Date fechaInicio, Date fechaFin, EstadoSorteo estadoSorteo) {
        this.idSorteo = idSorteo;
        this.numeroInicial = numeroInicial;
        this.numeroFinal = numeroFinal;
        this.precioNumero = precioNumero;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.estadoSorteo = estadoSorteo;
    }

    public SorteoDTO(int numeroInicial, int numeroFinal, float precioNumero, Date fechaInicio, Date fechaFin, EstadoSorteo estadoSorteo) {
        this.numeroInicial = numeroInicial;
        this.numeroFinal = numeroFinal;
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

    public int getNumeroInicial() {
        return numeroInicial;
    }

    public void setNumeroInicial(int numeroInicial) {
        this.numeroInicial = numeroInicial;
    }

    public int getNumeroFinal() {
        return numeroFinal;
    }

    public void setNumeroFinal(int numeroFinal) {
        this.numeroFinal = numeroFinal;
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
        if (numeroInicial < 0 || numeroFinal < 0 || numeroFinal < numeroInicial) {
            throw new IllegalArgumentException("El rango de números es inválido. Asegúrate de que el número final sea mayor o igual al número inicial y que ambos sean no negativos.");
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
