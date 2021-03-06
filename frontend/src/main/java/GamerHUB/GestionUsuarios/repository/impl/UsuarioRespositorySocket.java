package GamerHUB.GestionUsuarios.repository.impl;

import GamerHUB.GestionUsuarios.model.Conversor;
import GamerHUB.GestionUsuarios.model.dto.UsuarioDTO;
import GamerHUB.GestionUsuarios.model.vo.UsuarioVO;
import GamerHUB.GestionUsuarios.repository.IUsuarioRepository;
import GamerHUB.GestionUsuarios.repository.ListaUsuario;
import GamerHUB.MainApp;
import GamerHUB.Shared.conexion.ClientSocket;
import GamerHUB.Shared.util.ActionDialogs;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


/**
 *
 */
public class UsuarioRespositorySocket implements IUsuarioRepository{

    private ClientSocket CS;

    public UsuarioRespositorySocket() {
        CS = new ClientSocket();
    }





    private MainApp mainApp = new MainApp();

    @Override
    public boolean add(UsuarioDTO usuarioDTO) {
        UsuarioVO UsVO = Conversor.dtoToVo(usuarioDTO);
        try{
            if(CS.comprobarConexion()){
                CS.sendO(UsVO, "add");
            }
            else{
                ActionDialogs.error("Error","No se ha podido registrar en la base de datos. Se registrará solo en local.");
            }

            return true;
        }catch(IOException er) {
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
        ArrayList<UsuarioVO> listaUsuarios = new ArrayList<UsuarioVO>();
        try{
            if(CS.comprobarConexion()){
                CS.send("usuarios");
                Object o = CS.receive();
                listaUsuarios = (ArrayList<UsuarioVO>) o;
            }
            else{
                ActionDialogs.error("Error","No hay conexion con la base de datos. Prueba mas tarde.");
                listaUsuarios = null;
            }
        }catch(IOException er){
            er.printStackTrace();
        }catch (ClassNotFoundException er){
            er.printStackTrace();
        }
        return listaUsuarios;
    }
}
