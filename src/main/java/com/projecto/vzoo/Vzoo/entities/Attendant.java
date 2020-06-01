package com.projecto.vzoo.Vzoo.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class Attendant extends Employee {

    @OneToMany
	private List<Habitat> habitats = new ArrayList<>();

    public Attendant() {
    }

    public Attendant(String name, List<Habitat> habitats) {
        this.setName(name);
        this.habitats = habitats;
    }

    public void setHabitats(List<Habitat> habitats) {
        this.habitats = habitats;
    }

    public List<Habitat> getHabitats() {
        return this.habitats;
    }

    @Override
    public String toString() {
        return "Attendant{" +
                "id=" + this.getId() +
                ", name='" + this.getName() + '\'' +
                ", habitats='" + this.habitats + '\'' +
                '}';
    }
}
