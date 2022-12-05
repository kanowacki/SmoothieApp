package com.example.myOwn.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
public class Ingredient {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private Integer nutrition;
    private String amount;
}
