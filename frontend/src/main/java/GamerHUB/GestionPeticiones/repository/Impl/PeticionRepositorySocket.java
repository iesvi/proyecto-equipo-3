package GamerHUB.GestionPeticiones.repository.Impl;

import GamerHUB.GestionPeticiones.model.Conversor;
import GamerHUB.GestionPeticiones.model.dto.PeticionDTO;
import GamerHUB.GestionPeticiones.model.vo.PeticionVO;
import GamerHUB.GestionPeticiones.repository.PeticionRepository;
import GamerHUB.Shared.conexion.ClientSocket;
import GamerHUB.Shared.util.ActionDialogs;
import GamerHUB.Shared.util.JsonMapper;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class PeticionRepositorySocket implements PeticionRepository {

    private static ObjectMapper mapper = new ObjectMapper();
    private ClientSocket CS;


    public PeticionRepositorySocket(ClientSocket CS) {
        this.CS = CS;
    }

    @Override
    public boolean add(PeticionDTO peticionDTO) {
        PeticionVO PeVO = Conversor.dtoToVo(peticionDTO);
        try {
            if (CS.comprobarConexion()) {
                String Json = JsonMapper.fromJavaToJson(PeVO);
                CS.sendO(Json, "peticion");
            } else {
                ActionDialogs.error("Error", "No se ha podido registrar en la base de datos. Se registrará solo en local.");
            }

            return true;
        } catch (IOException er) {
            er.printStackTrace();
            return false;
        }

    }
}
