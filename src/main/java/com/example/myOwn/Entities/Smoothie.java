package com.example.myOwn.Entities;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
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
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String name;
    private Integer size;

    @ManyToOne
    private Base base;

    @ManyToMany
    @JoinTable(name = "smoothie_ingredient_table",
            joinColumns = {
                    @JoinColumn(name = "smoothie_id", referencedColumnName = "id")
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "ingredient_id", referencedColumnName = "id")
            }
    )
    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,
            property  = "id",
            scope     = Long.class)
//    @JsonManagedReference
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

    public void removeIngredientFromSmoothie(Ingredient ingredient){
        for(Ingredient i : ingredients){
            if(i.getId().equals(ingredient.getId())){
                ingredients.remove(i);
            }
        }
    }
}
