package com.Equipo3.Backend.app;

import com.Equipo3.Backend.Shared.Config.ConfigurationSpring;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.HashSet;
import java.util.Set;

public class app {

    public static void main(String[] args) {



        ApplicationContext appContext = new AnnotationConfigApplicationContext(ConfigurationSpring.class);

        RunApp runApp = appContext.getBean(RunApp.class);

        runApp.run();

        ((AnnotationConfigApplicationContext) appContext).close();

    }


}
