package com.Equipo3.Backend.Chat.Dominio.Mapper;

import com.Equipo3.Backend.Chat.Dominio.ChatVO;
import com.Equipo3.Backend.Chat.Dominio.DTO.ChatDTO;

public class ChatMapper {

    public static ChatDTO toDTO(ChatVO vo) {
        return new ChatDTO()
                .withId(vo.getId())
                .withNombre(vo.getNombre())
                .withHistorial(vo.getHistorial());
    }

    //TODO: convertDTO ==>  Por ctor
    public static ChatVO fromDTO(ChatDTO dto){
        return new ChatVO()
                .withId(dto.getId())
                .withNombre(dto.getNombre())
                .withHistorial(dto.getHistorial());
    }
}
