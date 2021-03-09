package com.Equipo3.Backend.Peticion.Dominio.Mapper;

import com.Equipo3.Backend.Peticion.Dominio.DTO.PeticionDTO;
import com.Equipo3.Backend.Peticion.Dominio.PeticionVO;

/**
 * Clase Mapper la cual tiene los conversores
 */
public class PeticionMapper {

    /**
     * Conversor de PeticionVO a PeticionDTO
     * @param vo
     * @return
     */
    public static PeticionDTO toDTO(PeticionVO vo) {
        return new PeticionDTO()
                .withId(vo.getId())
                .withNombre(vo.getNombre())
                .withDescripcion(vo.getDescripcion());
    }

    /**
     * Conversor de PeticionDTO a PeticionVO
     * @param dto
     * @return
     */
    public static PeticionVO fromDTO(PeticionDTO dto) {
        return new PeticionVO()
                .withId(dto.getId())
                .withNombre(dto.getNombre())
                .withDescripcion(dto.getDescripcion());
    }
}
