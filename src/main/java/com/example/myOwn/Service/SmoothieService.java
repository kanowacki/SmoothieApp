package com.example.myOwn.Service;

import com.example.myOwn.Entities.Base;
import com.example.myOwn.Entities.Ingredient;
import com.example.myOwn.Entities.Smoothie;
import com.example.myOwn.Repository.BaseRepository;
import com.example.myOwn.Repository.IngredientRepository;
import com.example.myOwn.Repository.SmoothieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SmoothieService {

    @Autowired
    private SmoothieRepository smoothieRepository;

    @Autowired
    private BaseRepository baseRepository;

    @Autowired
    private IngredientRepository ingredientRepository;

    public SmoothieService(SmoothieRepository smoothieRepository, BaseRepository baseRepository, IngredientRepository ingredientRepository) {
        this.smoothieRepository = smoothieRepository;
        this.baseRepository = baseRepository;
        this.ingredientRepository = ingredientRepository;
    }

    public Collection<Smoothie> findAllSmoothies() {
        return smoothieRepository.findAll().stream().collect(Collectors.toList());
    }

    public ResponseEntity<HttpStatus> deleteAllSmoothies(){
        try{
            smoothieRepository.deleteAll();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<Smoothie> findSmoothieById(Long id) {
        Optional<Smoothie> smoothieToBeFound = smoothieRepository.findById(id);

        return (smoothieToBeFound.isPresent()) ? new ResponseEntity<>(smoothieToBeFound.get(), HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    public ResponseEntity<HttpStatus> deleteSmoothieById(Long id) {
        try{
            smoothieRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    public Smoothie addSmoothie(Smoothie smoothie) {
        return (smoothie.getBase() == null || smoothie.getIngredients() == null || smoothie.getSize() == null || smoothie.getName() == null) ? null : smoothieRepository.save(smoothie);
    }

    public ResponseEntity<Smoothie> updateSmoothie(Long id, Smoothie smoothie) {
        Optional<Smoothie> smoothieToUpdate = smoothieRepository.findById(id);

        if (smoothieToUpdate.isPresent()) {
            Smoothie updatedSmoothie = smoothieToUpdate.get();
            updatedSmoothie.setName(smoothie.getName());
            updatedSmoothie.setSize(smoothie.getSize());
            updatedSmoothie.setBase(smoothie.getBase());
            updatedSmoothie.setIngredients(smoothie.getIngredients());
            return new ResponseEntity<>(smoothieRepository.save(updatedSmoothie), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    public Collection<Base> findAllBases() {
        return baseRepository.findAll().stream().collect(Collectors.toList());
    }

    public ResponseEntity<HttpStatus> deleteAllBases(){
        try{
            baseRepository.deleteAll();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<HttpStatus> deleteBaseById(Long id) {
        try{
            baseRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public Base findBaseById(Long id) {
        //null could be replaced by some exception here
        return (id == null) ? null : baseRepository.findById(id).get();
    }

    public Base addBase(Base base) {
        return (base.getAmount() == null || base.getName() == null || base.getNutrition() == null) ? null : baseRepository.save(base);
    }

    public Collection<Ingredient> findAllIngredients() {
        return ingredientRepository.findAll().stream().collect(Collectors.toList());
    }

    public ResponseEntity<HttpStatus> deleteAllIngredients(){
        try{
            ingredientRepository.deleteAll();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<HttpStatus> deleteIngredientById(Long id) {
        try{
            ingredientRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public Ingredient findIngredientById(Long id) {
        //null could be replaced by some exception here
        return (id == null) ? null : ingredientRepository.findById(id).get();
    }

    public Ingredient addIngredient(Ingredient ingredient) {
        return (ingredient.getAmount() == null || ingredient.getName() == null || ingredient.getNutrition() == null) ? null : ingredientRepository.save(ingredient);
    }
}
