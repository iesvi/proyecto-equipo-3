package GamerHUB.GestionUsuarios.repository;



import GamerHUB.GestionUsuarios.model.vo.UsuarioVO;

import java.util.List;

public interface IUsuarioRepository  {

    boolean add(UsuarioVO usuarioVO);
    boolean remove(int id);
    boolean update(UsuarioVO usuarioVO);
    List<UsuarioVO> retrieveUsers();

}
