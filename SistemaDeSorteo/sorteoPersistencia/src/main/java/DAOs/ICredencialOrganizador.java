package DAOs;

import Entidades.CredencialOrganizador;

/**
 *
 * @author Acer
 */
public interface ICredencialOrganizador {
    void crearCredencialOrganizador(CredencialOrganizador credencialOrganizador);

    CredencialOrganizador obtenerCredencialOrganizadorPorId(Long id);

    void actualizarCredencialOrganizador(CredencialOrganizador credencialOrganizador);

    void eliminarCredencialOrganizador(Long id);
}
