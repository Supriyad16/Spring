package com.xworkz.suitcase.configuration;


import com.xworkz.suitcase.component.ClothSuitcase;
import com.xworkz.suitcase.component.PlasticSuitcase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.xworkz.suitcase")
public class SuitcaseConfiguration {

    public SuitcaseConfiguration(){
        System.out.println("No-arg constructor of SuitcaseConfiguration");
    }

    @Bean
   public PlasticSuitcase plasticSuitcase(){
        return new PlasticSuitcase();
   }

   @Bean
    public ClothSuitcase clothSuitcase(){
        return new ClothSuitcase();
   }

}
