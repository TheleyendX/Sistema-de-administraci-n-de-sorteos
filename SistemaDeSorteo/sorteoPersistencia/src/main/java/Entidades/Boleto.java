/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Entidad que representa un Boleto.
 */
@Entity
@Table(name = "boletos")
public class Boleto implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_boleto")
    private Long idBoleto;

    @ManyToOne
    @JoinColumn(name = "id_sorteo", nullable = false)
    private Sorteo sorteo;

    @Column(name = "numero_boleto", nullable = false, length = 50)
    private String numeroBoleto;

    @Enumerated(EnumType.STRING)
    @Column(name = "estado", nullable = false)
    private EstadoBoleto estado;

    public Boleto() {}

    public Boleto(Sorteo sorteo, String numeroBoleto, EstadoBoleto estado) {
        this.sorteo = sorteo;
        this.numeroBoleto = numeroBoleto;
        this.estado = estado;
    }

    public Long getIdBoleto() {
        return idBoleto;
    }

    public void setIdBoleto(Long idBoleto) {
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

    public EstadoBoleto getEstado() {
        return estado;
    }

    public void setEstado(EstadoBoleto estado) {
        this.estado = estado;
    }

    
}

