package com.xworkz.library.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


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
}

