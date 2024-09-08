package com.suhas.mds.spring_boot_mds.config;

import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
public class MySqlConfiguration {

    @ConfigurationProperties("spring.datasource.mysql")
    @Bean
    public DataSourceProperties getDataSourceProperties(){
        return new DataSourceProperties();
    }

    @Primary
    @Bean
    public DataSource getMysqlDatasource(){

  /*      DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl(getDataSourceProperties().getUrl());
        dataSource.setUsername(getDataSourceProperties().getUsername());
        dataSource.setPassword(getDataSourceProperties().getPassword());
        dataSource.setDriverClassName(getDataSourceProperties().getDriverClassName());

        return dataSource;*/

        return getDataSourceProperties().initializeDataSourceBuilder().build();
    }
}
