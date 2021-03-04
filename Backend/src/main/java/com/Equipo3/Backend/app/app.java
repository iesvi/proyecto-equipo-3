package com.Equipo3.Backend.app;

import com.Equipo3.Backend.Shared.Config.ConfigurationSpring;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class app {

    public static void main(String[] args) {

        ApplicationContext appContext = new AnnotationConfigApplicationContext(ConfigurationSpring.class);

        RunApp runApp = appContext.getBean(RunApp.class);

        runApp.run();

        //((AnnotationConfigApplicationContext) appContext).close();

    }


}
