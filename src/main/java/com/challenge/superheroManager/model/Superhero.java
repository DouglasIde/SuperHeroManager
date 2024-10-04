package com.challenge.superheroManager.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "tb_superhero")
public class Superhero {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O atributo de Nome é obrigatório!")
    private String name;

    private String lastName;

    @NotNull
    private int age;

    private String team;

    @NotBlank(message = "O atributo de País é obrigatório!")
    @Size(min = 3, max = 10, message = "O atributo de País deve ter 3 caracteres!")
    private String country;

    @NotBlank(message = "O atributo de Poder é obrigatório! Se não tiver, digite 'Sem poder'")
    private String power;

    private String power2;

}
