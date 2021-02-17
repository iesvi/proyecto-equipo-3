package GamerHUB.GestionUsuarios.repository;



import GamerHUB.GestionUsuarios.model.vo.UsuarioVO;

import java.util.List;

/**
 *
 */
public interface IUsuarioRepository  {

    /**
     *
     * @param usuarioVO
     * @return
     */
    boolean add(UsuarioVO usuarioVO);

    /**
     *
     * @param id
     * @return
     */
    boolean remove(int id);

    /**
     *
     * @param usuarioVO
     * @return
     */
    boolean update(UsuarioVO usuarioVO);

    /**
     *
     * @return
     */
    List<UsuarioVO> retrieveUsers();

}
