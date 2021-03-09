package GamerHUB.GestionChat.repository;

import GamerHUB.GestionChat.model.dto.CanalDTO;
import GamerHUB.GestionChat.model.vo.CanalVO;
import GamerHUB.GestionPeticiones.model.dto.PeticionDTO;
import GamerHUB.GestionUsuarios.model.vo.UsuarioVO;

import java.util.List;

public interface ChatRepository {

    boolean add(CanalDTO canalDTO);

    List<CanalVO> retrieveChats();

}
