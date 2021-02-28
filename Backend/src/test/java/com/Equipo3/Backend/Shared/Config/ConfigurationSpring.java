package com.Equipo3.Backend.Shared.Config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.orm.jpa.*;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan("com.Equipo3.Backend.*")
@EnableTransactionManagement
@Import(ConfigurationPersistence.class)
public class ConfigurationSpring {


}