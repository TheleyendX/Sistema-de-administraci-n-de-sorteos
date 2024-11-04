/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAOs;

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

}
