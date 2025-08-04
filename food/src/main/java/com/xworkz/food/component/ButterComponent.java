package com.xworkz.food.component;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

@Component
@RequestMapping("/")
public class ButterComponent {
    public ButterComponent(){
        System.out.println("Const of ButterComponenet");
    }
    @RequestMapping("/butter")
    public String getButter(){
        System.out.println("getButter method");
        return "butter.jsp";
    }
}