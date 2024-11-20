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

/**
 *
 * @author ruben
 */
@Entity
@Table(name = "boletos")
public class Boleto implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idBoleto;

    @ManyToOne
    @JoinColumn(name = "idSorteo", nullable = false)
    private Sorteo sorteo;

    @Column(name = "numero_boleto", nullable = false)
    private String numeroBoleto;

    @Enumerated(EnumType.STRING)
    @Column(name = "estado", nullable = false)
    private EstadoBoleto estado;

    @Column(name = "tiempo_apartado")
    private LocalDateTime tiempoApartado;  


    public Boleto() {
    }

    public Boleto(Sorteo sorteo, String numeroBoleto, EstadoBoleto estado) {
        this.sorteo = sorteo;
        this.numeroBoleto = numeroBoleto;
        this.estado = estado;
    }

    public Integer getIdBoleto() {
        return idBoleto;
    }

    public void setIdBoleto(Integer idBoleto) {
        this.idBoleto = idBoleto;
    }

    public Sorteo getSorteo() {
        return sorteo;
    }

    public void setSorteo(Sorteo sorteo) {
        this.sorteo = sorteo;
    }

    public String getNumeroBoleto() {
        return numeroBoleto;
    }

    public void setNumeroBoleto(String numeroBoleto) {
        this.numeroBoleto = numeroBoleto;
    }

    

    public LocalDateTime getTiempoApartado() {
        return tiempoApartado;
    }

    public void setTiempoApartado(LocalDateTime tiempoApartado) {
        this.tiempoApartado = tiempoApartado;
    }

    public EstadoBoleto getEstado() {
        return estado;
    }

    public void setEstado(EstadoBoleto estado) {
        this.estado = estado;
    }

}
