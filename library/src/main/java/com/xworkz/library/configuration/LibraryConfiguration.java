package com.xworkz.library.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.sql.DataSource;
import java.util.Properties;


@Configuration
@ComponentScan(basePackages = "com.xworkz.library")
@EnableWebMvc
public class LibraryConfiguration implements WebMvcConfigurer {


    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer defaultServletHandlerConfigurer){
        defaultServletHandlerConfigurer.enable();

    }

    public void configureViewResolvers(ViewResolverRegistry resolverRegistry){
        resolverRegistry.jsp("/",".jsp");
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean localContainerEntityManagerFactoryBean(){

        LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();
        factoryBean.setDataSource(dataSource());
        factoryBean.setJpaProperties(jpaProperties());
        factoryBean.setPackagesToScan("com.xworkz.library.entity");
        factoryBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());

        return factoryBean;
    }

    public Properties jpaProperties(){
        Properties properties=new Properties();
        properties.setProperty("hibernate.hbm2ddl.auto","update");
        return properties;
    }

    public DataSource dataSource(){
        DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
        driverManagerDataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        driverManagerDataSource.setUrl("jdbc:mysql://localhost:3306/library");
        driverManagerDataSource.setUsername("root");
        driverManagerDataSource.setPassword("Xworkzodc@123");
        return  driverManagerDataSource;
    }

    @Bean(name = "multipartResolver")
    public CommonsMultipartResolver commonsMultipartResolver (){
        CommonsMultipartResolver commonsMultipartResolver = new CommonsMultipartResolver();
        commonsMultipartResolver.setMaxUploadSize(1025231);
        commonsMultipartResolver.setMaxInMemorySize(1025231);
        return commonsMultipartResolver;
    }
}

