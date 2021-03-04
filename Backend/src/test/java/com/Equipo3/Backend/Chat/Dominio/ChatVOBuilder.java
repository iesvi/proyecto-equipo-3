package com.Equipo3.Backend.Chat.Dominio;

import io.beanmother.core.ObjectMother;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.With;

@AllArgsConstructor
@NoArgsConstructor
@With
public class ChatVOBuilder {

    private String nombre;
    private int puerto;


    public ChatVO build() {
        ObjectMother om = ObjectMother.getInstance();
        ChatVO nmother= om.bear("chat", ChatVO.class);
        return new ChatVO(
                nombre!=null ? nombre : nmother.getNombre(),
                puerto!=0 ? puerto : 12345
        );
    }
}