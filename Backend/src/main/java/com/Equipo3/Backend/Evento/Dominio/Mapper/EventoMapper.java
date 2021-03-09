package com.Equipo3.Backend.Evento.Dominio.Mapper;

import com.Equipo3.Backend.Evento.Dominio.DTO.EventoDTO;
import com.Equipo3.Backend.Evento.Dominio.EventoVO;

/**
 * Clase Mapper la cual tiene los conversores
 */
public class EventoMapper {

    /**
     * Conversor de EventoVO a EventoDTO
     * @param vo
     * @return
     */
    public static EventoDTO toDTO(EventoVO vo) {
        return new EventoDTO()
                .withId(vo.getId())
                .withNombre(vo.getNombre())
                .withFecha(vo.getFecha())
                .withDescripcion(vo.getDescripcion());
    }

    /**
     * Conversor de EventoDTO a EventoVO
     * @param dto
     * @return
     */
    public static EventoVO fromDTO(EventoDTO dto) {
        return new EventoVO()
                .withId(dto.getId())
                .withNombre(dto.getNombre())
                .withFecha(dto.getFecha())
                .withDescripcion(dto.getDescripcion());
    }
}
