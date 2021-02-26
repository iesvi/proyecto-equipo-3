package GamerHUB.GestionUsuarios.repository.impl;

import GamerHUB.GestionUsuarios.model.dto.UsuarioDTO;
import GamerHUB.GestionUsuarios.model.vo.UsuarioVO;
import GamerHUB.GestionUsuarios.repository.IUsuarioRepository;
import GamerHUB.GestionUsuarios.repository.ListaUsuario;
import GamerHUB.MainApp;

import java.util.List;


/**
 *
 */
public class UsuarioRespositoryJDBC implements IUsuarioRepository {


    private ListaUsuario listaUsuario;

    public UsuarioRespositoryJDBC(ListaUsuario listaUsuario) {
        this.listaUsuario = listaUsuario;

    }


    private MainApp mainApp = new MainApp();

    @Override
    public boolean add(UsuarioDTO usuarioDTO) {
        if (usuarioDTO != null) {
            listaUsuario.getUsers().add(usuarioDTO);
            return true;
        } else return false;
    }

    @Override
    public boolean remove(int id) {

        for (UsuarioDTO user : listaUsuario.getUsers()) {
            if (user.getId() == id) {
                listaUsuario.getUsers().remove(user);
                return true;
            }

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
