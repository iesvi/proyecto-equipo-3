package com.Equipo3.Backend.Evento.Aplicacion.Test;

import com.Equipo3.Backend.Evento.Dominio.EventoVO;
import com.Equipo3.Backend.Evento.Dominio.EventoVOBuilder;
import com.Equipo3.Backend.Evento.Infraestructura.JPA.EventoRepositoryJPA;
import org.junit.Assert;
import org.junit.Test;

import javax.transaction.Transactional;
import java.util.Date;

public class EventoVOTests  {

//
//    EventoRepositoryJPA repo;
//
//    @Override
//    public void setup() {
//        super.setup();
//        repo = new EventoRepositoryJPA();
//        //repo.setEntityManager(em);
//    }
//
//    @Test
//    public void inyectarEntityManager() {
//        Assert.assertNotNull(em);
//    }
//
//    @Test
//    public void ConsultarEvento() {
//        em.clear();
//        EventoVO eventoVO = repo.findOne(1);
//        Assert.assertEquals("Encuentra noticia id=1", eventoVO.getId(),1);
//    }
//
//    @Test
//    @Transactional
//    public void DardeAltaunEvento() {
//
//        EventoVO newevento = new EventoVOBuilder().build();
//
//        EventoVO eventoVO = repo.save(newevento);
//
//        Assert.assertEquals(newevento, eventoVO);
//    }
//
//    /*@Test
//    public void insertarNoticiaBuilder() {
//
//        //Arrange
//        em.getTransaction().begin();
//
//        //Noticia x defecto
//        Noticia newnotice = new NoticiaBuilder().build();
//
//        //Noticia cambiando algo
//        Noticia newnotice2 = new NoticiaBuilder()
//                .withAutor("Ramon ropero")
//                .withTitle("Java 11!")
//                .build();
//
//
//        repo.save(newnotice); //ACT
//        em.getTransaction().commit();
//
//        Noticia noticia = em.find(Noticia.class,newnotice.getId());
//
//        //Assert
//        Assert.assertEquals(newnotice.getId(),noticia.getId());
//    }*/
///*
//    @Test
//    public void insertarNoticiaMother() {
//
//        //Arrange
//        em.getTransaction().begin();
//
//        //Noticia x defecto
//        Noticia newnotice = NoticiaMother.general();
//
//        //Noticia x defecto
//        Noticia newnot_edge = NoticiaMother.edgeCase();
//
//        repo.save(newnotice); //ACT
//        repo.save(newnot_edge); //ACT
//        em.getTransaction().commit();
//
//        Noticia noticia1 = em.find(Noticia.class,newnotice.getId());
//        Noticia noticia2 = em.find(Noticia.class,newnot_edge.getId());
//
//        //Assert
//        Assert.assertEquals(newnotice.getId(),noticia1.getId());
//        Assert.assertEquals(newnot_edge.getId(),noticia2.getId());
//    }
//*/
//    @Test
//    @Transactional
//    public void ModificarEvento() {
//
//        EventoVO eventoVO =repo.findOne(1);
//        eventoVO.setNombre("Cumpleaños Julio");
//        eventoVO.setDescripcion("Cumpleaños Julio.");
//
//        repo.save(eventoVO);
//        em.clear();
//
//        EventoVO eventoVOBd = em.find(EventoVO.class,1);
//
//        Assert.assertNotEquals(eventoVO, eventoVOBd);
//    }
//
//    @Test
//    @Transactional
//    public void EliminarEvento() {
//        EventoVO eventoVODel = em.find(EventoVO.class,1);
//        repo.delete(eventoVODel); //ACT
//        EventoVO eventoVOBd = em.find(EventoVO.class,1);
//        Assert.assertNull(eventoVOBd);
//    }
}
