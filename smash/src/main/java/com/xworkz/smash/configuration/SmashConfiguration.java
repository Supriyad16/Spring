package com.xworkz.smash.configuration;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.xworkz.smash")
public class SmashConfiguration {

    public SmashConfiguration(){
        System.out.println("SmashConfiguration");
    }
}
