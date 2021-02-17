package com.Equipo3.Backend.Usuario.Dominio.Mapper;

import com.Equipo3.Backend.Usuario.Dominio.DTO.UsuarioDTO;
import com.Equipo3.Backend.Usuario.Dominio.UsuarioVO;

public class UsuarioMapper {


    public static UsuarioDTO toDTO(UsuarioVO vo) {
        return new UsuarioDTO()
                .withId(vo.getId())
                .withNombre(vo.getNombre())
                .withPassword(vo.getPassword())
                .withEmail(vo.getEmail())
                .withFecha_nacimiento(vo.getFecha_nacimiento())
                .withRol(vo.getRol())
                .withIdamigos(vo.getIdamigos())
                .withIdeventos(vo.getIdeventos());
    }

    //TODO: convertDTO ==>  Por ctor
    public UsuarioVO fromDTO(UsuarioDTO dto){
        return new UsuarioVO()
                .withId(dto.getId())
                .withNombre(dto.getNombre())
                .withPassword(dto.getPassword())
                .withEmail(dto.getEmail())
                .withFecha_nacimiento(dto.getFecha_nacimiento())
                .withRol(dto.getRol())
                .withIdamigos(dto.getIdamigos())
                .withIdeventos(dto.getIdeventos());
    }
}
