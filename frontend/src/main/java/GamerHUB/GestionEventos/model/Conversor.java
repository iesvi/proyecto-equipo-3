package GamerHUB.GestionEventos.model;

import GamerHUB.GestionEventos.model.dto.EventoDTO;
import GamerHUB.GestionEventos.model.vo.EventoVO;
import javafx.beans.property.SimpleIntegerProperty;

import java.sql.Date;

/**
 *
 */
public class Conversor {

    public Conversor(){

    }

    /**
     *
     * @param eventoVO
     * @return
     */
    public EventoDTO dtoToVo(EventoVO eventoVO){
        EventoDTO eventoDTO = new EventoDTO();

        eventoDTO.setId(eventoVO.getId());
        eventoDTO.setNombre(eventoVO.getNombre());
        eventoDTO.setFecha(eventoVO.getFecha().toLocalDate());
        eventoDTO.setDescripcion(eventoVO.getDescripcion());
        eventoDTO.setUsuario(eventoVO.getUsuario());

        return eventoDTO;
    }

    /**
     *
     * @param eventoDTO
     * @return
     */
    public EventoVO voToDto(EventoDTO eventoDTO){
        EventoVO eventoVO = new EventoVO();

        eventoVO.setId(eventoDTO.getId());
        eventoVO.setNombre(eventoDTO.getNombre());
        eventoVO.setFecha(Date.valueOf(eventoDTO.getFecha()));
        eventoVO.setDescripcion(eventoDTO.getDescripcion());
        eventoVO.setUsuario(eventoDTO.getUsuario());

        return eventoVO;
    }


}
