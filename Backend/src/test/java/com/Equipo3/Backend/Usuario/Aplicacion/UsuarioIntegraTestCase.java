package com.Equipo3.Backend.Usuario.Aplicacion;

import com.Equipo3.Backend.Shared.Config.ConfigurationSpring;
import com.Equipo3.Backend.Shared.Err.EntityExist;
import com.Equipo3.Backend.Shared.Err.EntityNotExist;
import com.Equipo3.Backend.Usuario.Aplicacion.Service.UsuarioService;
import com.Equipo3.Backend.Usuario.Dominio.Builder.UsuarioVOBuilder;
import com.Equipo3.Backend.Usuario.Dominio.DTO.UsuarioDTO;
import com.Equipo3.Backend.Usuario.Dominio.Mapper.UsuarioMapper;
import com.Equipo3.Backend.Usuario.Dominio.Repository.UsuarioRepository;
import com.Equipo3.Backend.Usuario.Dominio.UsuarioVO;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {ConfigurationSpring.class})
public class UsuarioIntegraTestCase {
    @Autowired
    UsuarioService userService;

    @Autowired
    UsuarioRepository userRepo;

    @Test
    public void ShouldRegisterUsuarioNotExistTest() {

        UsuarioVO newuser = userService.Registro_De_Usuario(buildUsuarioDto());


        Assert.assertNotNull("Devuelve nuevo Cliente", newuser);

    }

    @Test(expected = EntityExist.class)
    public void ShouldRegisterUsuarioExist_ThrowExceptionTest() {


        UsuarioVO usuarioYaExistente = userRepo.save(new UsuarioVOBuilder().build());

        UsuarioVO newuser = userService.Registro_De_Usuario(UsuarioMapper.toDTO(usuarioYaExistente));

    }

    @Test(expected = EntityNotExist.class)
    public void ShouldRemoveUsuarioNotExist_ThrowExceptionTest() {

        UsuarioVO usuarioYaExistente = new UsuarioVOBuilder().build();

        userService.Eliminar_Usuario(usuarioYaExistente.getId());
    }

    @Test
    public void ShouldRemoveUsuarioExistTest() {


        UsuarioVO usuarioYaExistente = userService.Registro_De_Usuario(UsuarioMapper.toDTO(new UsuarioVOBuilder().build()));


        Assert.assertEquals(true, userService.Eliminar_Usuario(usuarioYaExistente.getId()));

    }

    @Test
    public void ShouldReturnUsuarioExistTest() {

        UsuarioVO Usuarioyaexistente = userService.Registro_De_Usuario(UsuarioMapper.toDTO(new UsuarioVOBuilder().build()));

        UsuarioVO Usuariodevuelto = userService.ConsultarPerfilUsuario(Usuarioyaexistente.getId());

        Assert.assertNotNull(Usuariodevuelto);

    }
    @Test(expected = EntityNotExist.class)
    public void ShouldReturnUsuarioNotExist_ThrowExceptionTest() {


        UsuarioVO Usuarioyaexistente = new UsuarioVOBuilder().build();

        UsuarioVO Usuariodevuelto = userService.ConsultarPerfilUsuario(Usuarioyaexistente.getId());

    }
    @Test
    public void ShouldEditUsuarioExistTest() {

        UsuarioVO Usuariosineditar = userService.Registro_De_Usuario(UsuarioMapper.toDTO(new UsuarioVOBuilder().build()));

        UsuarioVO Usuarioaeditar = userService.ConsultarPerfilUsuario(Usuariosineditar.getId());

        Usuarioaeditar.setNombre("Miguel");

        UsuarioVO usuariodb = userService.Modificar_Usuario(UsuarioMapper.toDTO(Usuarioaeditar));

        Assert.assertEquals(Usuarioaeditar, usuariodb);

    }
    @Test(expected = EntityNotExist.class)
    public void ShouldEditUsuarioNotExist_ThrowExceptionTest() {


        UsuarioVO Usuariosineditar = new UsuarioVOBuilder().build();

        UsuarioVO Usuarioaeditar = Usuariosineditar;

        Usuarioaeditar.setNombre("Miguel");

        UsuarioVO usuariodb = userService.Modificar_Usuario(UsuarioMapper.toDTO(Usuarioaeditar));


    }


    private UsuarioDTO buildUsuarioDto() {
        return UsuarioMapper.toDTO(new UsuarioVOBuilder().build());
    }
}
