package com.projecto.vzoo.Vzoo.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Habitat {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotBlank
    private String name;

    @NotNull
    @DecimalMin("1.00")
    private Long area;

    @Size(max = 10000000)
    private String image;

    public Habitat() {
    }
    
    public Habitat(Long area, String name) {
        this.area = area;
        this.name = name;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setArea(Long area) {
        this.area = area;
    }

    public Long getArea() {
        return area;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

	public String getImage() {
		return image;
	}

	public void setImage(String picture) {
		this.image = picture;
	}

    @Override
    public String toString() {
        return "Habitat{" +
                "id=" + id +
                ", area=" + area +
                ", name='" + name + '\'' +
                '}';
    }
}