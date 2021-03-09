package com.Equipo3.Backend.Shared.Config;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@SpringBootTest
@ComponentScan("com.Equipo3.Backend.*")
@EnableJpaAuditing(auditorAwareRef = "customAuditorAware")
@EnableTransactionManagement
@Import(value = {ConfigurationPersistenceTest.class, ConfigurationMongoTest.class})
public class ConfigurationSpringTest {

    public ConfigurationSpringTest() {
        System.setProperty("org.jboss.logging.provider", "log4j2");
    }
}