package com.xworkz.food.component;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

@Component
@RequestMapping("/")
public class ChappalComponent {
    public ChappalComponent(){
        System.out.println("const of ChappalComponent");
    }

    @RequestMapping("/chappal")
    public String getChappal(){
        System.out.println("getChappal method..");
        return "chappal.jsp";
    }
}