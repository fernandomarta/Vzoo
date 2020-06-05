package com.projecto.vzoo.Vzoo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.projecto.vzoo.Vzoo.entities.Attendant;
import com.projecto.vzoo.Vzoo.repositories.AttendantRepository;

@Controller
public class AttendantsPageController {
	
    private AttendantRepository attendantRepository;
	
    @Autowired
    public AttendantsPageController(AttendantRepository attendantRepository) {
        this.attendantRepository = attendantRepository;
    }

    @GetMapping("/attendantspage")
    public String attendants(Model model)
    {
        model.addAttribute("attendants", attendantRepository.findAll());
        return "attendantspage";
    }

    @PostMapping("/attendantspage")
    public String goToAttendant(Model model)
    {
    	 model.addAttribute("attendants", attendantRepository.findAll());
         return "attendantspage";
    }

    @GetMapping("/showAddAttendant")
    public String showAddAttendant(Attendant attendant) {
        return "attendant_criar_novo";
    }

    @PostMapping("/addAttendant")
    public String addAttendant(@Validated Attendant attendant, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "attendant_criar_novo";
        }

        attendantRepository.save(attendant);
        model.addAttribute("attendants", attendantRepository.findAll());
        return "attendantspage";
    }

    @GetMapping("/deleteAttendant/{id}")
    public String deleteAttendant(@PathVariable("id") long id, Model model) {
    	Attendant attendant = attendantRepository.findById(id);
        if (attendant != null) {
        	attendantRepository.delete(attendant);
        }
        model.addAttribute("attendants", attendantRepository.findAll());
        return "attendantspage";
    }

}
