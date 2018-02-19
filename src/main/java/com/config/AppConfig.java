package com.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.drivers.DataBaseDriver;
import com.drivers.MySqlDriver;
import com.drivers.OracleDriver;

@Configuration
@ComponentScan("com.service")
// no chi lay @Service nen de la com.service cung dc
@PropertySource("classpath:oracledatabase.properties")
public class AppConfig {
    @Autowired
    Environment environment;

    @Bean
    DataBaseDriver oracleDriver() {
        OracleDriver oracleDriver = new OracleDriver();
        oracleDriver.setDriver(environment.getProperty("db.driver"));
        oracleDriver.setUrl(environment.getProperty("db.url"));
        oracleDriver.setPort(Integer.parseInt(environment.getProperty("db.port")));
        oracleDriver.setUser(environment.getProperty("db.user"));
        oracleDriver.setPassword(environment.getProperty("db.password"));

        return oracleDriver;

    }

    @Bean
    DataBaseDriver mysqlDriver() {
        return new MySqlDriver();
    }
}
