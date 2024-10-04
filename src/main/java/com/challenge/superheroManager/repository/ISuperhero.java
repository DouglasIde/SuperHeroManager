package com.challenge.superheroManager.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.challenge.superheroManager.model.Superhero;

public interface ISuperhero extends JpaRepository<Superhero, Long> {

}
