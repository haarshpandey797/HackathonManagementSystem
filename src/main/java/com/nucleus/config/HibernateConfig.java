package com.nucleus.config;


import com.nucleus.model.security.Person;
import org.apache.log4j.Logger;
import org.hibernate.cfg.Environment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.annotation.EnableTransactionManagement;


import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

@Configuration
@EnableTransactionManagement
public class HibernateConfig{
    @Autowired
    Logger logger;

    @Bean
    public LocalSessionFactoryBean sessionFactory() {
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setDataSource(dataSource());
        sessionFactory.setPackagesToScan("com.nucleus");
        sessionFactory.setHibernateProperties(hibernateProperties());
        sessionFactory.setAnnotatedClasses(Person.class);
        return sessionFactory;
    }

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        InputStream input = getClass().getClassLoader()
                .getResourceAsStream("hibernate.properties");

        Properties properties = new Properties();
        try{
            properties.load(input);
            dataSource.setDriverClassName((String) properties.get("hibernate.connection.driver_class"));
            dataSource.setUrl((String) properties.get("hibernate.connection.url"));
            dataSource.setUsername((String) properties.get("hibernate.connection.username"));
            dataSource.setPassword((String) properties.get("hibernate.connection.password"));

        }catch (IOException e){
            logger.info(e.getMessage());
        }
        return dataSource;
    }

    private Properties hibernateProperties() {

        InputStream input = getClass().getClassLoader()
                .getResourceAsStream("hibernate.properties");

        Properties properties = new Properties();
        try {
            properties.load(input);
            properties.put(Environment.DIALECT, properties.get("hibernate.dialect"));
            properties.put(Environment.HBM2DDL_AUTO, properties.get("hibernate.hbm2ddl.auto"));
            properties.put(Environment.SHOW_SQL, properties.get("hibernate.show_sql"));
            properties.put(Environment.FORMAT_SQL, properties.get("hibernate.format_sql"));

        }catch(IOException e){
            logger.info(e.getMessage());
        }
        return properties;
    }

    @Bean
    public HibernateTransactionManager transactionManager() {
        HibernateTransactionManager transactionManager = new HibernateTransactionManager();
        transactionManager.setSessionFactory(sessionFactory().getObject());
        return transactionManager;
    }

}