package com.xworkz.food.configuration;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class FoodConfigurationInit  extends AbstractAnnotationConfigDispatcherServletInitializer {
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[0];
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{FoodConfiguration.class};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/biriyani","/bottle","/butter","/chappal","/chutney","/curry","/egg","/index","/link","/milk","/onion","/parota","/shoe","/soap","/socks"};
    }
}
