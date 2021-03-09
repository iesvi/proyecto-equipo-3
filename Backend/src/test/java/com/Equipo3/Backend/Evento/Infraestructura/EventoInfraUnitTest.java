package com.Equipo3.Backend.Evento.Infraestructura;


import com.Equipo3.Backend.Evento.Dominio.EventoVO;
import com.Equipo3.Backend.Evento.Dominio.EventoVOBuilder;
import com.Equipo3.Backend.Shared.Config.ConfigurationMongoTest;
import com.Equipo3.Backend.Shared.Config.ConfigurationPersistenceTest;
import com.Equipo3.Backend.Shared.UnitTestCase;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {ConfigurationPersistenceTest.class, ConfigurationMongoTest.class})
public class EventoInfraUnitTest extends UnitTestCase {

    @PersistenceContext
    EntityManager em;

    @Override
    public void setup() {
        super.setup();
    }

    @Test
    @Transactional
    public void ShouldNewEventoTest() {
        //Arrange
        EventoVO evento = createAndSaveNewEvento();

        //Assert
        EventoVO eventoBd = em.find(EventoVO.class, evento.getId());

        Assert.assertEquals(evento, eventoBd);
    }

    @Test
    @Transactional
    public void ShouldEditEventoTest() {
        //Arrange
        EventoVO evento = createAndSaveNewEvento();

        EventoVO eventoEdit = em.find(EventoVO.class, evento.getId());
        eventoEdit.setNombre("Cumpleaños Pepe");

        //Act
        em.persist(eventoEdit);

        em.flush();
        em.clear();

        //Assert
        EventoVO eventoBd = em.find(EventoVO.class, evento.getId());

        Assert.assertEquals(eventoEdit, eventoBd);
    }

    @Test
    @Transactional
    public void ShouldRemoveEvento() {
        //Arrange
        EventoVO eventoDelete = em.find(EventoVO.class, createAndSaveNewEvento().getId());

        //Act
        em.remove(eventoDelete);
        em.flush();
        em.clear();

        EventoVO eventoBd = em.find(EventoVO.class, eventoDelete.getId());

        //Assert
        Assert.assertNull(eventoBd);

    }


    private EventoVO createAndSaveNewEvento() {
        EventoVO evento = new EventoVOBuilder().build();
        em.persist(evento);

        return evento;
    }
}
