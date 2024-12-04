package services;

import DAOs.ISorteoDAO;
import DTOs.SorteoDTO;
import Entidades.Sorteo;
import java.util.Optional;

/**
 *
 * @author Acer
 */
public class SorteoService {

    private final ISorteoDAO sorteoDAO;

    public SorteoService(ISorteoDAO sorteoDAO) {
        this.sorteoDAO = sorteoDAO;
    }

    public SorteoDTO obtenerPorId(int idSorteo) throws Exception {
        Sorteo sorteoEntidad = Optional.ofNullable(sorteoDAO.obtenerSorteoPorId(idSorteo))
                .orElseThrow(() -> new Exception("El sorteo con ID " + idSorteo + " no existe."));

        return new SorteoDTO(
                sorteoEntidad.getIdSorteo(),
                sorteoEntidad.getNumeroInicial(),
                sorteoEntidad.getPrecioNumero(),
                sorteoEntidad.getFechaInicio(),
                sorteoEntidad.getFechaFin(),
                sorteoEntidad.getEstadoSorteo()
        );
    }

    public void registrarSorteo(SorteoDTO sorteoDTO) throws Exception {
        // Validar DTO
        sorteoDTO.validar();

        // Convertir DTO a entidad
        Sorteo sorteo = new Sorteo();
        sorteo.setNumeroInicial(sorteoDTO.getNumeroInicial());
        sorteo.setNumeroFinal(sorteoDTO.getNumeroFinal());
        sorteo.setPrecioNumero(sorteoDTO.getPrecioNumero());
        sorteo.setFechaInicio(sorteoDTO.getFechaInicio());
        sorteo.setFechaFin(sorteoDTO.getFechaFin());
        sorteo.setEstadoSorteo(sorteoDTO.getEstadoSorteo());

        // Llamar al DAO para guardar el sorteo
        sorteoDAO.crearSorteo(sorteo);
    }

    public void modificar(SorteoDTO sorteoDTO) throws Exception {
        // Validar los datos
        sorteoDTO.validar();

        // Recuperar el sorteo existente
        Sorteo sorteoExistente = Optional.ofNullable(sorteoDAO.obtenerSorteoPorId(sorteoDTO.getIdSorteo()))
                .orElseThrow(() -> new Exception("El sorteo con ID " + sorteoDTO.getIdSorteo() + " no existe."));

        // Actualizar los datos
        sorteoExistente.setNumeroInicial(sorteoDTO.getNumeroInicial());
        sorteoExistente.setNumeroFinal(sorteoDTO.getNumeroFinal());
        sorteoExistente.setPrecioNumero(sorteoDTO.getPrecioNumero());
        sorteoExistente.setFechaInicio(sorteoDTO.getFechaInicio());
        sorteoExistente.setFechaFin(sorteoDTO.getFechaFin());
        sorteoExistente.setEstadoSorteo(sorteoDTO.getEstadoSorteo());

        // Guardar cambios
        sorteoDAO.actualizarSorteo(sorteoExistente);
    }

    public void modificarSorteo(SorteoDTO nuevoSorteo) throws Exception {
        // Validar los datos del DTO
        nuevoSorteo.validar();

        // Obtener el sorteo actual desde la base de datos
        Sorteo sorteoActual = sorteoDAO.obtenerSorteoPorId(nuevoSorteo.getIdSorteo());
        if (sorteoActual == null) {
            throw new IllegalArgumentException("No se encontró el sorteo con ID: " + nuevoSorteo.getIdSorteo());
        }

        // Actualizar los datos del sorteo
        sorteoActual.setNumeroInicial(nuevoSorteo.getNumeroInicial());
        sorteoActual.setNumeroFinal(nuevoSorteo.getNumeroFinal());
        sorteoActual.setPrecioNumero(nuevoSorteo.getPrecioNumero());
        sorteoActual.setFechaInicio(nuevoSorteo.getFechaInicio());
        sorteoActual.setFechaFin(nuevoSorteo.getFechaFin());
        sorteoActual.setEstadoSorteo(nuevoSorteo.getEstadoSorteo());

        // Guardar los cambios en la base de datos
        sorteoDAO.actualizarSorteo(sorteoActual);
    }
}
