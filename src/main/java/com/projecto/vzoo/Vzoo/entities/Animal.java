package com.projecto.vzoo.Vzoo.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Animal {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;

    private String name;
    private String species;

    protected Animal() {}

    public Animal(String name, String species) {
        this.name = name;
        this.species = species;
    }

    @Override
    public String toString() {
        return String.format(
                "Animal[id=%d, name='%s', species='%s']",
                id, name, species);
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSpecies() {
        return species;
    }

    public void setId(long id) { this.id = id; }
}
