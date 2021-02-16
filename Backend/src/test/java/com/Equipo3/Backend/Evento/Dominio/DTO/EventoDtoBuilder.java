package com.Equipo3.Backend.Evento.Dominio.DTO;

import io.beanmother.core.ObjectMother;

import java.util.Date;

public class EventoDtoBuilder {
    private int id;
    private String nombre;
    private Date fecha;
    private int idusuario;
    private String descripcion;

    public EventoDtoBuilder withnombre(String nombre) {
        this.nombre = nombre;
        return this;
    }
    public EventoDtoBuilder withfecha(Date fecha) {
        this.fecha = fecha;
        return this;
    }
    public EventoDtoBuilder withidusuario(int idusuario) {
        this.idusuario = idusuario;
        return this;
    }
    public EventoDtoBuilder withdescripcion(String descripcion) {
        this.descripcion = descripcion;
        return this;
    }

    public EventoDTO build() {
        ObjectMother om = ObjectMother.getInstance();
        EventoDTO nmother= om.bear("evento", EventoDTO.class);

        return new EventoDTO(
                id!=0 ? id : nmother.getId(),
                nombre!=null ? nombre : nmother.getNombre(),
                fecha!=null ? fecha : nmother.getFecha(),
                idusuario!=0 ? idusuario : nmother.getIdusuario(),
                descripcion!=null ? descripcion : nmother.getDescripcion()
        );
    }
}
