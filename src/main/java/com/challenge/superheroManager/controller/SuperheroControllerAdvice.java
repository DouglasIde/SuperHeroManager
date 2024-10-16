package com.challenge.superheroManager.controller;

import com.challenge.superheroManager.exception.SuperheroNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;


import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class SuperheroControllerAdvice extends ResponseEntityExceptionHandler {

    @ExceptionHandler(SuperheroNotFoundException.class)
    public ResponseEntity<Object> errorNotFound() {
        Map<String, Object> body = new HashMap<>();

        body.put("message", "Superhero not found");

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(body);
    }

}
