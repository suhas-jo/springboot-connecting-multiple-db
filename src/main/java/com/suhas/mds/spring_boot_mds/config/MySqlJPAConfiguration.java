package com.suhas.mds.spring_boot_mds.config;


import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.util.Objects;

@Configuration
@EnableJpaRepositories(
        basePackages = "com.suhas.mds.spring_boot_mds.productrepository",
        entityManagerFactoryRef = "mySqlEntityManagerFactory",
        transactionManagerRef = "mySqlTxnMngr"
)
public class MySqlJPAConfiguration {

    @Bean
    LocalContainerEntityManagerFactoryBean mySqlEntityManagerFactory(EntityManagerFactoryBuilder entityManagerFactoryBuilder,
                                                     @Qualifier("getMysqlDatasource") DataSource datasource){
        return entityManagerFactoryBuilder
                .dataSource(datasource)
                .packages("com.suhas.mds.spring_boot_mds.productentity")
                .build();
    }

    @Bean
    PlatformTransactionManager mySqlTxnMngr(@Qualifier("mySqlEntityManagerFactory") LocalContainerEntityManagerFactoryBean emf){
        return new JpaTransactionManager(Objects.requireNonNull(emf.getObject()));
    }
}
