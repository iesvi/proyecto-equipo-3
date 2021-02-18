package com.Equipo3.Backend.Usuario.Aplicacion.Service;

import com.Equipo3.Backend.Shared.Err.EntityExist;
import com.Equipo3.Backend.Shared.Err.EntityNotExist;
import com.Equipo3.Backend.Usuario.Dominio.DTO.UsuarioDTO;
import com.Equipo3.Backend.Usuario.Dominio.Repository.UsuarioRepository;
import com.Equipo3.Backend.Usuario.Dominio.UsuarioVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;
import org.springframework.transaction.annotation.Transactional;

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
     * @param usuariodto
     * @return usuarioRepo.save(user)
     */
    @Transactional
    public UsuarioVO Registro_De_Usuario(UsuarioDTO usuariodto) {
        UsuarioVO nbd = usuarioRepo.findOne(usuariodto.getId());
        if (nbd!=null)
            throw new EntityExist(UsuarioVO.class.toString(),usuariodto.getId());

        UsuarioVO user = new UsuarioVO(usuariodto.getId(), usuariodto.getNombre(), usuariodto.getPassword(), usuariodto.getEmail(), usuariodto.getFecha_nacimiento(), usuariodto.getTelefono(), usuariodto.getRol(), null, null);
        return usuarioRepo.save(user);
    }

    /**
     * Método para consultar un usuario en función a la id que se le pase
     * @param id
     * @return usuarioRepo.findOne(id)
     */
    public UsuarioVO ConsultarPerfilUsuario(int id) {
        UsuarioVO nbd = usuarioRepo.findOne(id);
        if (nbd == null)
            throw new EntityNotExist(UsuarioVO.class.toString(),id);

        return usuarioRepo.findOne(id);
    }

    /**
     * Método para modificar un usuario en función a la id que se le pase. Si no existe se genera una excepción. Tambien se convierte un UsuarioDTO a UsuarioVO
     * @param usuariodto
     */
    @Transactional
    public UsuarioVO Modificar_Usuario(UsuarioDTO usuariodto) {
        UsuarioVO nbd = usuarioRepo.findOne(usuariodto.getId());
        if (nbd==null)
            throw new EntityNotExist(UsuarioVO.class.toString(),usuariodto.getId());
        UsuarioVO user = new UsuarioVO(nbd.getId(), nbd.getNombre(), nbd.getPassword(), nbd.getEmail(), nbd.getFecha_nacimiento(), nbd.getTelefono(), nbd.getRol(), null, null);
       return usuarioRepo.save(user);
    }

    /**
     * Método para eliminar un usuario
     * @param id
     */
    @Transactional
    public boolean Eliminar_Usuario(int id)  {
        UsuarioVO nbd = usuarioRepo.findOne(id);
        if (nbd == null)
            throw new EntityNotExist(UsuarioVO.class.toString(),id);

        return usuarioRepo.delete(nbd);
    }
}
