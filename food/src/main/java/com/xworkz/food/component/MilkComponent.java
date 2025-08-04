package com.xworkz.food.component;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

@Component
@RequestMapping("/")
public class MilkComponent {
    public MilkComponent(){
        System.out.println("const of MilkComponent");
    }
    @RequestMapping("/milk")
    public String getMilk(){
        System.out.println("getMilk method..");
        return "milk.jsp";
    }
}