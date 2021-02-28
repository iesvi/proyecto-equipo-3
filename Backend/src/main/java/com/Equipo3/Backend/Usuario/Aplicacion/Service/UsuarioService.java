package com.Equipo3.Backend.Usuario.Aplicacion.Service;

import com.Equipo3.Backend.Shared.Err.EntityExist;
import com.Equipo3.Backend.Shared.Err.EntityNotExist;
import com.Equipo3.Backend.Usuario.Dominio.DTO.UsuarioDTO;
import com.Equipo3.Backend.Usuario.Dominio.Repository.UsuarioRepository;
import com.Equipo3.Backend.Usuario.Dominio.UsuarioVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.Optional;

/**
 * Casos de uso de la entidad usuario
 */
@Service
public class UsuarioService {

    /**
     * usuarioRepo tipo UsuarioRepository
     */
    @Autowired
    UsuarioRepository usuarioRepo;


    /**
     * Método para dar de alta un nuevo usuario. Tambien se convierte un UsuarioDTO a UsuarioVO
     *
     * @param usuariodto
     * @return usuarioRepo.save(user)
     */
    @Transactional
    public UsuarioVO Registro_De_Usuario(UsuarioDTO usuariodto) {

        Optional<UsuarioVO> nbd = usuarioRepo.findById(usuariodto.getId());
        if (nbd.isPresent())
            throw new EntityExist(UsuarioVO.class.toString(), usuariodto.getId());

        UsuarioVO user = new UsuarioVO(usuariodto.getNombre(), usuariodto.getPassword(), usuariodto.getEmail(), usuariodto.getFecha_nacimiento(), usuariodto.getTelefono(), usuariodto.getRol(), null, null, null);
        return usuarioRepo.save(user);
    }

    /**
     * Método para consultar un usuario en función a la id que se le pase
     *
     * @param id
     * @return usuarioRepo.findOne(id)
     */
    public UsuarioVO ConsultarPerfilUsuario(int id) {
        return usuarioRepo.findById(id).get();
    }

    /**
     * Método para modificar un usuario en función a la id que se le pase. Si no existe se genera una excepción. Tambien se convierte un UsuarioDTO a UsuarioVO
     *
     * @param usuariodto
     */
    @Transactional
    public UsuarioVO Modificar_Usuario(UsuarioDTO usuariodto) {
        Optional<UsuarioVO> nbd = usuarioRepo.findById(usuariodto.getId());
        if (nbd.isPresent()) {
            throw new EntityNotExist(UsuarioVO.class.toString(), usuariodto.getId());
        }
        UsuarioVO udpusuario = new UsuarioVO(usuariodto.getNombre(), usuariodto.getPassword(), usuariodto.getEmail(), usuariodto.getFecha_nacimiento(), usuariodto.getTelefono(), usuariodto.getRol());
        return usuarioRepo.save(udpusuario);
    }

    /**
     * Método para eliminar un usuario
     *
     * @param id
     */
    @Transactional
    public boolean Eliminar_Usuario(int id) {
        Optional<UsuarioVO> nbd = usuarioRepo.findById(id);
        if (nbd.isPresent()) {
            throw new EntityNotExist(UsuarioVO.class.toString(), id);
        }
        usuarioRepo.deleteById(id);
        return true;
    }
}
