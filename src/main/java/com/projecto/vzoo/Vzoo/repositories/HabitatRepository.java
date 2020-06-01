package com.projecto.vzoo.Vzoo.repositories;

import org.springframework.data.repository.CrudRepository;

import com.projecto.vzoo.Vzoo.entities.Habitat;

public interface HabitatRepository extends CrudRepository<Habitat, Long> {
	 Habitat findById(long id);
}
