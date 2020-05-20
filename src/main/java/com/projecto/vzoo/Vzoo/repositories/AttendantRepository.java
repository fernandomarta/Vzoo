package com.projecto.vzoo.Vzoo.repositories;

import com.projecto.vzoo.Vzoo.entities.Attendant;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

// Create
// Read
// Update
// Delete

public interface AttendantRepository extends CrudRepository<Attendant, Long> {
    public List<Attendant> findByEmail(String email);
}
