package com.Equipo3.Backend.Shared.Config;

import com.Equipo3.Backend.Shared.Dominio.Socket.SocketServer;
import com.Equipo3.Backend.Shared.Infraestructura.Socket.SocketServerTCP;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigurationSocket {

    @Bean
    public SocketServer createSocketServer() {
        return new SocketServerTCP();
    }
}
