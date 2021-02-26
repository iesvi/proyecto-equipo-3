package GamerHUB.GestionEventos.repository;


import GamerHUB.GestionEventos.model.vo.EventoVO;

import java.util.List;

/**
 * Interfaz en la que se definen los métodos para las operaciones CRUD con
 * *los eventos.
 */
public interface IEventoRepository {

    /**
     * Método para registrar un nuevo evento.
     *
     * @param eventoVO
     * @return
     */
    boolean add(EventoVO eventoVO);

    /**
     * Método para eliminar un evento registrado, por su id.
     *
     * @param id
     * @return
     */
    boolean remove(int id);

    /**
     * Método para actualizar un evento.
     *
     * @param eventoVO
     * @return
     */
    boolean update(EventoVO eventoVO);

    /**
     * Método para obtener todos los eventos,asociados a un usuario.
     *
     * @return
     */
    List<EventoVO> retrieveEvents();

}
