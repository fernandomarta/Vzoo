package com.projecto.vzoo.Vzoo.models;

import java.util.List;

import com.projecto.vzoo.Vzoo.entities.Animal;
import com.projecto.vzoo.Vzoo.repositories.AnimalRepository;

public class VZooSatisfactionCalculator {

	AnimalRepository animalRepository;
	
	public VZooSatisfactionCalculator(AnimalRepository animalRepository) {
		this.animalRepository = animalRepository;
	}
	
	public Integer getVZooSatsfaction() {
		List<Animal> animals = (List<Animal>) this.animalRepository.findAll();
		
		int animalsQuantity = 0;
		int cumulativeAnimalSatisfaction = 0;

		for (Animal animal : animals) {
			Integer animalSatisfaction = this.getAnimalSatsfaction(animal);
			animalsQuantity++;
			cumulativeAnimalSatisfaction = cumulativeAnimalSatisfaction + animalSatisfaction.intValue();
		}
		
		Integer vzooSatisfaction = cumulativeAnimalSatisfaction / animalsQuantity;
		
		return vzooSatisfaction;
	}

	private Integer getAnimalSatsfaction(Animal animal) {
		Integer igual = this.getIgual(animal);
		Integer diferente = this.getDiferente(animal);
		Integer espaco = this.getEspaco(animal);
		
		Integer animalSatisfaction = 20 + igual + diferente + espaco;
		
		return animalSatisfaction;
	}

	private Integer getIgual(Animal animal) {
		return 10;
	}
	
	private Integer getDiferente(Animal animal) {
		return 0;
	}

	private Integer getEspaco(Animal animal) {
		return 0;
	}
}
