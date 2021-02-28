package com.Equipo3.Backend.Shared.Infraestructura.Socket;

import com.Equipo3.Backend.Shared.Aplicacion.Dto;
import com.Equipo3.Backend.Shared.Dominio.Socket.SocketServer;
import org.springframework.stereotype.Component;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class SocketServerTCP implements SocketServer {

    public SocketServerTCP() {
        //Inicialización del Socket ==> Configuración, etc...
        int aaa = 3;
    }

    @Override
    public void Send(Dto object) {
        throw new NotImplementedException();
    }
}