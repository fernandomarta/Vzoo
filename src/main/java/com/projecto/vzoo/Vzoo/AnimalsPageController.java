package com.projecto.vzoo.Vzoo;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.projecto.vzoo.Vzoo.entities.Animal;
import com.projecto.vzoo.Vzoo.entities.AnimalHabitatsHistory;
import com.projecto.vzoo.Vzoo.entities.Habitat;
import com.projecto.vzoo.Vzoo.repositories.AnimalHabitatsHistoryRepository;
import com.projecto.vzoo.Vzoo.repositories.AnimalRepository;
import com.projecto.vzoo.Vzoo.repositories.HabitatRepository;
import com.projecto.vzoo.Vzoo.repositories.SpecieRepository;

@Controller
public class AnimalsPageController {

    private AnimalRepository animalRepository;
    private SpecieRepository specieRepository;
    private HabitatRepository habitatRepository;
    private AnimalHabitatsHistoryRepository animalsHabitatsHistoryRepository;

    @Autowired
    public AnimalsPageController(AnimalRepository animalRepository, SpecieRepository specieRepository, HabitatRepository habitatRepository, AnimalHabitatsHistoryRepository animalsHabitatsHistoryRepository) {
        this.animalRepository = animalRepository;
        this.specieRepository = specieRepository;
        this.habitatRepository = habitatRepository;
        this.animalsHabitatsHistoryRepository = animalsHabitatsHistoryRepository;
    }

    @GetMapping("/animalspage")
    public String animals(Model model)
    {
    	model.addAttribute("animals", animalRepository.findAll());
        return "animalspage";
    }

    @PostMapping("/animalspage")
    public String goToAnimals(Model model)
    {
    	model.addAttribute("animals", animalRepository.findAll());
        return "animalspage";
    }

    @GetMapping("/showAddAnimal")
    public String showAddAnimal(Animal animal, Model model) {
    	model.addAttribute("species", specieRepository.findAll());
    	model.addAttribute("habitats", habitatRepository.findAll());
    	
        return "animal_criar_novo";
    }

    @PostMapping("/addAnimal")
    public String addAnimal(@Validated Animal animal, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "animal_criar_novo";
        }

        animalRepository.save(animal);
        model.addAttribute("animals", animalRepository.findAll());
        return "animalspage";
    }

    @GetMapping("/showTransferAnimal/{id}")
    public String showTransferForm(@PathVariable("id") long id, Model model) {
        Animal animal = animalRepository.findById(id);
        model.addAttribute("animal", animal);

    	model.addAttribute("species", specieRepository.findById(animal.getSpecie().getId()));
    	model.addAttribute("habitats", habitatRepository.findById(animal.getHabitat().getId()));
    	model.addAttribute("newhabitats", habitatRepository.findAll());
    	model.addAttribute("animalhabitatshistory", new AnimalHabitatsHistory());
    	
    	return "animal_transferir";
    }

    @PostMapping("/transferAnimal")
    public String transferAnimal(@Validated Animal animal, @Validated AnimalHabitatsHistory animalHabitatsHistory, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "animal_transferir";
        }

        Animal savedAnimal = animalRepository.findById(animal.getId());
        
        Habitat oldHabitat = new Habitat();
        oldHabitat.setId(savedAnimal.getHabitat().getId());
        oldHabitat.setName(savedAnimal.getHabitat().getName());
        oldHabitat.setArea(savedAnimal.getHabitat().getArea());

        Habitat newHabitat = new Habitat();
        newHabitat.setId(animalHabitatsHistory.getHabitat().getId());
        newHabitat.setName(animalHabitatsHistory.getHabitat().getName());
        newHabitat.setArea(animalHabitatsHistory.getHabitat().getArea());

        animalHabitatsHistory.setAnimal(savedAnimal);
        animalHabitatsHistory.setHabitat(oldHabitat);
        animalHabitatsHistory.setDate(new Date());
        animalsHabitatsHistoryRepository.save(animalHabitatsHistory);

        savedAnimal.setHabitat(newHabitat);
        animalRepository.save(savedAnimal);

        model.addAttribute("animals", animalRepository.findAll());
        return "animalspage";
    }

    @GetMapping("/showUpdateAnimal/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model) {
        Animal animal = animalRepository.findById(id);
        model.addAttribute("animal", animal);
        return "update-animal";
    }

    @PostMapping("/updateAnimal/{id}")
    public String updateAnimal(@PathVariable("id") long id, @Validated Animal animal, BindingResult result, Model model) {
        if (result.hasErrors()) {
            animal.setId(id);
            return "update-animal";
        }

        animalRepository.save(animal);
        model.addAttribute("animals", animalRepository.findAll());
        return "animalspage";
    }

    @GetMapping("/deleteAnimal/{id}")
    public String deleteAnimal(@PathVariable("id") long id, Model model) {
        Animal animal = animalRepository.findById(id);
        if (animal != null) {
            animalRepository.delete(animal);
        }
        model.addAttribute("animals", animalRepository.findAll());
        return "animalspage";
    }

}
