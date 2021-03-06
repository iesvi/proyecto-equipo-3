package GamerHUB.Shared.Repository;

import GamerHUB.GestionPeticiones.model.dto.PeticionDTO;
import GamerHUB.GestionUsuarios.model.dto.UsuarioDTO;
import GamerHUB.GestionUsuarios.model.vo.UsuarioVO;
import GamerHUB.GestionPeticiones.model.vo.PeticionVO;
import GamerHUB.Shared.conexion.ClientSocket;
import java.util.List;
import GamerHUB.GestionUsuarios.model.Conversor;
import java.io.IOException;

public class DatosRepository {

    private ClientSocket clientSocket;
    public DatosRepository()  throws IOException {
        clientSocket =  new ClientSocket();
    }


    /**
     *
     * @return
     */
    public UsuarioDTO usuarioDTO(){
       UsuarioVO usuarioVO=null;
        try {
            if (clientSocket.receive() instanceof UsuarioVO)
                usuarioVO = (UsuarioVO) clientSocket.receive();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Conversor.voToDto(usuarioVO);
    }

    /**
     *
     * @return
     */
    public List<UsuarioDTO> usuarios(){

        List<UsuarioVO> usuarios=null;
        List<UsuarioDTO> usuarioDTOS=null;
        try {
            if (clientSocket.receive() instanceof List)
                usuarios = (List<UsuarioVO>) clientSocket.receive();

            for(UsuarioVO user: usuarios){
                usuarioDTOS.add(Conversor.voToDto(user));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

       return usuarioDTOS;

    }


    public PeticionDTO peticionDTO(){
        PeticionVO peticionVO = null;

        return null;
    }




}
