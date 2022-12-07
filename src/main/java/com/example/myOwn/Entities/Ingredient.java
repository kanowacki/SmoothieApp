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
@AllArgsConstructor
@NoArgsConstructor
public class Ingredient {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String name;
    private Integer nutrition;
    private String amount;

    @ManyToMany(mappedBy = "ingredients", fetch = FetchType.LAZY)
    private Set<Smoothie> smoothies;
}
