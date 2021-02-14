package GamerHUB.GestionUsuarios.repository;


import GamerHUB.GestionUsuarios.model.dto.UsuarioDTO;

import java.util.List;

public interface IUsuarioRepository  {

    boolean add(UsuarioDTO usuarioDTO);
    boolean remove(int id);
    boolean update(UsuarioDTO usuarioDTO);
    List<UsuarioDTO> retrieveUsers();

}
