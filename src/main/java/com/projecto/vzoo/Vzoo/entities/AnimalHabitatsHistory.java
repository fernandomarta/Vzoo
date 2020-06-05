package com.projecto.vzoo.Vzoo.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class AnimalHabitatsHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @OneToOne
    private Animal animal;
    @OneToOne
    private Habitat oldHabitat;

    private Date dateTime;
    
    public AnimalHabitatsHistory() {
    }
    
    public AnimalHabitatsHistory(Animal animal, Habitat habitat, Date dateTime) {
        this.animal = animal;
        this.oldHabitat = habitat;
        this.dateTime = dateTime;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }

    public Animal getAnimal() {
        return animal;
    }

    public void setOldHabitat(Habitat habitat) {
        this.oldHabitat = habitat;
    }

    public Habitat getOldHabitat() {
        return oldHabitat;
    }
    
    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }

    public Date getDateTime() {
        return dateTime;
    }

    @Override
    public String toString() {
        return "AnimalHabitatsHistory{" +
                "id=" + id +
                ", animal=" + this.animal +
                ", habitat=" + this.oldHabitat + 
                ", dateTime="+ this.dateTime + 
                '}';
    }
}