/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTOs;

/**
 *
 * @author ruben
 */
public class LiberarNumerosDTO {

    private int idSorteo; 
    private String rangoNumeros; 

    public LiberarNumerosDTO() {
    }

    public LiberarNumerosDTO(int idSorteo, String rangoNumeros) {
        this.idSorteo = idSorteo;
        this.rangoNumeros = rangoNumeros;
    }

    public int getIdSorteo() {
        return idSorteo;
    }

    public void setIdSorteo(int idSorteo) {
        this.idSorteo = idSorteo;
    }

    public String getRangoNumeros() {
        return rangoNumeros;
    }

    public void setRangoNumeros(String rangoNumeros) {
        this.rangoNumeros = rangoNumeros;
    }

    public void validar() {
        if ( idSorteo <= 0) {
            throw new IllegalArgumentException("El ID del sorteo debe ser un número válido.");
        }
        if (rangoNumeros == null || rangoNumeros.isEmpty()) {
            throw new IllegalArgumentException("El rango de números no puede estar vacío.");
        }
    }
}
