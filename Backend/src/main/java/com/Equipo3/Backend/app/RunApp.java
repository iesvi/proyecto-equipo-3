package com.Equipo3.Backend.app;

import com.Equipo3.Backend.Shared.Infraestructura.Socket.SocketServerHandler;
import com.Equipo3.Backend.Usuario.Dominio.DTO.UsuarioDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RunApp {

    @Autowired
    SocketServerHandler handler;

    public void run() {
        handler.send(new UsuarioDTO());
    }
}
