package com.xworkz.food.component;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

@Component
@RequestMapping("/")
public class BiriyaniComponent {

    public BiriyaniComponent(){
        System.out.println("Running BiriryaniComponent const");
    }

    @RequestMapping("/biriyani")
    public String getBiriyani(){
        System.out.println("getBiriyani method..");
        return "biriyani.jsp";
    }

}
