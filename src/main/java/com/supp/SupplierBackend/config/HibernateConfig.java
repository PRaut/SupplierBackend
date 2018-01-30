package com.supp.SupplierBackend.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan(basePackages = { "com.supp.SupplierBackend" })
@EnableTransactionManagement
public class HibernateConfig {
	
	private static final String DB_URL = "jdbc:h2:tcp://localhost/~/supplier";
	private static final String DB_DRIVER = "org.h2.Driver";
	private static final String DB_USERNAME = "sa";
	private static final String DB_PASSWORD = "";
	
	private static final String HIBERNATE_DIALECT = "org.hibernate.dialect.H2Dialect";
	
	
	@Bean(name="datasource")
	public DataSource getH2DataSource(){
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setUrl(DB_URL);
		dataSource.setDriverClassName(DB_DRIVER);
		dataSource.setUsername(DB_USERNAME);
		dataSource.setPassword(DB_PASSWORD);
		System.out.println("Accessing datasource");
		return dataSource;
	}
	
	private Properties getHibernarteProperties(){
		Properties properties = new Properties();
		properties.put("hibernate.dialect", HIBERNATE_DIALECT);
		properties.put("hibernate.show_sql", true);
		properties.put("hibernate.hbm2ddl.auto", "update");
		System.out.println("Properties loaded");
		return properties;
	}
	
	@Autowired
	@Bean(name="sessionFactory")
	public SessionFactory getSessionFactory(DataSource dataSource){
		LocalSessionFactoryBuilder builder = new LocalSessionFactoryBuilder(dataSource); 
		builder.addProperties(getHibernarteProperties());
		System.out.println("Properties Loaded");
		builder.scanPackages("com.supp.SupplierBackend.model");
		return builder.buildSessionFactory();
	}
	
	@Autowired
	@Bean(name="transactionManager")
	public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory){
		HibernateTransactionManager transactionManager = new HibernateTransactionManager(sessionFactory);
		return transactionManager;
	}

	
}
