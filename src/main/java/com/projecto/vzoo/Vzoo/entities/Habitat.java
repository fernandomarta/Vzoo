package com.projecto.vzoo.Vzoo.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Habitat {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Override
    public String toString() {
        return "Animal{" +
                "id=" + id +
                ", area=" + area +
                ", name='" + name + '\'' +
                '}';
    }

    public Habitat(long area, String name) {
        this.area = area;
        this.name = name;
    }

    private long area;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getArea() {
        return area;
    }

    public void setArea(long area) {
        this.area = area;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;
}