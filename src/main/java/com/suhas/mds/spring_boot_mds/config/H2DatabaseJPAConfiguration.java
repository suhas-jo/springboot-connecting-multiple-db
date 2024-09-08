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
        basePackages = "com.suhas.mds.spring_boot_mds.orderrepository",
        entityManagerFactoryRef = "h2EntityManager",
        transactionManagerRef = "h2DBTxnMngr"
)
public class H2DatabaseJPAConfiguration {

    @Bean
    LocalContainerEntityManagerFactoryBean h2EntityManager(EntityManagerFactoryBuilder entityManagerFactoryBuilder,
                                                           @Qualifier("H2DB") DataSource dataSource){
        return entityManagerFactoryBuilder
                .dataSource(dataSource)
                .packages("com.suhas.mds.spring_boot_mds.orderentity")
                .build();

    }

    @Bean
    PlatformTransactionManager h2DBTxnMngr(@Qualifier("h2EntityManager") LocalContainerEntityManagerFactoryBean emf){
        return new JpaTransactionManager(Objects.requireNonNull(emf.getObject()));
    }
}
