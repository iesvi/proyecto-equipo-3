package com.Equipo3.Backend.Shared.Infraestructura.Socket;

import com.Equipo3.Backend.Shared.Aplicacion.Dto;
import com.Equipo3.Backend.Shared.Dominio.Socket.SocketServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SocketServerHandler {

    @Autowired

    SocketServer socket;

    public SocketServerHandler() {

    }

    public void send(Dto object) {
        socket.Send(object);
    }
}