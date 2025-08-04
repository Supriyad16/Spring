package com.xworkz.food.component;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

@Component
@RequestMapping("/")
public class OnionComponent {
    public OnionComponent(){
        System.out.println("const of Onion Component");
    }
    @RequestMapping("/onion")
    public String getOnion(){
        System.out.println("getOnion method..");
        return "onion.jsp";
    }
}