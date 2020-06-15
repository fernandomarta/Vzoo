package com.projecto.vzoo.Vzoo.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
public class Animal {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotBlank
    private String name;

    @OneToOne
    private Specie specie;
    
    private String sound;
    
    @Size(max = 10000000)
    private String image;
    
    @OneToOne
    private Habitat habitat;
    
    public Animal() {
    }

    public Animal(String name, Specie specie, String sound, Habitat habitat) {
        this.name = name;
        this.specie = specie;
        this.sound = sound;
        this.habitat = habitat;
    }

    public void setId(long id) {
    	this.id = id;
    }

    public long getId() {
        return this.id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setSpecie(Specie specie) {
        this.specie = specie;
    }

    public Specie getSpecie() {
        return specie;
    }

    public void setSound(String sound) {
        this.sound = sound;
    }

    public String getSound() {
        return this.sound;
    }

    public void setHabitat(Habitat habitat) {
        this.habitat = habitat;
    }

    public Habitat getHabitat() {
        return habitat;
    }
    
    public String getImage() {
		return image;
	}

	public void setImage(String picture) {
		this.image = picture;
	}

    @Override
    public String toString() {
        return String.format(
                "Animal[id=%d, name='%s', specie='%s', sound='%s', habitat='%s']",
                id, name, specie, sound, habitat);
    }
}
