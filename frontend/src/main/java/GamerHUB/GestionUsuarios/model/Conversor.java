package GamerHUB.GestionUsuarios.model;

import GamerHUB.GestionUsuarios.model.dto.UsuarioDTO;
import GamerHUB.GestionUsuarios.model.vo.UsuarioVO;

import java.sql.Date;

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

        UsuarioDTO usuarioDTO = new UsuarioDTO(usuarioVO.getId(), usuarioVO.getNombre(), usuarioVO.getPassword(), usuarioVO.getEmail(), usuarioVO.getFecha_nacimiento().toLocalDate(), usuarioVO.getTelefono(), usuarioVO.getRol());


//        for (int i = 0; i < usuarioVO.getAmigos().size(); i++) {
//            usuarioDTO.getAmigos().add(new SimpleIntegerProperty(usuarioVO.getAmigos().get(i)));
//        }

        return usuarioDTO;
    }

    /**
     * Convierte un objeto tipo UsuarioVO a UsuarioDTO
     *
     * @param usuarioDTO
     * @return
     */
    public static UsuarioVO dtoToVo(UsuarioDTO usuarioDTO) {

        UsuarioVO usuarioVO = new UsuarioVO();

        usuarioVO.setId(usuarioDTO.getId());
        usuarioVO.setNombre(usuarioDTO.getNombre());
        usuarioVO.setPassword(usuarioDTO.getPassword());
        usuarioVO.setEmail(usuarioDTO.getEmail());
        usuarioVO.setTelefono(usuarioDTO.getTelefono());
        usuarioVO.setFecha_nacimiento(Date.valueOf(usuarioDTO.getFecha_nacimiento()));
        usuarioVO.setRol(usuarioDTO.getRol());

//        for (int i = 0; i < usuarioDTO.getAmigos().size(); i++) {
//            usuarioVO.getAmigos().add(usuarioDTO.getAmigos().get(i).getValue());
//        }


        return usuarioVO;
    }


}
