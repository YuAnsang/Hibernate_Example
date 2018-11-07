package com.github.as.config;

import java.util.Properties;
import javax.sql.DataSource;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories("com.github.as.data.repository")
@PropertySource("classpath:db.properties")
public class HibernateConfiguration {
    
    @Autowired
    private Environment env;
    
    @Bean(name = "transactionManager")
    public JpaTransactionManager getTransactionManager() {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setDataSource(getDataSource());
       return transactionManager;
    }
    
    @Bean(name = "entityManagerFactory")
    public LocalContainerEntityManagerFactoryBean getEntityManagerFactory() {
        LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();
       
       Properties props = new Properties();
       props.put("hibernate.show_sql", env.getProperty("hibernate.show_sql"));
       props.put("hibernate.format_sql", env.getProperty("hibernate.format_sql"));
       props.put("hibernate.dialect", env.getProperty("hibernate.dialect"));
       props.put("hibernate.physical_naming_strategy", "com.github.as.config.PhysicalNamingStrategyImpl");
       
       factoryBean.setDataSource(getDataSource());
       factoryBean.setJpaProperties(props);
       factoryBean.setPackagesToScan("com.github.as.data.entity");
       factoryBean.setJpaVendorAdapter(getHibernateJpaVendorAdapter());
       
       return factoryBean;
    }
    
    @Bean
    public DataSource getDataSource() {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName(env.getProperty("db.driver"));
        dataSource.setUrl(env.getProperty("db.url"));
        dataSource.setUsername(env.getProperty("db.username"));
        dataSource.setPassword(env.getProperty("db.password"));
        return dataSource;
    }
    
    @Bean
    public HibernateJpaVendorAdapter getHibernateJpaVendorAdapter() {
        return new HibernateJpaVendorAdapter();
    }
}
