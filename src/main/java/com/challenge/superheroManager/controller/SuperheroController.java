package com.challenge.superheroManager.controller;

import com.challenge.superheroManager.model.Superhero;
import com.challenge.superheroManager.repository.ISuperhero;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/superhero")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class SuperheroController {

    @Autowired
    private ISuperhero superheroRepository;

    @GetMapping
    public ResponseEntity<List<Superhero>> getAll() {
        return ResponseEntity.ok(superheroRepository.findAll());
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<List<Superhero>> getByName(@PathVariable String name) {
        return ResponseEntity.ok(superheroRepository.findAllByNameContainingIgnoreCase(name));
    }
}
