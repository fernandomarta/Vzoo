package com.projecto.vzoo.Vzoo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.projecto.vzoo.Vzoo.entities.Habitat;
import com.projecto.vzoo.Vzoo.repositories.HabitatRepository;

@Controller
public class HabitatsPageController {
	
    private HabitatRepository habitatRepository;
	
    @Autowired
    public HabitatsPageController(HabitatRepository habitatRepository) {
        this.habitatRepository = habitatRepository;
    }

    @GetMapping("/habitatspage")
    public String habitats(Model model)
    {
        model.addAttribute("habitats", habitatRepository.findAll());
        return "habitatspage";
    }

    @PostMapping("/habitatspage")
    public String goToHabitat(Model model)
    {
    	 model.addAttribute("habitats", habitatRepository.findAll());
         return "habitatspage";
    }

    @GetMapping("/showAddHabitat")
    public String showAddHabitat(Habitat habitat) {
        return "habitat_criar_novo";
    }

    @PostMapping("/addHabitat")
    public String addHabitat(@Validated Habitat habitat, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "habitat_criar_novo";
        }

        habitatRepository.save(habitat);
        model.addAttribute("habitats", habitatRepository.findAll());
        return "habitatspage";
    }

    @GetMapping("/deleteHabitat/{id}")
    public String deleteHabitat(@PathVariable("id") long id, Model model) {
    	Habitat habitat = habitatRepository.findById(id);
        if (habitat != null) {
        	habitatRepository.delete(habitat);
        }
        model.addAttribute("habitats", habitatRepository.findAll());
        return "habitatspage";
    }

}
