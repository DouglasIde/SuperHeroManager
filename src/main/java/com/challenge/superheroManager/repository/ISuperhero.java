package com.challenge.superheroManager.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.challenge.superheroManager.model.Superhero;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ISuperhero extends JpaRepository<Superhero, Long> {
    public List<Superhero> findAllByNameContainingIgnoreCase(@Param("name")String name);
}
