package com.projecto.vzoo.Vzoo;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.projecto.vzoo.Vzoo.entities.Animal;
import com.projecto.vzoo.Vzoo.entities.Attendant;
import com.projecto.vzoo.Vzoo.entities.Habitat;
import com.projecto.vzoo.Vzoo.entities.Veterinarian;
import com.projecto.vzoo.Vzoo.models.VZooSatisfactionCalculator;
import com.projecto.vzoo.Vzoo.models.VZooState;
import com.projecto.vzoo.Vzoo.repositories.AnimalRepository;
import com.projecto.vzoo.Vzoo.repositories.AttendantRepository;
import com.projecto.vzoo.Vzoo.repositories.HabitatRepository;
import com.projecto.vzoo.Vzoo.repositories.VeterinarianRepository;

@Controller
public class MainPageController {
	
	HabitatRepository habitatRepository;
	AnimalRepository animalRepository;
	AttendantRepository attendantRepository;
	VeterinarianRepository veterinarianRepository;
	
	@Autowired
    public MainPageController(HabitatRepository habitatRepository, AnimalRepository animalRepository, AttendantRepository attendantRepository, VeterinarianRepository veterinarianRepository) {
        this.habitatRepository = habitatRepository;
        this.animalRepository = animalRepository;
        this.attendantRepository = attendantRepository;
        this.veterinarianRepository = veterinarianRepository;
    }
	
    @GetMapping("/mainpage")
    public String mainPage(Model model) {
    	VZooSatisfactionCalculator vzooSatisfactionCalculator = new VZooSatisfactionCalculator(this.animalRepository);
    	
    	VZooState vZooState = new VZooState();
    	
    	vZooState.setHabitatsQuantity(((ArrayList<Habitat>) habitatRepository.findAll()).size());
    	vZooState.setAnimalsQuantity(((ArrayList<Animal>) animalRepository.findAll()).size());
    	vZooState.setEmployeesQuantity(((ArrayList<Attendant>) attendantRepository.findAll()).size() + ((ArrayList<Veterinarian>) veterinarianRepository.findAll()).size());
    	vZooState.setVzooSatisfaction(vzooSatisfactionCalculator.getVZooSatsfaction());
    	
    	model.addAttribute("vzoostate", vZooState);
    	
        return "mainpage";
    }

    @PostMapping("/mainpage") 
    public String goToMainPage(Model model) {
    	VZooState vZooState = new VZooState();
    	model.addAttribute("vzoostate", vZooState);

    	return "mainpage";
    }

}
