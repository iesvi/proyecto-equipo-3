package com.Equipo3.Backend.Shared.Config;

import com.Equipo3.Backend.Shared.Dominio.Socket.SocketServer;
import com.Equipo3.Backend.Shared.Infraestructura.ProductorConsumidor.ColaPeticiones;
import com.Equipo3.Backend.Shared.Infraestructura.Socket.MultiThreadedServerTcp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.TaskExecutor;

@Configuration
public class ConfigurationSocket {

    @Autowired
    private TaskExecutor taskExecutor;

    @Bean
    public SocketServer createSocketServer() {
        MultiThreadedServerTcp server = new MultiThreadedServerTcp(5555);
        taskExecutor.execute(server);

        return server;
    }
    @Bean
    public ColaPeticiones createColaPeticiones() {
        ColaPeticiones colaP = new ColaPeticiones();

        return colaP;
    }
}
