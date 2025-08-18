package com.xworkz.forms.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;



    @Configuration
    @ComponentScan(basePackages = "com.xworkz.forms")
    @EnableWebMvc

    public class FormConfiguration implements WebMvcConfigurer {


        public void configureDefaultServletHandling(DefaultServletHandlerConfigurer defaultServletHandlerConfigurer){
            defaultServletHandlerConfigurer.enable();

        }

        public void configureViewResolvers(ViewResolverRegistry resolverRegistry){
            resolverRegistry.jsp("/",".jsp");
        }
    }

