package com.example.myOwn.Controller;

import com.example.myOwn.Entities.Base;
import com.example.myOwn.Entities.Ingredient;
import com.example.myOwn.Entities.Smoothie;
import com.example.myOwn.Service.SmoothieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
public class SmoothieController {

    @Autowired
    private SmoothieService service;


    @RequestMapping("/smoothies")
    public Collection<Smoothie> allSmoothies(){
        return service.findAllSmoothies();
    }

    @GetMapping("/smoothie/{id}")
    public ResponseEntity<Smoothie> findSmoothieById(@PathVariable Long id){
        return new ResponseEntity<>(service.findSmoothieById(id), HttpStatus.OK);
    }

    @PostMapping("/smoothie")
    public Smoothie addSmoothie(@RequestBody Smoothie smoothie){
        return service.addSmoothie(smoothie);
    }

    @RequestMapping("/bases")
    public Collection<Base> allBases(){
        return service.findAllBases();
    }

    @GetMapping("/base/{id}")
    public ResponseEntity<Base> findBaseById(@PathVariable Long id){
        return new ResponseEntity<>(service.findBaseById(id), HttpStatus.OK);
    }

    @PostMapping("/base")
    public Base addBase(@RequestBody Base base){
        return service.addBase(base);
    }

    @RequestMapping("/ingredients")
    public Collection<Ingredient> allIngredients(){
        return service.findAllIngredients();
    }

    @GetMapping("/ingredient/{id}")
    public ResponseEntity<Ingredient> findIngredientById(@PathVariable Long id){
        return new ResponseEntity<>(service.findIngredientById(id), HttpStatus.OK);
    }

    @PostMapping("/ingredient")
    public Ingredient addBase(@RequestBody Ingredient ingredient){
        return service.addIngredient(ingredient);
    }
}
