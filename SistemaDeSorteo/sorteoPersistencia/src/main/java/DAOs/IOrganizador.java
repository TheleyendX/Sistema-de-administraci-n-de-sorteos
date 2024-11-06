package DAOs;

import Entidades.Organizador;

/**
 *
 * @author Acer
 */
public interface IOrganizador {
    void crearOrganizador(Organizador organizador);

    Organizador obtenerOrganizadorPorId(Long id);

    void actualizarOrganizador(Organizador organizador);

    void eliminarOrganizador(Long id);
}
