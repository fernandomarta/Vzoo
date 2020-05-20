package com.projecto.vzoo.Vzoo;

import com.projecto.vzoo.Vzoo.entities.Attendant;
import com.projecto.vzoo.Vzoo.repositories.AttendantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

//import javax.validation.Validated;

@Controller
public class AttendantsPageController {
    private AttendantRepository attendantRepository;

    @Autowired
    public AttendantsPageController(AttendantRepository repository) {
        this.attendantRepository = repository;
    }


    @GetMapping("/createAttendants")
    public String createAttendants(Attendant attendant) {
        return "add-attendant";
    }


    @PostMapping("/addAttendant")
    public String addAttendant(@Validated Attendant attendant, BindingResult result, Model model) {
        attendantRepository.save(attendant);
        model.addAttribute("attendants", attendantRepository.findAll());
        return "attendantspage";
    }











    @GetMapping("/attendantspage")
    public String attendants(Model model)
    {
        model.addAttribute("attendantspage", new com.projecto.vzoo.Vzoo.AttendantsPage());
        return "attendantspage";
    }

    @PostMapping("/attendantspage")
    public String goToAnimals(Model model)
    {
        return "attendantspage";
    }
}
