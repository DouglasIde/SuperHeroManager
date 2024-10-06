package com.challenge.superheroManager.controller;

import com.challenge.superheroManager.model.Superhero;
import com.challenge.superheroManager.repository.ISuperhero;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

    @GetMapping("/{id}")
    public ResponseEntity<Superhero> getById(@PathVariable Long id) {
        return superheroRepository.findById(id)
                .map(response -> ResponseEntity.ok(response))
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<List<Superhero>> getByName(@PathVariable String name) {
        return ResponseEntity.ok(superheroRepository.findAllByNameContainingIgnoreCase(name));
    }
}
