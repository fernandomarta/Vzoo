package com.projecto.vzoo.Vzoo.repositories;

import org.springframework.data.repository.CrudRepository;

import com.projecto.vzoo.Vzoo.entities.Specie;

public interface SpecieRepository extends CrudRepository<Specie, Long> {
	 Specie findById(long id);
}
