package com.Equipo3.Backend.Usuario.Aplicacion;

import com.Equipo3.Backend.Shared.Config.ConfigurationSpringTest;
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
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {ConfigurationSpringTest.class})
public class UsuarioIntegraTestCase {
    @Autowired
    UsuarioService userService;

    @Autowired
    UsuarioRepository userRepo;

    @Test
    @Transactional
    @Commit
    public void ShouldRegisterUsuarioNotExistTest() {

        UsuarioVO newuser = userService.Registro_De_Usuario(buildUsuarioDto());


        Assert.assertNotNull("Devuelve nuevo Cliente", newuser);

    }

    @Test(expected = EntityExist.class)
    @Transactional
    public void ShouldRegisterUsuarioExist_ThrowExceptionTest() {


        UsuarioVO usuarioYaExistente = userRepo.save(new UsuarioVOBuilder().build());

        UsuarioVO newuser = userService.Registro_De_Usuario(UsuarioMapper.toDTO(usuarioYaExistente));

    }

    @Test(expected = EntityNotExist.class)
    @Transactional
    public void ShouldRemoveUsuarioNotExist_ThrowExceptionTest() {

        userService.Eliminar_Usuario(25);
    }

    @Test
    @Transactional
    public void ShouldRemoveUsuarioExistTest() {


        UsuarioVO usuarioYaExistente = userService.Registro_De_Usuario(UsuarioMapper.toDTO(new UsuarioVOBuilder().build()));


        Assert.assertEquals(true, userService.Eliminar_Usuario(usuarioYaExistente.getId()));

    }

    @Test
    public void ShouldReturnUsuarioExistTest() {

        UsuarioVO Usuarioyaexistente = userService.Registro_De_Usuario(UsuarioMapper.toDTO(new UsuarioVOBuilder().build()));

        Optional<UsuarioVO> Usuariodevuelto = userService.ConsultarPerfilUsuario(Usuarioyaexistente.getId());

        Assert.assertNotNull(Usuariodevuelto);

    }
    @Test(expected = EntityNotExist.class)
    public void ShouldReturnUsuarioNotExist_ThrowExceptionTest() {


        UsuarioVO Usuarioyaexistente = new UsuarioVOBuilder().build();

        Optional<UsuarioVO> Usuariodevuelto = userService.ConsultarPerfilUsuario(Usuarioyaexistente.getId());

    }
    @Test
    public void ShouldEditUsuarioExistTest() {

        UsuarioVO Usuariosineditar = userService.Registro_De_Usuario(UsuarioMapper.toDTO(new UsuarioVOBuilder().build()));

        Optional<UsuarioVO> Usuarioaeditar = userService.ConsultarPerfilUsuario(Usuariosineditar.getId());

        Usuarioaeditar.get().setNombre("Miguel");

        UsuarioVO usuariodb = userService.Modificar_Usuario(UsuarioMapper.toDTO(Usuarioaeditar.get()));

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
