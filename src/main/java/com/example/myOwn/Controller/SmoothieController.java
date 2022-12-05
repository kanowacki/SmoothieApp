package com.example.myOwn.Controller;

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
        return service.findAll();
    }

    @GetMapping("/smoothie/{id}")
    public ResponseEntity<?> findSmoothieById(@PathVariable Long id){
        return new ResponseEntity<>(service.findSmoothieById(id), HttpStatus.OK);
    }

    @PostMapping("/smoothie")
    public Smoothie addSmoothie(@RequestBody Smoothie smoothie){
        return service.addSmoothie(smoothie);
    }
}
