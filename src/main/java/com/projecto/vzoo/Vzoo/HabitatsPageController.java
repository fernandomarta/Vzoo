package com.projecto.vzoo.Vzoo;

import java.io.InputStream;
import java.util.Base64;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import com.projecto.vzoo.Vzoo.entities.Habitat;
import com.projecto.vzoo.Vzoo.repositories.AnimalRepository;
import com.projecto.vzoo.Vzoo.repositories.HabitatRepository;

@Controller
public class HabitatsPageController {
	
    private HabitatRepository habitatRepository;
    private AnimalRepository animalRepository;
	
    @Autowired
    public HabitatsPageController(HabitatRepository habitatRepository, AnimalRepository animalRepository) {
        this.habitatRepository = habitatRepository;
        this.animalRepository = animalRepository;
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

    @GetMapping("/showConsultHabitat/{id}")
    public String showConsultAnimal(@PathVariable("id") long id, Model model) {
        Habitat habitat = habitatRepository.findById(id);
        model.addAttribute("habitat", habitat);
    	model.addAttribute("habitatAnimals", animalRepository.findByHabitat(habitat));
    	
    	return "habitat_consultar";
    }

    @GetMapping("/showAddHabitat")
    public String showAddHabitat(Habitat habitat) {
        return "habitat_criar_novo";
    }

    @PostMapping("/addHabitat")
    public String addHabitat(MultipartFile habitatImage, @Validated Habitat habitat, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "habitat_criar_novo";
        }

        if (habitatImage != null && !habitatImage.isEmpty()) {
        	try {
        		InputStream fis = habitatImage.getInputStream();
        		String encodedString = Base64.getEncoder().encodeToString(fis.readAllBytes());
        		habitat.setImage(encodedString);
        	} catch(Exception e) {
        		result.addError(new ObjectError("habitat", e.getMessage()));
        		return "habitat_criar_novo";
        	}
        }
        
        habitatRepository.save(habitat);
        model.addAttribute("habitats", habitatRepository.findAll());
        return "habitatspage";
    }

    @GetMapping("/showUpdateHabitat/{id}")
    public String showUpdateHabitat(@PathVariable("id") long id, Model model) {
    	Habitat habitat = habitatRepository.findById(id);
        model.addAttribute("habitat", habitat);
        return "habitat_alterar";
    }

    @PostMapping("/updateHabitat")
    public String updateHabitat(MultipartFile habitatImage, @Validated Habitat habitat, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "habitat_alterar";
        }

        if (habitatImage != null && !habitatImage.isEmpty()) {
        	try {
        		InputStream fis = habitatImage.getInputStream();
        		String encodedString = Base64.getEncoder().encodeToString(fis.readAllBytes());
        		habitat.setImage(encodedString);
        	} catch(Exception e) {
        		result.addError(new ObjectError("habitat", e.getMessage()));
        		return "habitat_alterar";
        	}
        } else {
        	Habitat habitatAtual = habitatRepository.findById(habitat.getId());
        	habitat.setImage(habitatAtual.getImage());
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
