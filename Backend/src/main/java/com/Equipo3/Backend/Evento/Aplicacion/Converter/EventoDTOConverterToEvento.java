package com.Equipo3.Backend.Evento.Aplicacion.Converter;

import com.Equipo3.Backend.Evento.Dominio.DTO.EventoDTO;
import com.Equipo3.Backend.Evento.Dominio.Evento;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class EventoDTOConverterToEvento implements Converter<EventoDTO, Evento > {

    @Override
    public Evento convert( EventoDTO eventoDTO ) {
        return Evento.builder()
                .code( eventoDTO.getCode() )
                .name( eventoDTO.getName() )
                .id( eventoDTO.getId() )
                .build();
    }
}
