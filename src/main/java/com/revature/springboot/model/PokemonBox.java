package com.revature.springboot.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;

@Entity
public @Data class PokemonBox {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int boxId;

    private String environment;

    @OneToMany(mappedBy = "pokemonBox")
    private List<Pokemon> pokemons;

    public PokemonBox() {
        this.environment = "Normal";
    }
}
