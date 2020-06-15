package com.projecto.vzoo.Vzoo.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.projecto.vzoo.Vzoo.entities.Animal;
import com.projecto.vzoo.Vzoo.entities.Habitat;
import com.projecto.vzoo.Vzoo.entities.Specie;

public interface AnimalRepository extends CrudRepository<Animal, Long> {
    List<Animal> findBySpecie(Specie specie);
    List<Animal> findByHabitat(Habitat habitat);
    Animal findById(long id);
}
