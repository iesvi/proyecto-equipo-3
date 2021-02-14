package GamerHUB.GestionEventos.model;

import GamerHUB.GestionEventos.model.dto.EventoDTO;
import GamerHUB.GestionEventos.model.vo.EventoVO;

public class Conversor {

    public Conversor(){

    }

    public EventoDTO dtoToVo(EventoVO eventoVO){
        EventoDTO eventoDTO = new EventoDTO();




        return eventoDTO;
    }

    public EventoVO voToDto(EventoDTO eventoDTO){
        EventoVO eventoVO = new EventoVO();

        return eventoVO;
    }


}
