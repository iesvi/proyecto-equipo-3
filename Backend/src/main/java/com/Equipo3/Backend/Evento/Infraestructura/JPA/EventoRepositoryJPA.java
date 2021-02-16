package com.Equipo3.Backend.Evento.Infraestructura.JPA;

import com.Equipo3.Backend.Evento.Dominio.EventoVO;
import com.Equipo3.Backend.Evento.Dominio.Repository.EventoRepository;
import com.Equipo3.Backend.Shared.Infraestructura.JPA.GenericRepositoryJPA;

/**
 * Implementación del repositorio de eventos parra Java Peristence Api
 */
public class EventoRepositoryJPA extends GenericRepositoryJPA<EventoVO,Integer> implements EventoRepository {
    public EventoRepositoryJPA() {
        super(EventoVO.class);
    }
}
