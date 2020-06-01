package com.projecto.vzoo.Vzoo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.projecto.vzoo.Vzoo.entities.Specie;
import com.projecto.vzoo.Vzoo.repositories.SpecieRepository;

@Controller
public class SpeciePageController {
	
    private SpecieRepository specieRepository;
	
    @Autowired
    public SpeciePageController(SpecieRepository specieRepository) {
        this.specieRepository = specieRepository;
    }

    @GetMapping("/speciespage")
    public String species(Model model)
    {
        model.addAttribute("species", specieRepository.findAll());
        return "speciespage";
    }

    @PostMapping("/speciespage")
    public String goToSpecie(Model model)
    {
    	 model.addAttribute("species", specieRepository.findAll());
         return "speciespage";
    }

    @GetMapping("/showAddSpecie")
    public String showAddSpecie(Specie specie) {
        return "specie_criar_novo";
    }

    @PostMapping("/addSpecie")
    public String addSpecie(@Validated Specie specie, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "specie_criar_novo";
        }

        specieRepository.save(specie);
        model.addAttribute("species", specieRepository.findAll());
        return "speciespage";
    }

    @GetMapping("/deleteSpecie/{id}")
    public String deleteSpecie(@PathVariable("id") long id, Model model) {
    	Specie specie = specieRepository.findById(id);
        if (specie != null) {
        	specieRepository.delete(specie);
        }
        model.addAttribute("species", specieRepository.findAll());
        return "speciespage";
    }

}
