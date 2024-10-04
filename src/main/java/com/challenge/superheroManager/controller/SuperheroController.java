package com.challenge.superheroManager.controller;

import com.challenge.superheroManager.repository.ISuperhero;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/superhero")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class SuperheroController {

    @Autowired
    private ISuperhero superheroRepository;
}
