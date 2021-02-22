package com.Equipo3.Backend.Evento.Aplicacion;

import com.Equipo3.Backend.Evento.Aplicacion.Service.EventoService;
import com.Equipo3.Backend.Evento.Dominio.DTO.EventoDTO;
import com.Equipo3.Backend.Evento.Dominio.EventoVO;
import com.Equipo3.Backend.Evento.Dominio.EventoVOBuilder;
import com.Equipo3.Backend.Evento.Dominio.Mapper.EventoMapper;
import com.Equipo3.Backend.Evento.Dominio.Repository.EventoRepository;
import com.Equipo3.Backend.Shared.Config.ConfigurationSpring;
import com.Equipo3.Backend.Shared.Err.EntityExist;
import com.Equipo3.Backend.Shared.Err.EntityNotExist;
import com.Equipo3.Backend.Usuario.Dominio.Builder.UsuarioVOBuilder;
import com.Equipo3.Backend.Usuario.Dominio.Mapper.UsuarioMapper;
import com.Equipo3.Backend.Usuario.Dominio.UsuarioVO;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {ConfigurationSpring.class})
public class EventoIntegraTest {

    @Autowired
    EventoService eventoService;

    @Autowired
    EventoRepository eventoRepo;

    @Test
    public void ShouldAddEventoNotExistTest() {

        EventoVO newevent = eventoService.darDeAltaUnEvento(buildEventoDto());


        Assert.assertNotNull("Devuelve nuevo Evento", newevent);

    }

    @Test(expected = EntityExist.class)
    public void ShouldAddEventoExist_ThrowExceptionTest() {


        EventoVO Eventoyaexistente = eventoRepo.save(new EventoVOBuilder().build());

        EventoVO newevent = eventoService.darDeAltaUnEvento(EventoMapper.toDTO(Eventoyaexistente));

    }

    @Test(expected = EntityNotExist.class)
    public void ShouldRemoveEventoNotExist_ThrowExceptionTest() {

        EventoVO Eventoyaexistente = new EventoVOBuilder().build();

        eventoService.eliminarUnEvento(Eventoyaexistente.getId());
    }

    @Test
    public void ShouldRemoveEventoExistTest() {


        EventoVO Eventoyaexistente = eventoService.darDeAltaUnEvento(EventoMapper.toDTO(new EventoVOBuilder().build()));


        Assert.assertEquals(true, eventoService.eliminarUnEvento(Eventoyaexistente.getId()));

    }
    @Test
    public void ShouldReturnEventoExistTest() {

        EventoVO Eventoyaexistente = eventoService.darDeAltaUnEvento(EventoMapper.toDTO(new EventoVOBuilder().build()));

        EventoVO Eventodevuelto = eventoService.consultarEventos(Eventoyaexistente.getId());

        Assert.assertNotNull(Eventodevuelto);

    }
    @Test(expected = EntityNotExist.class)
    public void ShouldReturnEventoNotExist_ThrowExceptionTest() {


        EventoVO Eventoyaexistente = new EventoVOBuilder().build();

        EventoVO Eventodevuelto = eventoService.consultarEventos(Eventoyaexistente.getId());

    }
    @Test
    public void ShouldEditEventoExistTest() {

        EventoVO Eventosineditar = eventoService.darDeAltaUnEvento(EventoMapper.toDTO(new EventoVOBuilder().build()));

        EventoVO Eventoaeditar = eventoService.consultarEventos(Eventosineditar.getId());

        Eventoaeditar.setNombre("Cumpleaños de Pepe");

        EventoVO eventodb = eventoService.modificarEvento(EventoMapper.toDTO(Eventoaeditar));

        Assert.assertEquals(Eventoaeditar, eventodb);

    }
    @Test(expected = EntityNotExist.class)
    public void ShouldEditEventoNotExist_ThrowExceptionTest() {


        EventoVO Eventosineditar = new EventoVOBuilder().build();

        EventoVO Eventoaeditar = Eventosineditar;

        Eventoaeditar.setNombre("Cumpleaños de Pepe");

        EventoVO eventodb = eventoService.modificarEvento(EventoMapper.toDTO(Eventoaeditar));


    }




    private EventoDTO buildEventoDto() {
        return EventoMapper.toDTO(new EventoVOBuilder().build());
    }

}
