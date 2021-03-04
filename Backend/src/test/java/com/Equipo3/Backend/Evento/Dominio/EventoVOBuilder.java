package com.Equipo3.Backend.Evento.Dominio;

import io.beanmother.core.ObjectMother;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.With;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@With
public class EventoVOBuilder {

    private String nombre;
    private Date fecha;
    private int idusuario;
    private String descripcion;


    public EventoVO build() {
        ObjectMother om = ObjectMother.getInstance();
        EventoVO nmother= om.bear("evento", EventoVO.class);

        return new EventoVO(
                nombre!=null ? nombre : nmother.getNombre(),
                fecha!=null ? fecha : nmother.getFecha(),
                descripcion!=null ? descripcion : nmother.getDescripcion()
        );
    }
}
