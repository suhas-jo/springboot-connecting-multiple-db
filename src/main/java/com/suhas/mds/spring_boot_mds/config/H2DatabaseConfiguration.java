package com.suhas.mds.spring_boot_mds.config;

import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

@Configuration
public class H2DatabaseConfiguration {

    @Bean
    @ConfigurationProperties("spring.datasource.h2")
    public DataSourceProperties getH2DataSourceProperties(){
        return new DataSourceProperties();
    }

    @Bean("H2DB")
    public DataSource getH2DataSource(){
        return getH2DataSourceProperties().initializeDataSourceBuilder().build();
    }

}
