package GamerHUB.GestionUsuarios.repository.impl;

import GamerHUB.GestionUsuarios.model.Conversor;
import GamerHUB.GestionUsuarios.model.dto.UsuarioDTO;
import GamerHUB.GestionUsuarios.model.vo.UsuarioVO;
import GamerHUB.GestionUsuarios.repository.IUsuarioRepository;
import GamerHUB.MainApp;

import java.util.List;


/**
 *
 */
public class UsuarioRespositoryJDBC implements IUsuarioRepository {



    public UsuarioRespositoryJDBC(){

    }


    private MainApp mainApp = new MainApp();

    @Override
    public boolean add(UsuarioVO usuarioVO) {
        if(usuarioVO!=null){
            mainApp.getUsuarios_bd().add(usuarioVO);
            return true;
        } else return false;
    }

    @Override
    public boolean remove(int id) {

        for(UsuarioVO user: mainApp.getUsuarios_bd()){
            mainApp.getUsuarios().remove(id);
            return true;
        }
        return false;
    }

    @Override
    public boolean update(UsuarioVO usuarioDTO) {





        return false;
    }

    @Override
    public List<UsuarioVO> retrieveUsers() {



        return null;
    }
}
