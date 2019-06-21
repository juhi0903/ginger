package com.globocom.config;

import java.util.Properties;

import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import static org.hibernate.cfg.Environment.*;

@Configuration
@PropertySource("classpath:db.properties")
@EnableTransactionManagement
//@ComponentScans(value = { @ComponentScan("com.globocom")})

@ComponentScan("com.globocom")
public class AppConfig extends WebMvcConfigurerAdapter{

   @Autowired
   private Environment env;
   
   @Override
	public void addCorsMappings(CorsRegistry registry) {
	  registry.addMapping("/**")

	   	  .allowedOrigins("http://localhost:4200", "http://localhost:8000" ,"http://127.0.0.1:8000" ,"http://43.231.124.147:8585")
	  	  //.allowedOrigins("/**")
		  .allowedMethods("POST", "GET",  "PUT", "OPTIONS", "DELETE")
		  .allowedHeaders("X-Auth-Token", "Content-Type")
		  .exposedHeaders("custom-header1", "custom-header2")
		  .allowCredentials(false)
		  .maxAge(4800);
	}
   
   /*@Bean(name = "multipartResolver")
	public CommonsMultipartResolver CanBeAnyName() { 
	   CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
	   multipartResolver.setMaxUploadSize(100000);
	   return multipartResolver;
   }*/
   @Bean
   public MultipartResolver multipartResolver() {
       return new StandardServletMultipartResolver();
   }

   @Bean
   public LocalSessionFactoryBean getSessionFactory() {
      LocalSessionFactoryBean factoryBean = new LocalSessionFactoryBean();

      Properties props = new Properties();
      // Setting JDBC properties
      props.put(DRIVER, env.getProperty("mysql.driver"));
      props.put(URL, env.getProperty("mysql.url"));
      props.put(USER, env.getProperty("mysql.user"));
      props.put(PASS, env.getProperty("mysql.password"));

      // Setting Hibernate properties
      props.put(SHOW_SQL, env.getProperty("hibernate.show_sql"));
      props.put(HBM2DDL_AUTO, env.getProperty("hibernate.hbm2ddl.auto"));
//      props.put(HBM2DDL_CHARSET_NAME, "UTF-8");

      // Setting C3P0 properties
      props.put(C3P0_MIN_SIZE, env.getProperty("hibernate.c3p0.min_size"));
      props.put(C3P0_MAX_SIZE, env.getProperty("hibernate.c3p0.max_size"));
      props.put(C3P0_ACQUIRE_INCREMENT,env.getProperty("hibernate.c3p0.acquire_increment"));
      props.put(C3P0_TIMEOUT, env.getProperty("hibernate.c3p0.timeout"));
      props.put(C3P0_MAX_STATEMENTS, env.getProperty("hibernate.c3p0.max_statements"));

      factoryBean.setHibernateProperties(props);
      factoryBean.setPackagesToScan("com.globocom.model");


      return factoryBean;
   }
   
   @Bean
   public HibernateTransactionManager getTransactionManager() {
      HibernateTransactionManager transactionManager = new HibernateTransactionManager();
      transactionManager.setSessionFactory(getSessionFactory().getObject());
      return transactionManager;
   }
}
