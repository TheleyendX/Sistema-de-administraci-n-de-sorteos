/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAOs;

import DTOs.SorteoDTO;
import Entidades.Sorteo;

/**
 *
 * @author ruben
 */
public interface ISorteoDAO {

    void crearSorteo(Sorteo sorteo);

    Sorteo obtenerSorteoPorId(Long id);

    void actualizarSorteo(Sorteo sorteo);

    void eliminarSorteo(Long id);

    void registrarSorteo(SorteoDTO sorteoDTO);

    Sorteo convertirDTOaEntidad(SorteoDTO dto);

    String consultarEstadoSorteo(Long idSorteo);

    String calcularRecaudacion(Long idSorteo);

    String mostrarBoletos(Long idSorteo);
    
    long calcularDiasRestantes(Long idSorteo);
    
    int obtenerBoletosVendidos(Long idSorteo);
    
    int obtenerBoletosApartados(Long idSorteo);
    
    int obtenerTotalBoletos(Long idSorteo);
}
