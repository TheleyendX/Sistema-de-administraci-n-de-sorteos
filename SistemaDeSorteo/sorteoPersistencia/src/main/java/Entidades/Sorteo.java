package Entidades;

import java.io.Serializable;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Objects;
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
    private int idSorteo;

    @Column(name = "imagen_representativa")
    private String imagenRepresentativa;

    @Column(name = "numero_inicial", nullable = false)
    private int numeroInicial;

    @Column(name = "numero_final", nullable = false)
    private int numeroFinal;

    @Column(name = "precio_numero", nullable = false)
    private float precioNumero;

    @Temporal(TemporalType.DATE)
    @Column(name = "fecha_inicio", nullable = false)
    private Date fechaInicio;

    @Temporal(TemporalType.DATE)
    @Column(name = "fecha_fin", nullable = false)
    private Date fechaFin;

    @Enumerated(EnumType.STRING)
    @Column(name = "estado_sorteo", nullable = false)
    private EstadoSorteo estadoSorteo;

    public Sorteo() {
        this.estadoSorteo = EstadoSorteo.ACTIVO;
    }

    public Sorteo(int idSorteo) {
        this.idSorteo = idSorteo;
    }

    public Sorteo(String imagenRepresentativa, int numeroInicial, int numeroFinal, float precioNumero, Date fechaInicio, Date fechaFin, EstadoSorteo estadoSorteo) {
        this.imagenRepresentativa = imagenRepresentativa;
        this.numeroInicial = numeroInicial;
        this.numeroFinal = numeroFinal;
        this.precioNumero = precioNumero;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.estadoSorteo = estadoSorteo;
    }

    // Getters y Setters
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

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + this.idSorteo;
        hash = 23 * hash + Objects.hashCode(this.imagenRepresentativa);
        hash = 23 * hash + this.numeroInicial;
        hash = 23 * hash + this.numeroFinal;
        hash = 23 * hash + Float.floatToIntBits(this.precioNumero);
        hash = 23 * hash + Objects.hashCode(this.fechaInicio);
        hash = 23 * hash + Objects.hashCode(this.fechaFin);
        hash = 23 * hash + Objects.hashCode(this.estadoSorteo);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Sorteo other = (Sorteo) obj;
        if (this.idSorteo != other.idSorteo) {
            return false;
        }
        if (this.numeroInicial != other.numeroInicial) {
            return false;
        }
        if (this.numeroFinal != other.numeroFinal) {
            return false;
        }
        if (Float.floatToIntBits(this.precioNumero) != Float.floatToIntBits(other.precioNumero)) {
            return false;
        }
        if (!Objects.equals(this.imagenRepresentativa, other.imagenRepresentativa)) {
            return false;
        }
        if (!Objects.equals(this.fechaInicio, other.fechaInicio)) {
            return false;
        }
        if (!Objects.equals(this.fechaFin, other.fechaFin)) {
            return false;
        }
        return this.estadoSorteo == other.estadoSorteo;
    }

    @Override
    public String toString() {
        return "Sorteo{"
                + "idSorteo=" + idSorteo
                + ", imagenRepresentativa='" + imagenRepresentativa + '\''
                + ", numeroInicial=" + numeroInicial
                + ", numeroFinal=" + numeroFinal
                + ", precioNumero=" + precioNumero
                + ", fechaInicio=" + fechaInicio
                + ", fechaFin=" + fechaFin
                + ", estadoSorteo=" + estadoSorteo
                + '}';
    }

}
