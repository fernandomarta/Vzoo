package com.projecto.vzoo.Vzoo.repositories;

import org.springframework.data.repository.CrudRepository;

import com.projecto.vzoo.Vzoo.entities.Attendant;

// Create
// Read
// Update
// Delete

public interface AttendantRepository extends CrudRepository<Attendant, Long> {
    public Attendant findById(long id);
}
