package com.example.myOwn.Repository;

import com.example.myOwn.Entities.Smoothie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface SmoothieRepository extends JpaRepository<Smoothie, Long> {

}
