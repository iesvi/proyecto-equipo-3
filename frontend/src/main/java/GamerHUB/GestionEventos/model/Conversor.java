package GamerHUB.GestionEventos.model;

import GamerHUB.GestionEventos.model.dto.EventoDTO;
import GamerHUB.GestionEventos.model.vo.EventoVO;
import javafx.beans.property.SimpleIntegerProperty;

import java.sql.Date;

/**
 * Clase conversor de la entidad Evento. Convierte tipos VO a DTO y viceversa
 * según los datos que maneja la aplicación (DTO) y los que se persisten en la BBDD (VO).
 */
public class Conversor {

    public Conversor(){

    }

    /**
     *Convierte un objeto tipo EventoDTO a EventoVO
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
     * Convierte un objeto tipo EventoVO a EventoDTO
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
