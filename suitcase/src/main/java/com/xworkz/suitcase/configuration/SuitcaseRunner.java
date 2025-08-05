package com.xworkz.suitcase.configuration;

import com.xworkz.suitcase.component.ClothSuitcase;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.applet.AppletContext;

public class SuitcaseRunner {

    public static void main(String[] args) {


        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(SuitcaseConfiguration.class);

        ClothSuitcase clothSuitcase = applicationContext.getBean(ClothSuitcase.class);
        clothSuitcase.pack();

    }
}
