package com.projecto.vzoo.Vzoo.repositories;

import com.projecto.vzoo.Vzoo.entities.Animal;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AnimalRepository extends CrudRepository<Animal, Long> {
    List<Animal> findBySpecies(String species);
    Animal findById(long id);
}
