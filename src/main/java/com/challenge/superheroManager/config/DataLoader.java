package com.challenge.superheroManager.config;

import com.challenge.superheroManager.model.Superhero;
import com.challenge.superheroManager.repository.ISuperhero;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import org.springframework.core.io.ClassPathResource;

import java.io.InputStream;
import java.util.List;

@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    private ISuperhero superheroRepository;

    @Override
    public void run(String... args) throws Exception {
        if (superheroRepository.count() == 0) {
            ObjectMapper mapper = new ObjectMapper();
            TypeReference<List<Superhero>> typeReference = new TypeReference<List<Superhero>>() {};
            InputStream inputStream = new ClassPathResource("superheros.json").getInputStream();
            List<Superhero> superhero = mapper.readValue(inputStream, typeReference);
            superheroRepository.saveAll(superhero);
        }
    }
}
