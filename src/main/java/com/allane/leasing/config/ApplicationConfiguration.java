package com.allane.leasing.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages={"com.allane.leasing.repository"})
public class ApplicationConfiguration {

}
