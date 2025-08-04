package com.xworkz.food.component;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

@Component
@RequestMapping("/")
public class ChutneyComponent {
    public ChutneyComponent(){
        System.out.println("const of ChutneyComponent");
    }

    @RequestMapping("/chutney")
    public String getChutney(){
        System.out.println("getChutney Method");
        return "chutney.jsp";
    }
}