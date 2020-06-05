package com.projecto.vzoo.Vzoo.repositories;

import org.springframework.data.repository.CrudRepository;

import com.projecto.vzoo.Vzoo.entities.Veterinarian;

// Create
// Read
// Update
// Delete

public interface VeterinarianRepository extends CrudRepository<Veterinarian, Long> {
    public Veterinarian findById(long id);
}
