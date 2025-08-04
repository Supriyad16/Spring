package com.xworkz.food.component;


import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

@Component
@RequestMapping("/")
public class SocksComponent {
    public SocksComponent(){
        System.out.println("const of SockComponent");
    }
    @RequestMapping("/socks")
    public String getSocks(){
        System.out.println("getSock method");
        return "socks.jsp";
    }
}