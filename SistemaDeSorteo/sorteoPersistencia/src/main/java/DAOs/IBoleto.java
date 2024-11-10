/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAOs;

import Entidades.Boleto;

/**
 *
 * @author ruben
 */
public interface IBoleto {

    void marcarComoPagado(Integer idBoleto); // Método para marcar un boleto como pagado

    void desmarcarComoPagado(Integer idBoleto); // Método para desmarcar un boleto

    Boleto obtenerBoletoPorId(Integer idBoleto); // Método para obtener un boleto por su ID

    void guardarBoleto(Boleto boleto); // Método para guardar un boleto
}
