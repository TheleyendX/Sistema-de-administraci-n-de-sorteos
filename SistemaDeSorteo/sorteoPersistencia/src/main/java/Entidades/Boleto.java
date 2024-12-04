/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;


/**
 *
 * @author ruben
 */

/**
 * Entidad que representa un Boleto.
 */
@Entity
@Table(name = "boletos")
public class Boleto implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_boleto")
    private int idBoleto;

    @Column(name = "numero_boleto", nullable = false, length = 50)
    private String numeroBoleto;

    @Enumerated(EnumType.STRING)
    @Column(name = "estado", nullable = false)
    private EstadoBoleto estado;

    @Column(name = "tiempo_apartado")
    private LocalDateTime tiempoApartado;

    @Column(name = "id_sorteo", nullable = false)
    private int idSorteo; // Referencia unidireccional a Sorteo

    public Boleto() {}

    public Boleto(int idBoleto) {
        this.idBoleto = idBoleto;
    }

    public Boleto(String numeroBoleto, EstadoBoleto estado, LocalDateTime tiempoApartado, int idSorteo) {
        this.numeroBoleto = numeroBoleto;
        this.estado = estado;
        this.tiempoApartado = tiempoApartado;
        this.idSorteo = idSorteo;
    }

    public Boleto(int idBoleto, String numeroBoleto, EstadoBoleto estado, LocalDateTime tiempoApartado, int idSorteo) {
        this.idBoleto = idBoleto;
        this.numeroBoleto = numeroBoleto;
        this.estado = estado;
        this.tiempoApartado = tiempoApartado;
        this.idSorteo = idSorteo;
    }

    public int getIdBoleto() {
        return idBoleto;
    }

    public void setIdBoleto(int idBoleto) {
        this.idBoleto = idBoleto;
    }

    public String getNumeroBoleto() {
        return numeroBoleto;
    }

    public void setNumeroBoleto(String numeroBoleto) {
        this.numeroBoleto = numeroBoleto;
    }

    public EstadoBoleto getEstado() {
        return estado;
    }

    public void setEstado(EstadoBoleto estado) {
        this.estado = estado;
    }

    public LocalDateTime getTiempoApartado() {
        return tiempoApartado;
    }

    public void setTiempoApartado(LocalDateTime tiempoApartado) {
        this.tiempoApartado = tiempoApartado;
    }

    public int getIdSorteo() {
        return idSorteo;
    }

    public void setIdSorteo(int idSorteo) {
        this.idSorteo = idSorteo;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 67 * hash + this.idBoleto;
        hash = 67 * hash + Objects.hashCode(this.numeroBoleto);
        hash = 67 * hash + Objects.hashCode(this.estado);
        hash = 67 * hash + Objects.hashCode(this.tiempoApartado);
        hash = 67 * hash + this.idSorteo;
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
        final Boleto other = (Boleto) obj;
        if (this.idBoleto != other.idBoleto) {
            return false;
        }
        if (this.idSorteo != other.idSorteo) {
            return false;
        }
        if (!Objects.equals(this.numeroBoleto, other.numeroBoleto)) {
            return false;
        }
        if (this.estado != other.estado) {
            return false;
        }
        return Objects.equals(this.tiempoApartado, other.tiempoApartado);
    }

    @Override
    public String toString() {
        return "Boleto{" + "idBoleto=" + idBoleto + ", numeroBoleto=" + numeroBoleto + ", estado=" + estado + ", tiempoApartado=" + tiempoApartado + ", idSorteo=" + idSorteo + '}';
    }
    
    
}

