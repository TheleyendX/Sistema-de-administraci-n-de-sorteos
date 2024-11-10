/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOs;
import Entidades.Boleto;
import Entidades.EstadoBoleto;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author ruben
 */
public class BoletoDAO implements IBoleto {

    @PersistenceContext
    private EntityManager entityManager;

   
    @Override
    public void marcarComoPagado(Integer idBoleto) {
        Boleto boleto = entityManager.find(Boleto.class, idBoleto);
        if (boleto != null) {
            boleto.setEstado(EstadoBoleto.PAGADO); // Actualiza el estado a "PAGADO"
            entityManager.merge(boleto); // Guarda los cambios en la base de datos
        }
    }

    @Override
    public void desmarcarComoPagado(Integer idBoleto) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Boleto obtenerBoletoPorId(Integer idBoleto) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void guardarBoleto(Boleto boleto) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
