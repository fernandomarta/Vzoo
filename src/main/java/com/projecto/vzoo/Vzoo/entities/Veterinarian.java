package com.projecto.vzoo.Vzoo.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;

@Entity
public class Veterinarian extends Employee {

    @ManyToMany
    private List<Specie> species = new ArrayList<>();

    public Veterinarian() {
    }

    public Veterinarian(String name, List<Specie> species) {
        this.setName(name);
        this.species = species;
    }

    public void setSpecies(List<Specie> species) {
        this.species = species;
    }

    public List<Specie> getSpecies() {
        return this.species;
    }

    @Override
    public String toString() {
        return "Attendant{" +
                "id=" + this.getId() +
                ", name='" + this.getName() + '\'' +
                ", species='" + this.species + '\'' +
                '}';
    }
}
