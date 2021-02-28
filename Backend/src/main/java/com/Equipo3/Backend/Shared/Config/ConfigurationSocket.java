package com.Equipo3.Backend.Shared.Config;

import com.Equipo3.Backend.Shared.Dominio.Socket.SocketServer;
import com.Equipo3.Backend.Shared.Infraestructura.Socket.SocketServerTCP;
import lombok.SneakyThrows;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;

@Configuration
public class ConfigurationSocket {

    @SneakyThrows
    @Bean
    public SocketServer createSocketServer() {
            return new SocketServerTCP();
    }
}
