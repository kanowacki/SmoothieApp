package com.example.myOwn.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Smoothie {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String name;
    private Integer size;

    @ManyToOne
    private Base base;

    @ManyToMany(targetEntity=Ingredient.class)
    private Set<Ingredient> ingredients;

    public Smoothie(String name, Integer size, Base base, Set<Ingredient> ingredients) {
        this.name = name;
        this.size = size;
        this.base = base;
        this.ingredients = ingredients;
    }

    @Override
    public String toString() {
        return "Smoothie{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", size=" + size +
                ", base=" + base +
                ", ingredients=" + ingredients +
                '}';
    }
}
