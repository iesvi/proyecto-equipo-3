package com.Equipo3.Backend.Evento.Aplicacion;

import com.Equipo3.Backend.Evento.Aplicacion.Service.EventoService;
import com.Equipo3.Backend.Evento.Dominio.Repository.EventoRepository;
import com.Equipo3.Backend.Shared.Config.ConfigurationSpring;
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
    EventoRepository eventoRepository;



}
