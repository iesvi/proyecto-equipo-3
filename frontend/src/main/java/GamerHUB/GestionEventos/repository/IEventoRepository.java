package GamerHUB.GestionEventos.repository;


import GamerHUB.GestionEventos.model.vo.EventoVO;

import java.util.List;

public interface IEventoRepository{

    boolean add(EventoVO eventoVO);
    boolean remove(int id);
    boolean update(EventoVO eventoVO);
    List<EventoVO> retrieveEvents();

}
