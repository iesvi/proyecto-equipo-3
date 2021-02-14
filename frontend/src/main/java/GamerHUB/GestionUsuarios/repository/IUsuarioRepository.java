package GamerHUB.GestionUsuarios.repository;


import GamerHUB.GestionUsuarios.model.dto.UsuarioDTO;

import java.util.List;

public interface IUsuarioRepository  {

    public boolean add(UsuarioDTO usuarioDTO);
    public boolean remove(int id);
    public boolean update(UsuarioDTO usuarioDTO);
    public List<UsuarioDTO> retrieveUsers();

}
