package com.xworkz.food.component;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

@Component
@RequestMapping("/")
public class BottleComponent {
    public BottleComponent(){
        System.out.println("Const of BottleComponent");
    }
    @RequestMapping("/bottle")
    public String getBottle(){
        System.out.println("getBottle method");
        return "bottle.jsp";
    }
}
