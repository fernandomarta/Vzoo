package com.projecto.vzoo.Vzoo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HabitatsPageController {


    @GetMapping("/habitatspage")
    public String animals(Model model)
    {
        model.addAttribute("habitatspage", new HabitatsPage());
        return "habitatspage";
    }

    @PostMapping("/habitatspage")
    public String goToAnimals(Model model)
    {
        return "habitatspage";
    }






}
