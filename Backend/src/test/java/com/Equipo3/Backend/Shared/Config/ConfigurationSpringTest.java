package com.Equipo3.Backend.Shared.Config;

import net.fortuna.ical4j.model.component.VAlarm;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan("com.Equipo3.Backend.*")
@Import(value = {ConfigurationPersistenceTest.class,ConfigurationMongoTest.class})
public class ConfigurationSpringTest {

    public ConfigurationSpringTest() {
        System.setProperty("org.jboss.logging.provider","log4j2");
    }
}