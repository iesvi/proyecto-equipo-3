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
     * @param peticionVO
     * @return
     */
    public static PeticionDTO voToDto(PeticionVO peticionVO) {

        PeticionDTO peticionDTO = new PeticionDTO();

        peticionDTO.setId(peticionVO.getId());
        peticionDTO.setNombre(peticionVO.getNombre());
        peticionDTO.setDescripcion(peticionVO.getDescripcion());

        return peticionDTO;
    }

    /**
     * @param peticionDTO
     * @return
     */
    public static PeticionVO dtoToVo(PeticionDTO peticionDTO) {

        PeticionVO peticionVO = new PeticionVO();

        peticionVO.setId(peticionDTO.getId());
        peticionVO.setNombre(peticionDTO.getNombre());
        peticionVO.setDescripcion(peticionDTO.getDescripcion());


        return peticionVO;
    }

}
