package com.Equipo3.Backend.Evento.Dominio.Mapper;

import com.Equipo3.Backend.Evento.Dominio.DTO.EventoDTO;
import com.Equipo3.Backend.Evento.Dominio.EventoVO;
import com.Equipo3.Backend.Usuario.Dominio.Mapper.UsuarioMapper;

public class EventoMapper {
    public static EventoDTO toDTO(EventoVO vo) {
        return new EventoDTO()
                .withId(vo.getId())
                .withNombre(vo.getNombre())
                .withFecha(vo.getFecha())
                .withDescripcion(vo.getDescripcion());
    }

    //TODO: convertDTO ==>  Por ctor
    public static EventoVO fromDTO(EventoDTO dto){
        return new EventoVO()
                .withId(dto.getId())
                .withNombre(dto.getNombre())
                .withFecha(dto.getFecha())
                .withDescripcion(dto.getDescripcion());
    }


}
