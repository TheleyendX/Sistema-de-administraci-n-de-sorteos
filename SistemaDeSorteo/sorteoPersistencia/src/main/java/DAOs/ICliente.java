package DAOs;

import Entidades.Cliente;

/**
 *
 * @author Acer
 */
public interface ICliente {
    void crearCliente(Cliente cliente);

    Cliente obtenerClientePorId(Long id);

    void actualizarCliente(Cliente cliente);

    void eliminarCliente(Long id);
}
