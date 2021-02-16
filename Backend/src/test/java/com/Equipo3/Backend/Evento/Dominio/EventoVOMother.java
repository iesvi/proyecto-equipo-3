package com.Equipo3.Backend.Evento.Dominio;


public class EventoVOMother {
    public static EventoVO general() {
        return new EventoVOBuilder().build();
    }

    //Noticia que sea un caso extremo para los test, con datos complejos o que den problemas
    public static EventoVO edgeCase() {
        return new EventoVOBuilder()
                .withnombre("PruebaEvento")
                .build();
    }
}