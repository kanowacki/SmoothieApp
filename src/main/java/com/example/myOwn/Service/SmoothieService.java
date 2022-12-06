package com.example.myOwn.Service;

import com.example.myOwn.Entities.Base;
import com.example.myOwn.Entities.Ingredient;
import com.example.myOwn.Entities.Smoothie;
import com.example.myOwn.Repository.BaseRepository;
import com.example.myOwn.Repository.IngredientRepository;
import com.example.myOwn.Repository.SmoothieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.stream.Collectors;

@Service
public class SmoothieService {

    @Autowired
    private SmoothieRepository smoothieRepository;

    @Autowired
    private BaseRepository baseRepository;

    @Autowired
    private IngredientRepository ingredientRepository;

    public Collection<Smoothie> findAllSmoothies() {
        return smoothieRepository.findAll().stream().collect(Collectors.toList());
    }

    public Smoothie findSmoothieById(Long id){
        //null could be replaced by some exception here
        return (id==null) ? null : smoothieRepository.findById(id).get();
    }

    public Smoothie addSmoothie(Smoothie smoothie){
        return (smoothie.getBase() == null || smoothie.getIngredients() == null || smoothie.getSize() == null || smoothie.getName() == null) ? null : smoothieRepository.save(smoothie);
    }

    public Collection<Base> findAllBases() {
        return baseRepository.findAll().stream().collect(Collectors.toList());
    }

    public Base findBaseById(Long id){
        //null could be replaced by some exception here
        return (id==null) ? null : baseRepository.findById(id).get();
    }

    public Base addBase(Base base){
        return (base.getAmount() == null || base.getName() == null || base.getNutrition() == null) ? null : baseRepository.save(base);
    }

    public Collection<Ingredient> findAllIngredients() {
        return ingredientRepository.findAll().stream().collect(Collectors.toList());
    }

    public Ingredient findIngredientById(Long id){
        //null could be replaced by some exception here
        return (id==null) ? null : ingredientRepository.findById(id).get();
    }

    public Ingredient addIngredient(Ingredient ingredient){
        return (ingredient.getAmount() == null || ingredient.getName() == null || ingredient.getNutrition() == null) ? null : ingredientRepository.save(ingredient);
    }
}
