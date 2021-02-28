package com.Equipo3.Backend.Shared.Config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan("com.Equipo3.Backend.*")
@EnableJpaAuditing(auditorAwareRef="customAuditorAware")
@EnableTransactionManagement
@Import(value = {ConfigurationPersistence.class, ConfigurationSocket.class})
public class ConfigurationSpring {
}