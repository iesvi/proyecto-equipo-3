package com.Equipo3.Backend.Evento.Dominio;

import io.beanmother.core.ObjectMother;

import java.util.Date;

public class EventoVOBuilder {

    private int id;
    private String nombre;
    private Date fecha;
    private int idusuario;
    private String descripcion;

    public EventoVOBuilder withnombre(String nombre) {
        this.nombre = nombre;
        return this;
    }
    public EventoVOBuilder withfecha(Date fecha) {
        this.fecha = fecha;
        return this;
    }
    public EventoVOBuilder withidusuario(int idusuario) {
        this.idusuario = idusuario;
        return this;
    }
    public EventoVOBuilder withdescripcion(String descripcion) {
        this.descripcion = descripcion;
        return this;
    }

    public EventoVO build() {
        ObjectMother om = ObjectMother.getInstance();
        EventoVO nmother= om.bear("evento", EventoVO.class);

        return new EventoVO(
                id!=0 ? id : nmother.getId(),
                nombre!=null ? nombre : nmother.getNombre(),
                fecha!=null ? fecha : nmother.getFecha(),
                idusuario!=0 ? idusuario : nmother.getIdusuario(),
                descripcion!=null ? descripcion : nmother.getDescripcion()
        );
    }




}
