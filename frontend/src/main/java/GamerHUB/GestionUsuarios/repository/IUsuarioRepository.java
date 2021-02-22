package GamerHUB.GestionUsuarios.repository;



import GamerHUB.GestionUsuarios.model.vo.UsuarioVO;

import java.util.List;

/**
 * Interfaz en la que se definen los métodos para las operaciones CRUD con ç
 *los usuarios.
 */
public interface IUsuarioRepository  {

    /**
     *Método que se llama al registrar un nuevo usuario.
     * @param usuarioVO
     * @return
     */
    boolean add(UsuarioVO usuarioVO);

    /**
     *Método para eliminar usuario.
     * @param id
     * @return
     */
    boolean remove(int id);

    /**
     *Método para actualizar los datos del usuario. El propio usuario lo llama
     * al modificar su perfil.
     * @param usuarioVO
     * @return
     */
    boolean update(UsuarioVO usuarioVO);

    /**
     *Método para listar todos los usuarios registrados en la plataforma.
     * @return
     */
    List<UsuarioVO> retrieveUsers();

}
