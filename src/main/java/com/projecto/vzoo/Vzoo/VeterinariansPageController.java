package com.projecto.vzoo.Vzoo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.projecto.vzoo.Vzoo.entities.Veterinarian;
import com.projecto.vzoo.Vzoo.repositories.SpecieRepository;
import com.projecto.vzoo.Vzoo.repositories.VeterinarianRepository;

@Controller
public class VeterinariansPageController {
	
    private VeterinarianRepository veterinarianRepository;
    private SpecieRepository specieRepository;
	
    @Autowired
    public VeterinariansPageController(VeterinarianRepository veterinarianRepository, SpecieRepository specieRepository) {
        this.veterinarianRepository = veterinarianRepository;
        this.specieRepository = specieRepository;
    }

    @GetMapping("/veterinarianspage")
    public String veterinarians(Model model) {
        model.addAttribute("veterinarians", veterinarianRepository.findAll());
        return "veterinarianspage";
    }

    @PostMapping("/veterinarianspage")
    public String goToVeterinarian(Model model) {
    	 model.addAttribute("veterinarians", veterinarianRepository.findAll());
         return "veterinarianspage";
    }

    @GetMapping("/showAddVeterinarian")
    public String showAddVeterinarian(Veterinarian veterinarian, Model model) {
    	model.addAttribute("speciesList", specieRepository.findAll());
    	
    	return "veterinarian_criar_novo";
    }

    @PostMapping("/addVeterinarian")
    public String addVeterinarian(@Validated Veterinarian veterinarian, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "veterinarian_criar_novo";
        }

        veterinarianRepository.save(veterinarian);
        model.addAttribute("veterinarians", veterinarianRepository.findAll());
        return "veterinarianspage";
    }

    @GetMapping("/deleteVeterinarian/{id}")
    public String deleteVeterinarian(@PathVariable("id") long id, Model model) {
    	Veterinarian veterinarian = veterinarianRepository.findById(id);
        if (veterinarian != null) {
        	veterinarianRepository.delete(veterinarian);
        }
        model.addAttribute("veterinarians", veterinarianRepository.findAll());
        return "veterinarianspage";
    }

}
