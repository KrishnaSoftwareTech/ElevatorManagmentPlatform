package com.CentralElevatorManagement.Application.DB;

import javax.sql.DataSource;

import org.hibernate.cfg.Environment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

/**
 * @author krishnakumar
 *
 */
@Configuration
public class DataSourceConfig {

    @Bean
    @Profile("dev")
    public DataSource h2DataSource() {
        return new EmbeddedDatabaseBuilder()
            .setType(EmbeddedDatabaseType.H2)
            .build();
    }

    @Bean
    @Profile("prod")
    public DataSource mysqlDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
//        dataSource.setDriverClassName(environment.getProperty("spring.datasource.prod.driver-class-name"));
//        dataSource.setUrl(environment.getProperty("spring.datasource.prod.url"));
//        dataSource.setUsername(environment.getProperty("spring.datasource.prod.username"));
//        dataSource.setPassword(environment.getProperty("spring.datasource.prod.password"));
        return dataSource;
    }

    @Autowired
    private Environment environment;

}
