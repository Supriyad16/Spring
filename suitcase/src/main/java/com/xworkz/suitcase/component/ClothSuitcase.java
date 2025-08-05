package com.xworkz.suitcase.component;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ClothSuitcase {

    public ClothSuitcase(){
        System.out.println("No-arg constructor of ClothSuitcase");

    }
    @Autowired
    private PlasticSuitcase plasticSuitcase;

    public void pack(){
        System.out.println("Pack the clothes");
        plasticSuitcase.lock();
    }
}
