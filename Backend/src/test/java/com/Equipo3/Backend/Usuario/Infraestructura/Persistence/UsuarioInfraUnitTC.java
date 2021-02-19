package com.Equipo3.Backend.Usuario.Infraestructura.Persistence;

import com.Equipo3.Backend.Shared.Config.ConfigurationSpring;
import com.Equipo3.Backend.Shared.UnitTestCase;
import com.Equipo3.Backend.Usuario.Dominio.Builder.UsuarioVOBuilder;
import com.Equipo3.Backend.Usuario.Dominio.UsuarioVO;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {ConfigurationSpring.class})
public class UsuarioInfraUnitTC extends UnitTestCase {

    @PersistenceContext
    EntityManager em;

    @Override
    public void setup() {
        super.setup();
    }

    @Test
    @Transactional
    public void ShouldNewUserTest() {
        //Arrange
        UsuarioVO user = createAndSaveNewUser();

        //Assert
        UsuarioVO userBd = em.find(UsuarioVO.class, user.getId());
        Assert.assertEquals(user, userBd);
    }

    @Test
    @Transactional
    public void ShouldEditUserTest() {
        //Arrange
        UsuarioVO user = createAndSaveNewUser();
        UsuarioVO userEdit = em.find(UsuarioVO.class, user.getId());
        userEdit.setNombre("Miguel");

        //Act
        em.persist(userEdit);
        em.flush();
        em.clear();

        //Assert
         userEdit = em.find(UsuarioVO.class, user.getId());
        Assert.assertEquals(userEdit, user);
    }

    @Test
    @Transactional
    public void ShouldRemoveUser() {
        //Arrange
        UsuarioVO userDelete = em.find(UsuarioVO.class, createAndSaveNewUser().getId());

        //Act
        em.remove(userDelete);
        em.flush();
        em.clear();
        UsuarioVO userBd = em.find(UsuarioVO.class, userDelete.getId());

        //Assert
        Assert.assertNull(userBd);
    }

    private UsuarioVO createAndSaveNewUser() {
        UsuarioVO user = new UsuarioVOBuilder()
                .withFecha_nacimiento(null)
                .build();
        em.persist(user);
        return user;
    }
}
