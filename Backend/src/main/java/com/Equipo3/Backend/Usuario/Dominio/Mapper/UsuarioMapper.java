package com.Equipo3.Backend.Usuario.Dominio.Mapper;

import com.Equipo3.Backend.Usuario.Dominio.DTO.UsuarioDTO;
import com.Equipo3.Backend.Usuario.Dominio.UsuarioVO;

import java.util.ArrayList;
import java.util.List;

public class UsuarioMapper {

//    public static List<UsuarioDTO> ToListDto(List<UsuarioVO> lista) {
//        List<UsuarioDTO> listaDTO = new ArrayList<>();
//        for (int i=0; i<lista.size();i++){
//
//        }
//
//    }

    public static UsuarioDTO toDTO(UsuarioVO vo) {
        return new UsuarioDTO()
                .withId(vo.getId())
                .withNombre(vo.getNombre())
                .withPassword(vo.getPassword())
                .withEmail(vo.getEmail())
                .withFecha_nacimiento(vo.getFecha_nacimiento())
                .withRol(vo.getRol());
    }

    //TODO: convertDTO ==>  Por ctor
    public static UsuarioVO fromDTO(UsuarioDTO dto){
        return new UsuarioVO()
                .withId(dto.getId())
                .withNombre(dto.getNombre())
                .withPassword(dto.getPassword())
                .withEmail(dto.getEmail())
                .withFecha_nacimiento(dto.getFecha_nacimiento())
                .withRol(dto.getRol());
    }
}
