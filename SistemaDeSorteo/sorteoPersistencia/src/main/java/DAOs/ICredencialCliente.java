package DAOs;

import Entidades.CredencialCliente;

/**
 *
 * @author Acer
 */
public interface ICredencialCliente {
    void crearCredencialCliente(CredencialCliente credencialCliente);

    CredencialCliente obtenerCredencialClientePorId(Long id);

    void actualizarCredencialCliente(CredencialCliente credencialCliente);

    void eliminarCredencialCliente(Long id);
}
