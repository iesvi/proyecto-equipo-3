package com.Equipo3.Backend.app;

import com.Equipo3.Backend.Shared.Config.ConfigurationSpring;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import(ConfigurationSpring.class)
public class appSpringBoot extends SpringBootServletInitializer// implements CommandLineRunner
{
    public static void main(String[] args) {
        SpringApplication.run(appSpringBoot.class, args);
    }

}