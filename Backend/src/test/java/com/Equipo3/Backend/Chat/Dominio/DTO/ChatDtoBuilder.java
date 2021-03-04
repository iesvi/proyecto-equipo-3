package com.Equipo3.Backend.Chat.Dominio.DTO;

import com.Equipo3.Backend.Chat.Dominio.ChatVO;
import io.beanmother.core.ObjectMother;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.With;

@AllArgsConstructor
@NoArgsConstructor
@With
public class ChatDtoBuilder {

    private String nombre;
    private int puerto;

    public ChatDTO build() {
        ObjectMother om = ObjectMother.getInstance();
        ChatVO nmother= om.bear("chat", ChatVO.class);

        return new ChatDTO(
                nombre!=null ? nombre : nmother.getNombre(),
                puerto!=0 ? puerto : 12345
        );
    }

}
