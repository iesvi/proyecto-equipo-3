package GamerHUB.GestionChat.model;

import GamerHUB.GestionChat.model.dto.CanalDTO;
import GamerHUB.GestionChat.model.vo.CanalVO;
import GamerHUB.GestionPeticiones.model.dto.PeticionDTO;
import GamerHUB.GestionPeticiones.model.vo.PeticionVO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ConversorCanal {

    public static CanalDTO voToDto(CanalVO canalVO) {

        CanalDTO canalDTO = new CanalDTO(canalVO.getId(),canalVO.getNombre(),canalVO.getPuerto());

        return canalDTO;
    }

    /**
     *
     * @param canalDTO
     * @return
     */
    public static CanalVO dtoToVo(CanalDTO canalDTO) {

        CanalVO canalVO = new CanalVO(canalDTO.getId(), canalDTO.getNombre(), canalDTO.getPuerto());



        return canalVO;
    }
}
