package GamerHUB.GestionUsuarios.repository.impl;

import GamerHUB.GestionUsuarios.model.dto.UsuarioDTO;
import GamerHUB.GestionUsuarios.repository.IUsuarioRepository;

import java.util.List;

/**
 *
 */
public class UsuarioRespositoryJDBC implements IUsuarioRepository {

    @Override
    public boolean add(UsuarioDTO usuarioDTO) {
        return false;
    }

    @Override
    public boolean remove(int id) {
        return false;
    }

    @Override
    public boolean update(UsuarioDTO usuarioDTO) {
        return false;
    }

    @Override
    public List<UsuarioDTO> retrieveUsers() {
        return null;
    }
}
