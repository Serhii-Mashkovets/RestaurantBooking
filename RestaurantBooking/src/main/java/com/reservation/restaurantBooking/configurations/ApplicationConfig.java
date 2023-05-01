package com.reservation.restaurantBooking.configurations;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.jpa.JpaTransactionManager;


import java.util.Properties;

/**
 * Configuration class for the restaurant booking application.
 * This class is responsible for configuring various beans such as the entity manager factory, transaction manager,
 * and reservation service.
 * It also sets up the necessary properties for hibernate and loads them from the application.properties file using
 * the Environment object.
 * This class is annotated with @Configuration to indicate that it is a Spring configuration class.
 * It is also annotated with @PropertySource to specify the location of the application.properties file.
 */
@Configuration
@PropertySource("classpath:application.properties")
public class ApplicationConfig {



    /**
     * The Environment object used to retrieve properties from the application.properties file.
     */
    @Autowired
    private Environment env;

    /**
     * The DatabaseConfig object used to retrieve the data source for the entity manager factory.
     */
    @Autowired
    public DatabaseConfig databaseConfig;



    /**
     * Creates and returns a Properties object with the necessary properties for hibernate.
     *
     * @return a Properties object with the necessary properties for hibernate.
     */
    @Bean
    public Properties getHibernateProperties() {
        Properties properties = new Properties();
        properties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
        properties.setProperty("hibernate.show_sql", "true");

        return properties;
    }


    private Properties setHibernateProperties() {
        Properties properties = new Properties();
        properties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
        properties.setProperty("hibernate.show_sql", "true");

        return properties;
    }


    /**
     * Creates and returns a new instance of LocalContainerEntityManagerFactoryBean.
     * <p>
     * This method sets up the necessary properties for the entity manager factory such as the data source, packages to scan,
     * jpa vendor adapter, and hibernate properties.
     *
     * @return a new instance of LocalContainerEntityManagerFactoryBean.
     */

    /**
     * Creates and returns a new instance of JpaTransactionManager.
     * <p>
     * This method sets the entity manager factory for the transaction manager.
     *
     * @return a new instance of JpaTransactionManager.
     */
    @Bean
    public JpaTransactionManager transactionManager() {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(databaseConfig.entityManagerFactory().getObject());

        return transactionManager;
    }


}

