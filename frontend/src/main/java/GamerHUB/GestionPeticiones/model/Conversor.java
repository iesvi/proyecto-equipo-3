package GamerHUB.GestionPeticiones.model;

import GamerHUB.GestionPeticiones.model.dto.PeticionDTO;
import GamerHUB.GestionPeticiones.model.vo.PeticionVO;

/**
 *
 */
public class Conversor {

    public Conversor() {
    }

    /**
     *
     * @param peticionVO
     * @return
     */
    public static PeticionDTO voToDto(PeticionVO peticionVO) {

        PeticionDTO peticionDTO = new PeticionDTO();

        peticionDTO.setId(peticionDTO.getId());
        peticionDTO.setNombre(peticionVO.getNombre());
        peticionDTO.setDescripcion(peticionVO.getDescripcion());
        peticionDTO.setId_usuario(peticionVO.getId());
        peticionDTO.setEstado(peticionVO.isEstado());

        return peticionDTO;
    }

    /**
     *
     * @param peticionDTO
     * @return
     */
    public static PeticionVO dtoToVo(PeticionDTO peticionDTO) {

        PeticionVO peticionVO = new PeticionVO();

        peticionVO.setId(peticionDTO.getId());
        peticionVO.setNombre(peticionDTO.getRespuesta());
        peticionVO.setDescripcion(peticionDTO.getDescripcion());
        peticionVO.setRespuesta(peticionDTO.getRespuesta());
        peticionVO.setEstado(peticionDTO.isEstado());


        return peticionVO;
    }

}
