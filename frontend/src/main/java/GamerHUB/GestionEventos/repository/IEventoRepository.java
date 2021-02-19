package GamerHUB.GestionEventos.repository;


import GamerHUB.GestionEventos.model.vo.EventoVO;

import java.util.List;

public interface IEventoRepository{

    /**
     *
     * @param eventoVO
     * @return
     */
    boolean add(EventoVO eventoVO);

    /**
     *
     * @param id
     * @return
     */
    boolean remove(int id);

    /**
     *
     * @param eventoVO
     * @return
     */
    boolean update(EventoVO eventoVO);

    /**
     *
     * @return
     */
    List<EventoVO> retrieveEvents();

}
