package com.challenge.superheroManager.exception;

public class SuperheroNotFoundException extends RuntimeException {
    public SuperheroNotFoundException(Long id) {
        super("The superhero doesn't exist: " + id);
    }
}
