package com.lushnikova.jpa.config;

import jakarta.persistence.EntityManagerFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;


@Configuration
@EnableJpaRepositories("com.lushnikova.jpa")
@EnableTransactionManagement
@RequiredArgsConstructor
@PropertySource("classpath:database.properties")
@ComponentScan(value = "com.lushnikova.jpa")
public class AppConfig{

    private final Environment environment;

    private final String URL = "url";
    private final String USER = "dbuser";
    private final String DRIVER = "driver";
    private final String PASSWORD = "dbpassword";

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
        driverManagerDataSource.setUrl(environment.getProperty(URL));
        driverManagerDataSource.setUsername(environment.getProperty(USER));
        driverManagerDataSource.setPassword(environment.getProperty(PASSWORD));
        driverManagerDataSource.setDriverClassName(environment.getProperty(DRIVER));
        return driverManagerDataSource;
    }

   @Bean
    public EntityManagerFactory entityManagerFactory() {
       HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
       vendorAdapter.setGenerateDdl(true);
       vendorAdapter.setShowSql(true);
       LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
       factory.setJpaVendorAdapter(vendorAdapter);
       factory.setPackagesToScan("com.lushnikova.jpa");
       factory.setDataSource(dataSource());
       factory.afterPropertiesSet();
       return factory.getObject();
   }

    @Bean
    public PlatformTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
        JpaTransactionManager txManager = new JpaTransactionManager();
        txManager.setEntityManagerFactory(entityManagerFactory);
        return txManager;
    }
}