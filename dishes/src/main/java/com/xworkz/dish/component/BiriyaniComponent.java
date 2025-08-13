package com.xworkz.dish.component;


import com.xworkz.dish.dto.BiriyaniDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")

public class BiriyaniComponent {

    public BiriyaniComponent(){
        System.out.println("No arg const of BiriyaniComponent");
    }


    @RequestMapping("biriyani")
    public String getBiriyani(BiriyaniDTO biriyaniDTO, Model model) {
        System.out.println("getBiriyani method");

        model.addAttribute("name",biriyaniDTO.getName());
        model.addAttribute("type",biriyaniDTO.getType());
        model.addAttribute("origin",biriyaniDTO.getOrigin());
        model.addAttribute("price",biriyaniDTO.getPrice());
        model.addAttribute("quantity",biriyaniDTO.getQuantity());


        return "BiriyaniResult";

}
}

