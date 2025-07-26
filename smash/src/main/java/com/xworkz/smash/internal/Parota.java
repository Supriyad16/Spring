package com.xworkz.smash.internal;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;



@Component
public class Parota {

    public Parota() {

        System.out.println("Running parota in spring");
    }
}
