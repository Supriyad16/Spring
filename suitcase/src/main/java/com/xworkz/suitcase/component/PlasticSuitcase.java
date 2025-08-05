package com.xworkz.suitcase.component;

import org.springframework.stereotype.Component;

@Component
public class PlasticSuitcase {

   public PlasticSuitcase(){
       System.out.println("No-arg constructor of PlasticSuitcase");
   }

   public void lock(){
       System.out.println("Lock the suitcase");
   }

}
