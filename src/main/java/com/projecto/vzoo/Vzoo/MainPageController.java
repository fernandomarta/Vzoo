package com.projecto.vzoo.Vzoo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MainPageController {

    @GetMapping("/mainpage")
    public String hello(Model model)
    {
        model.addAttribute("mainpage", new MainPage());
        return "mainpage";
    }

    @PostMapping("/mainpage")
    public String goToMainPage(@ModelAttribute MainPage mainPage) {
        return "mainpage";
    }

//    @PostMapping("/mainpage")
//    public String goToAnimalsPage(@ModelAttribute AnimalsPage mainPage) {
//        return "animalspage";
//    }
//
//    @PostMapping("/mainpage")
//    public String goToHabitatsPage(@ModelAttribute HabitatsPage mainPage) {
//        return "habitatspage";
//    }
//
//    @PostMapping("/mainpage")
//    public String goToAttendantsPage(@ModelAttribute AttendantsPage mainPage) {
//        return "attendantspage";
//    }

}
