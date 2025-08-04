package com.xworkz.food.configuration;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.xworkz.food")
public class FoodConfiguration {

    public FoodConfiguration(){
        System.out.println("No-arg constructor FoodConfiguration");
    }
}
