package com.example.myOwn.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Entity
@Getter
@Setter
public class Smoothie {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private Integer size;
//    private Base base;
//    private List<Ingredient> ingredients;

    public Smoothie(String name, Integer size) {
        this.name = name;
        this.size = size;
//        this.base = base;
//        this.ingredients = ingredients;
    }

    public Smoothie() {
    }

    @Override
    public String toString() {
        return "Smoothie{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", size=" + size +
//                ", base=" + base +
//                ", ingredients=" + ingredients +
                '}';
    }
}
