package com.xworkz.food.component;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

    @Component
    @RequestMapping("/")
    public class EggComponent {
        public EggComponent(){
            System.out.println("const EggComponent");
        }
        @RequestMapping("/egg")
        public String getEgg(){
            System.out.println("getEgg method...");
            return "egg.jsp";
        }
    }