package com.challenge.superheroManager.controller;

import com.challenge.superheroManager.model.Superhero;
import com.challenge.superheroManager.repository.ISuperhero;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

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

    @GetMapping("/superpower/{power}")
    public ResponseEntity<List<Superhero>> getByPower(@PathVariable String power, String power2) {
        return ResponseEntity.ok(superheroRepository.findAllByPowerContainingIgnoreCaseOrPower2ContainingIgnoreCase(
                power, power2
        ));
    }



    @PostMapping
    public ResponseEntity<Superhero> post(@Valid @RequestBody Superhero superhero) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(superheroRepository.save(superhero));
    }

    @PutMapping
    public ResponseEntity<Superhero> put(@Valid @RequestBody Superhero superhero){
        return superheroRepository.findById(superhero.getId())
                .map(response -> ResponseEntity.status(HttpStatus.OK)
                        .body(superheroRepository.save(superhero)))
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        Optional<Superhero> superhero = superheroRepository.findById(id);
        if(superhero.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        } else {
            superheroRepository.deleteById(id);
        }
    }
}
