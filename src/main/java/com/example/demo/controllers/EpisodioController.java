package com.example.demo.controllers;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import com.example.demo.models.ResponseModel;
import com.example.demo.services.EpisodioService;

@RestController
@RequestMapping("/episodio")
public class EpisodioController  {
    @Autowired
    EpisodioService episodioService;

    @GetMapping(path = "/{numEpisodio}")
    public ResponseModel obtenerEpisodio(@PathVariable("numEpisodio") Long numEpisodio){
        return episodioService.obtenerEpisodio(numEpisodio);
    }

}
