package com.Equipo3.Backend.Evento.Dominio.DTO;

public class EventoDtoMother {
    public static EventoDTO general() {
        return new EventoDtoBuilder().build();
    }
}
