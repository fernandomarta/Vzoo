package com.projecto.vzoo.Vzoo.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.projecto.vzoo.Vzoo.entities.Veterinarian;

// Create
// Read
// Update
// Delete

public interface VeterinarianRepository extends CrudRepository<Veterinarian, Long> {
    public List<Veterinarian> findById(long id);
}
