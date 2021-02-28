package com.Equipo3.Backend.Evento.Dominio.Mapper;

import com.Equipo3.Backend.Evento.Dominio.DTO.EventoDTO;
import com.Equipo3.Backend.Evento.Dominio.EventoVO;

public class EventoMapper {
    public static EventoDTO toDTO(EventoVO vo) {
        return new EventoDTO()
                .withId(vo.getId())
                .withNombre(vo.getNombre())
                .withFecha(vo.getFecha())
                .withIdusuario(vo.getIdusuario())
                .withDescripcion(vo.getDescripcion());
    }

    //TODO: convertDTO ==>  Por ctor
    public static EventoVO fromDTO(EventoDTO dto){
        return new EventoVO()
                .withId(dto.getId())
                .withNombre(dto.getNombre())
                .withFecha(dto.getFecha())
                .withIdusuario(dto.getIdusuario())
                .withDescripcion(dto.getDescripcion());
    }


}
