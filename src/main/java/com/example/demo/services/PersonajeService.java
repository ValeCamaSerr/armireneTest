package com.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.PersonajeModel;
import com.example.demo.repositories.PersonajeRepository;

@Service
public class PersonajeService {
    @Autowired
    PersonajeRepository personajeRepository;

    public PersonajeModel guardarPersonaje(PersonajeModel personaje){
        return personajeRepository.save(personaje);
    }
}
