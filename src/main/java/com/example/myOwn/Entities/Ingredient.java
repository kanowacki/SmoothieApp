package com.example.myOwn.Entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
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
@AllArgsConstructor
@NoArgsConstructor
public class Ingredient {

    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE)
    private Long id;
    private String name;
    private Integer nutrition;
    private Integer amount;

    @ManyToMany(mappedBy = "ingredients")
//    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,
//            property  = "id",
//            scope     = Long.class)
    @JsonBackReference
    private Set<Smoothie> smoothies;

    @PreRemove
    private void removeIngredientFromSmoothies(){
        for (Smoothie s : smoothies){
            s.removeIngredientFromSmoothie(this);
        }
    }
}
