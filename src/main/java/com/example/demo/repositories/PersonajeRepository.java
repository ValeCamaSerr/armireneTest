package com.example.demo.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.PersonajeModel;

@Repository
public interface PersonajeRepository extends CrudRepository<PersonajeModel, Long> {
    
}
