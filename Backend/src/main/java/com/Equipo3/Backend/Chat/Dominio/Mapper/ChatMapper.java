package com.Equipo3.Backend.Chat.Dominio.Mapper;

import com.Equipo3.Backend.Chat.Dominio.ChatVO;
import com.Equipo3.Backend.Chat.Dominio.DTO.ChatDTO;

/**
 * Clase Mapper la cual tiene los conversores
 */
public class ChatMapper {

    /**
     * Conversor de ChatVO a ChatDTO
     *
     * @param vo
     * @return
     */
    public static ChatDTO toDTO(ChatVO vo) {
        return new ChatDTO()
                .withId(vo.getId())
                .withNombre(vo.getNombre())
                .withPuerto(vo.getPuerto());
    }

    /**
     * Conversor de ChatDTO a ChatVO
     *
     * @param dto
     * @return
     */
    public static ChatVO fromDTO(ChatDTO dto) {
        return new ChatVO()
                .withId(dto.getId())
                .withNombre(dto.getNombre())
                .withPuerto(dto.getPuerto());
    }
}
