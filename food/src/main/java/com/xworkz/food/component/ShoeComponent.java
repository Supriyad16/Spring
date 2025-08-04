package com.xworkz.food.component;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

@Component
@RequestMapping("/")
public class ShoeComponent {
    public ShoeComponent(){
        System.out.println("const of shoecomponent");
    }
    @RequestMapping("/shoe")
    public String getShoe(){
        System.out.println("getShoe method..");
        return "shoe.jsp";
    }
}