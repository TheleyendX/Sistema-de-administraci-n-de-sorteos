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

    
    /**
     * Crea un nuevo sorteo en la base de datos.
     * @param sorteo El sorteo a crear.
     */
    void crearSorteo(Sorteo sorteo);

    /**
     * Obtiene un sorteo por su ID.
     * @param id El ID del sorteo a buscar.
     * @return El sorteo encontrado o null si no existe.
     */
    Sorteo obtenerSorteoPorId(int id);

    /**
     * Actualiza un sorteo existente en la base de datos.
     * @param sorteo El sorteo con los datos actualizados.
     */
    void actualizarSorteo(Sorteo sorteo);

    /**
     * Elimina un sorteo de la base de datos por su ID.
     * @param id El ID del sorteo a eliminar.
     */
    void eliminarSorteo(int id);

    /**
     * Consulta el estado de un sorteo.
     * @param idSorteo El ID del sorteo.
     * @return El estado del sorteo como cadena de texto.
     */
    String consultarEstadoSorteo(int idSorteo);

    /**
     * Calcula la recaudación total de un sorteo.
     * @param idSorteo El ID del sorteo.
     * @return La recaudación como cadena de texto.
     */
    String calcularRecaudacion(int idSorteo);

    /**
     * Muestra los boletos asociados a un sorteo.
     * @param idSorteo El ID del sorteo.
     * @return Una cadena de texto con los boletos.
     */
    String mostrarBoletos(int idSorteo);

    /**
     * Calcula los días restantes para el fin de un sorteo.
     * @param idSorteo El ID del sorteo.
     * @return Los días restantes como un número entero.
     */
    long calcularDiasRestantes(int idSorteo);

    /**
     * Obtiene la cantidad de boletos vendidos de un sorteo.
     * @param idSorteo El ID del sorteo.
     * @return El número de boletos vendidos.
     */
    int obtenerBoletosVendidos(int idSorteo);

    /**
     * Obtiene la cantidad de boletos apartados de un sorteo.
     * @param idSorteo El ID del sorteo.
     * @return El número de boletos apartados.
     */
    int obtenerBoletosApartados(int idSorteo);

    /**
     * Obtiene el total de boletos de un sorteo.
     * @param idSorteo El ID del sorteo.
     * @return El número total de boletos.
     */
    int obtenerTotalBoletos(int idSorteo);
}
