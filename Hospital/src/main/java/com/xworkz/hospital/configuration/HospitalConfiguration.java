package com.xworkz.hospital.configuration;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.persistence.EntityManagerFactory;


@Configuration
@ComponentScan(basePackages = "com.xworkz.hospital")
@EnableWebMvc
@PropertySource("classpath:application.properties")
@Slf4j
@EnableTransactionManagement
@EnableScheduling

public class HospitalConfiguration implements WebMvcConfigurer {

    public HospitalConfiguration(){
        log.info("Created \t"+this.getClass().getSimpleName());
    }

    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer defaultServletHandlerConfigurer){
        defaultServletHandlerConfigurer.enable();

    }

    public void configureViewResolvers(ViewResolverRegistry resolverRegistry){
        resolverRegistry.jsp("/",".jsp");
    }

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer(){
        return new PropertySourcesPlaceholderConfigurer();
    }

    @Bean
    public PlatformTransactionManager transactionManager(EntityManagerFactory emf) {
        return new JpaTransactionManager(emf);
    }



    @Bean(name = "multipartResolver")
    public CommonsMultipartResolver commonsMultipartResolver (){
        CommonsMultipartResolver commonsMultipartResolver = new CommonsMultipartResolver();
        commonsMultipartResolver.setMaxUploadSize(1025231);
        commonsMultipartResolver.setMaxInMemorySize(1025231);
        return commonsMultipartResolver;

    }


//    @Component
//    public class MyScheduler {
//
//        @Scheduled(fixedRate = 5000) // Executes every 5 seconds
//        public void fixedRateTask() {
//            System.out.println("Fixed rate task executed at: " + System.currentTimeMillis());
//        }
//    }

    @Bean
    public ThreadPoolTaskScheduler threadPoolTaskScheduler(){
        ThreadPoolTaskScheduler threadPoolTaskScheduler=new ThreadPoolTaskScheduler();
        threadPoolTaskScheduler.setPoolSize(10);
        return threadPoolTaskScheduler;
    }
}

