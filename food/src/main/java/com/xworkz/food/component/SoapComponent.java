package com.xworkz.food.component;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

@Component
@RequestMapping("/")

public class SoapComponent {
    public SoapComponent(){
        System.out.println("Const of Soap Component");
    }
    @RequestMapping("/soap")
    public String getSoap(){
        System.out.println("Get Soap method");
        return "soap.jsp";
    }
}