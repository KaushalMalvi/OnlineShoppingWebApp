package com.ksm.ShoppingBackend.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan(basePackages = "com.ksm.ShoppingBackend.dto")
@EnableTransactionManagement
public class HibernateConfig {

	// Change the below code base on Database
	public static final String DRIVER_CLASS = "org.h2.Driver";
	public static final String JDBC_URL = "jdbc:h2:tcp://localhost/~/onlineshopping";
	public static final String DIALECT = "org.hibernate.dialect.H2Dialect";
	public static final String USERNAME = "sa";
	public static final String PASSWORD = "";

	// DataSource bean Providing database connection information
	@Bean
	public DataSource getDataSource() {

		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName(DRIVER_CLASS);
		dataSource.setUrl(JDBC_URL);
		dataSource.setUsername(USERNAME);
		dataSource.setPassword(PASSWORD);

		return dataSource;
	}

	// SessionFactory bean provides session of datasource object
	@Bean
	public SessionFactory getSessionFactory(DataSource dataSource) {

		LocalSessionFactoryBuilder builder = new LocalSessionFactoryBuilder(dataSource);

		builder.addProperties(getHibernateProperties());
		builder.scanPackages("com.ksm.ShoppingBackend.dto");
		return builder.buildSessionFactory();
	}

	// Add all hibernate properties here
	private Properties getHibernateProperties() {

		Properties properties = new Properties();

		properties.put("hibernate.dialect", DIALECT);
		properties.put("hibernate.show_sql", "true");
		properties.put("hibernate.format_sql", "true");
		return properties;
	}

	// HibernateTranscationManager is use for manage the transcation
	@Bean
	public HibernateTransactionManager getTranscationManager(SessionFactory factory) {

		HibernateTransactionManager transactionManager = new HibernateTransactionManager(factory);
		return transactionManager;
	}
}
