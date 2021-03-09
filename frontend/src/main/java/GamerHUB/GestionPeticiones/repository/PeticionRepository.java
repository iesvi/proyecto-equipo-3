package GamerHUB.GestionPeticiones.repository;

import GamerHUB.GestionPeticiones.model.dto.PeticionDTO;

public interface PeticionRepository {

    boolean add(PeticionDTO peticionDTO);
}
