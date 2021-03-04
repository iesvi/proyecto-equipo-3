package com.Equipo3.Backend.Shared.Config;

import com.Equipo3.Backend.Shared.Config.ConfigThread;
import com.Equipo3.Backend.Shared.Dominio.Socket.SocketServer;
import com.Equipo3.Backend.Shared.Infraestructura.Socket.MultiThreadedServerTcp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.core.task.TaskExecutor;

@Configuration
//@ComponentScan(value = {"com.iesvi"},excludeFilters = @ComponentScan.Filter(Configuration.class))
@Import({ConfigThread.class})
public class ConfigurationSocketTest {

    @Autowired
    private TaskExecutor taskExecutor;

    @Bean
    public SocketServer createSocketServer() {
        MultiThreadedServerTcp server = new MultiThreadedServerTcp(5555);
        //new Thread(server).start();
        taskExecutor.execute(server);

        return server;
    }

}
