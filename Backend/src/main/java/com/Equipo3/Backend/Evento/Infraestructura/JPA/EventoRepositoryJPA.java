package com.Equipo3.Backend.Evento.Infraestructura.JPA;

import com.Equipo3.Backend.Evento.Dominio.Evento;
import com.Equipo3.Backend.Evento.Dominio.Repository.EventoRepository;
import com.Equipo3.Backend.Shared.Infraestructura.JPA.GenericRepositoryJPA;

public class EventoRepositoryJPA extends GenericRepositoryJPA<Evento,Integer> implements EventoRepository {

    public EventoRepositoryJPA() {
        super(Evento.class);
    }
}
