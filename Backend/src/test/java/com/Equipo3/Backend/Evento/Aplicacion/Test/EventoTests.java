package com.Equipo3.Backend.Evento.Aplicacion.Test;

import com.Equipo3.Backend.Evento.Dominio.Evento;
import com.Equipo3.Backend.Evento.Infraestructura.JPA.EventoRepositoryJPA;
import org.junit.Assert;
import org.junit.Test;

import javax.transaction.Transactional;
import java.util.Date;

public class EventoTests extends JPAUnitTest {

    EventoRepositoryJPA repo;

    @Override
    public void setup() {
        super.setup();
        repo = new EventoRepositoryJPA();
        repo.setEntityManager(em);
    }

    @Test
    public void inyectarEntityManager() {
        Assert.assertNotNull(em);
    }

    @Test
    public void ConsultarEvento() {
        em.clear();
        Evento evento = repo.findOne(1);
        Assert.assertEquals("Encuentra noticia id=1",evento.getId(),1);
    }

    @Test
    @Transactional
    public void DardeAltaunEvento() {

        Evento newevento = new Evento("Cumpleaños Melania",new Date(),1,"Es el cumpleaños de Melania");

        Evento evento = repo.save(newevento);

        Assert.assertEquals(newevento,evento);
    }

    /*@Test
    public void insertarNoticiaBuilder() {

        //Arrange
        em.getTransaction().begin();

        //Noticia x defecto
        Noticia newnotice = new NoticiaBuilder().build();

        //Noticia cambiando algo
        Noticia newnotice2 = new NoticiaBuilder()
                .withAutor("Ramon ropero")
                .withTitle("Java 11!")
                .build();


        repo.save(newnotice); //ACT
        em.getTransaction().commit();

        Noticia noticia = em.find(Noticia.class,newnotice.getId());

        //Assert
        Assert.assertEquals(newnotice.getId(),noticia.getId());
    }*/
/*
    @Test
    public void insertarNoticiaMother() {

        //Arrange
        em.getTransaction().begin();

        //Noticia x defecto
        Noticia newnotice = NoticiaMother.general();

        //Noticia x defecto
        Noticia newnot_edge = NoticiaMother.edgeCase();

        repo.save(newnotice); //ACT
        repo.save(newnot_edge); //ACT
        em.getTransaction().commit();

        Noticia noticia1 = em.find(Noticia.class,newnotice.getId());
        Noticia noticia2 = em.find(Noticia.class,newnot_edge.getId());

        //Assert
        Assert.assertEquals(newnotice.getId(),noticia1.getId());
        Assert.assertEquals(newnot_edge.getId(),noticia2.getId());
    }
*/
    @Test
    @Transactional
    public void ModificarEvento() {

        Evento evento =repo.findOne(1);
        evento.setNombre("Cumpleaños Julio");
        evento.setDescripcion("Cumpleaños Julio.");

        repo.save(evento);
        em.clear();

        Evento eventoBd = em.find(Evento.class,1);

        Assert.assertNotEquals(evento,eventoBd);
    }

    @Test
    @Transactional
    public void EliminarEvento() {
        Evento eventoDel = em.find(Evento.class,1);
        repo.delete(eventoDel); //ACT
        Evento eventoBd = em.find(Evento.class,1);
        Assert.assertNull(eventoBd);
    }
}
