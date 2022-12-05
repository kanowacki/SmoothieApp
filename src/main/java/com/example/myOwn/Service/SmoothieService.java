package com.example.myOwn.Service;

import com.example.myOwn.Entities.Smoothie;
import com.example.myOwn.Repository.SmoothieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.stream.Collectors;

@Service
public class SmoothieService {

    @Autowired
    private SmoothieRepository repository;


    public Collection<Smoothie> findAll() {
        return repository.findAll().stream().collect(Collectors.toList());
    }

    public Smoothie findSmoothieById(Long id){
        //null could be replaced by some exception here
        return (id==null) ? null : repository.findById(id).get();
    }

    public Smoothie addSmoothie(Smoothie smoothie){
        return (smoothie.getSize() == null || smoothie.getName() == null) ? null : repository.save(smoothie);
    }
}
