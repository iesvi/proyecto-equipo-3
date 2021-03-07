package com.Equipo3.Backend.Peticion.Dominio.Mapper;

import com.Equipo3.Backend.Evento.Dominio.DTO.EventoDTO;
import com.Equipo3.Backend.Evento.Dominio.EventoVO;
import com.Equipo3.Backend.Peticion.Dominio.DTO.PeticionDTO;
import com.Equipo3.Backend.Peticion.Dominio.PeticionVO;

public class PeticionMapper {
    public static PeticionDTO toDTO(PeticionVO vo) {
        return new PeticionDTO()
                .withId(vo.getId())
                .withNombre(vo.getNombre())
                .withDescripcion(vo.getDescripcion());
    }

    //TODO: convertDTO ==>  Por ctor
    public static PeticionVO fromDTO(PeticionDTO dto){
        return new PeticionVO()
                .withId(dto.getId())
                .withNombre(dto.getNombre())
                .withDescripcion(dto.getDescripcion());
    }
}
