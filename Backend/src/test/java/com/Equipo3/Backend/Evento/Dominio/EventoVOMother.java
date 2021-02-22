package com.Equipo3.Backend.Evento.Dominio;


public class EventoVOMother {
    public static EventoVO general() {
        return new EventoVOBuilder().build();
    }


}