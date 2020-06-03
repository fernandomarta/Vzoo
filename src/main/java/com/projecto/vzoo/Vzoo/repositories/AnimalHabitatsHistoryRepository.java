package com.projecto.vzoo.Vzoo.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.projecto.vzoo.Vzoo.entities.Animal;
import com.projecto.vzoo.Vzoo.entities.AnimalHabitatsHistory;

public interface AnimalHabitatsHistoryRepository extends CrudRepository<AnimalHabitatsHistory, Long> {
	List<AnimalHabitatsHistory> findByAnimal(Animal animal);
}
