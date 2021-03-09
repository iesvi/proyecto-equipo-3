package GamerHUB.GestionUsuarios.repository.impl;

import GamerHUB.GestionUsuarios.model.Conversor;
import GamerHUB.GestionUsuarios.model.dto.UsuarioDTO;
import GamerHUB.GestionUsuarios.model.vo.UsuarioVO;
import GamerHUB.GestionUsuarios.repository.IUsuarioRepository;
import GamerHUB.Shared.conexion.ClientSocket;
import GamerHUB.Shared.util.ActionDialogs;
import GamerHUB.Shared.util.JsonMapper;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.ArrayList;


/**
 *
 */
public class UsuarioRespositorySocket implements IUsuarioRepository {

    private static ObjectMapper mapper = new ObjectMapper();
    private ClientSocket CS;


    public UsuarioRespositorySocket(ClientSocket CS) {
        this.CS = CS;
    }

    @Override
    public boolean add(UsuarioDTO usuarioDTO) {
        UsuarioVO UsVO = Conversor.dtoToVo(usuarioDTO);
        try {
            if (CS.comprobarConexion()) {
                String Json = JsonMapper.fromJavaToJson(UsVO);
                CS.sendO(Json, "add");
            } else {
                ActionDialogs.error("Error", "No se ha podido registrar en la base de datos. Se registrará solo en local.");
            }

            return true;
        } catch (IOException er) {
            er.printStackTrace();
            return false;
        }

    }

    @Override
    public boolean remove(int id) {
        return false;
    }

    @Override
    public boolean update(UsuarioVO usuarioDTO) {


        return false;
    }

    @Override
    public ArrayList<UsuarioVO> retrieveUsers() {
        ArrayList<UsuarioVO> listaUsuarios = new ArrayList<>();
        try {
            if (CS.comprobarConexion()) {
                CS.send("usuarios");
                Object o = CS.receive();
                ArrayList<UsuarioVO> listaUsuario = (ArrayList<UsuarioVO>) o;
                for (int i = 0; i < listaUsuario.size(); i++) {
                    UsuarioVO user = mapper.convertValue(listaUsuario.get(i), UsuarioVO.class);
                    listaUsuarios.add(user);
                }
            } else {
                ActionDialogs.error("Error", "No hay conexion con la base de datos. Prueba mas tarde.");
                listaUsuarios = null;
            }
        } catch (IOException er) {
            er.printStackTrace();
        }
        return listaUsuarios;
    }
}
