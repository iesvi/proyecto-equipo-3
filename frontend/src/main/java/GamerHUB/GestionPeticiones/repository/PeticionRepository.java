package GamerHUB.GestionPeticiones.repository;

import GamerHUB.GestionPeticiones.model.dto.PeticionDTO;
import GamerHUB.GestionUsuarios.model.dto.UsuarioDTO;

public interface PeticionRepository {

    boolean add(PeticionDTO peticionDTO);
}
