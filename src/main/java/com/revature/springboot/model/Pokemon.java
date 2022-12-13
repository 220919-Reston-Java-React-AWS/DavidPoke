package com.revature.springboot.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;

@Entity(name = "Pokemon")
public @Data class Pokemon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private int level;
    private int health;
    private int damage;
    private int speed;

    @ManyToOne
    @JoinColumn(name = "boxId", nullable = false)
    private PokemonBox pokemonBox;

    public Pokemon() {
    }

    public Pokemon(String name, int level, int health, int damage, int speed) {
        this.name = name;
        this.level = level;
        this.health = health;
        this.damage = damage;
        this.speed = speed;
    }

}
