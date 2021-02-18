package com.Equipo3.Backend.Usuario.Aplicacion;

import com.Equipo3.Backend.Shared.Config.ConfigurationSpring;
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

        //Arrange
        UsuarioVO newuser = userService.Registro_De_Usuario(buildUsuarioDto());


        Assert.assertNotNull("Devuelve nuevo Cliente", newuser);

    }

    @Test
    public void ShouldRegisterUsuarioExist_ThrowExceptionTest() {

        // **** Arrange
        // Se crea un cliente que existe ya
        UsuarioVO usuarioYaExistente = userRepo.save(new UsuarioVOBuilder().build());

        //Act
        UsuarioVO newuser = userService.Registro_De_Usuario(UsuarioMapper.toDTO(new UsuarioVOBuilder().build()));

    }

    @Test
    public void ShouldRemoveClienteNotExist_ThrowExceptionTest() {

        // **** Arrange
        UsuarioVO usuarioYaExistente = userService.Registro_De_Usuario(UsuarioMapper.toDTO(new UsuarioVOBuilder().build()));

        //Act


        //assert
        Assert.assertEquals(true, userService.Eliminar_Usuario(usuarioYaExistente.getId()));
    }

    @Test
    public void ShouldRemoveClienteExistTest() {

        // **** Arrange
        UsuarioVO usuarioYaExistente = userService.Registro_De_Usuario(UsuarioMapper.toDTO(new UsuarioVOBuilder().build()));

     //Assert
        Assert.assertEquals(true, userService.Eliminar_Usuario(usuarioYaExistente.getId()));

    }


    private UsuarioDTO buildUsuarioDto() {
        return UsuarioMapper.toDTO(new UsuarioVOBuilder().build());
    }
}
