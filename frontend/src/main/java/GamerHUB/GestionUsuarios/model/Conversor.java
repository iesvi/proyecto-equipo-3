package GamerHUB.GestionUsuarios.model;

import GamerHUB.GestionUsuarios.model.dto.UsuarioDTO;
import GamerHUB.GestionUsuarios.model.vo.UsuarioVO;

/**
 * Clase conversor de la entidad Usuario. Convierte tipos VO a DTO y viceversa
 * * según los datos que maneja la aplicación (DTO) y los que se persisten en la BBDD (VO).
 */
public class Conversor {

    public Conversor() {
    }


    /**
     * Convierte un objeto tipo UsuarioDTO a UsuarioVO
     *
     * @param usuarioVO
     * @return
     */
    public static UsuarioDTO voToDto(UsuarioVO usuarioVO) {

        UsuarioDTO usuarioDTO = new UsuarioDTO();

        usuarioDTO.setId(usuarioVO.getId());
        usuarioDTO.setNombre(usuarioVO.getNombre());
        usuarioDTO.setPassword(usuarioVO.getPassword());
        usuarioDTO.setEmail(usuarioVO.getEmail());
        usuarioDTO.setTelefono(usuarioVO.getTelefono());
        usuarioDTO.setFecha_nacimiento(usuarioVO.getFecha_nacimiento().toLocalDate());

//        for (int i = 0; i < usuarioVO.getAmigos().size(); i++) {
//            usuarioDTO.getAmigos().add(new SimpleIntegerProperty(usuarioVO.getAmigos().get(i)));
//        }

        return usuarioDTO;
    }

    /**
     *  Convierte un objeto tipo UsuarioVO a UsuarioDTO
     * @param usuarioDTO
     * @return
     */
    public static UsuarioVO dtoToVo(UsuarioDTO usuarioDTO) {

        UsuarioVO usuarioVO = new UsuarioVO();

        usuarioVO.setId(usuarioDTO.getId());
        usuarioDTO.setNombre(usuarioDTO.getNombre());
        usuarioDTO.setPassword(usuarioDTO.getPassword());
        usuarioDTO.setEmail(usuarioDTO.getEmail());
        usuarioDTO.setTelefono(usuarioDTO.getTelefono());
        usuarioDTO.setFecha_nacimiento(usuarioDTO.getFecha_nacimiento());

//        for (int i = 0; i < usuarioDTO.getAmigos().size(); i++) {
//            usuarioVO.getAmigos().add(usuarioDTO.getAmigos().get(i).getValue());
//        }


        return usuarioVO;
    }


}
