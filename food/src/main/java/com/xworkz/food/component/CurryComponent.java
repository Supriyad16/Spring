package com.xworkz.food.component;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

@Component
@RequestMapping("/")
public class CurryComponent {
    public CurryComponent(){
        System.out.println("const of CurryComponent");
    }
    @RequestMapping("/curry")
    public String getCurry(){
        System.out.println("getCurry method..");
        return "curry.jsp";
    }
}