package com.projecto.vzoo.Vzoo.models;

import java.util.List;

import com.projecto.vzoo.Vzoo.entities.Animal;
import com.projecto.vzoo.Vzoo.entities.Habitat;
import com.projecto.vzoo.Vzoo.entities.Specie;
import com.projecto.vzoo.Vzoo.repositories.AnimalRepository;

public class VZooSatisfactionCalculator {

	private AnimalRepository animalRepository;
	private List<Animal> animals;
	
	public VZooSatisfactionCalculator(AnimalRepository animalRepository) {
		this.animalRepository = animalRepository;
		this.animals = (List<Animal>) this.animalRepository.findAll();
	}
	
	public Integer getVZooSatisfaction() {
		int animalsQuantity = 0;
		int cumulativeAnimalSatisfaction = 0;
		Integer vzooSatisfaction = 0;
		
		for (Animal animal : this.animals) {
			Integer animalSatisfaction = this.getAnimalSatisfaction(animal);
			animalsQuantity++;
			cumulativeAnimalSatisfaction = cumulativeAnimalSatisfaction + animalSatisfaction.intValue();
		}
		
		if (animalsQuantity > 0) {
			vzooSatisfaction = cumulativeAnimalSatisfaction / animalsQuantity;
		}
		
		return vzooSatisfaction;
	}

	public Integer getAnimalSatisfaction(Animal animal) {
		Integer igual = this.getIgual(animal);
		Integer diferente = this.getDiferente(animal);
		Integer espaco = this.getEspaco(animal);
		
		Integer animalSatisfaction = 20 + igual + diferente + espaco;
		
		return animalSatisfaction;
	}

	private Integer getIgual(Animal animal) {
		int populacaoSpecie = this.getPopulacao(animal.getHabitat(), animal.getSpecie());
		Integer igual = 3 * (populacaoSpecie - 1);

		return igual;
	}
	
	private Integer getDiferente(Animal animal) {
		int populacaoHabitat = this.getPopulacao(animal.getHabitat(), null);
		int populacaoSpecie = this.getPopulacao(animal.getHabitat(), animal.getSpecie());
		Integer diferente = 2 * (populacaoHabitat - populacaoSpecie);

		return diferente;
	}

	private Integer getEspaco(Animal animal) {
		long area = animal.getHabitat().getArea().longValue();
		int populacaoHabitat = this.getPopulacao(animal.getHabitat(), null);
		Integer espaco = Math.round(area / populacaoHabitat);

		return espaco;
	}

	private int getPopulacao(Habitat habitatPop, Specie speciePop) {
		int counter = 0;
		Habitat habitat;
		Specie specie;
		
		if (habitatPop != null) {
			for (Animal animal : this.animals) {
				habitat = animal.getHabitat();
				specie = animal.getSpecie();
				
				if (habitatPop.getId() == habitat.getId()) {
					if (speciePop != null) {
						if (speciePop.getId() == specie.getId()) {
							counter++;
						}
					} else {
						counter++;
					}
				}
			}
		}
		
		return counter;
	}
	
}
