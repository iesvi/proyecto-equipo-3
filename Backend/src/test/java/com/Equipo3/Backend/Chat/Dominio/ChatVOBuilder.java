package com.Equipo3.Backend.Chat.Dominio;

import com.Equipo3.Backend.Evento.Dominio.EventoVO;
import io.beanmother.core.ObjectMother;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.With;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@With
public class ChatVOBuilder {

    private String nombre;
    private Date fecha;
    private int idusuario;
    private String descripcion;


    public ChatVO build() {
        ObjectMother om = ObjectMother.getInstance();
        ChatVO nmother= om.bear("chat", ChatVO.class);

        return new ChatVO(
                nombre!=null ? nombre : nmother.getNombre()
        );
    }
}