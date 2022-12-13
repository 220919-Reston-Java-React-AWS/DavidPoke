package com.revature.springboot.dao;

import org.springframework.stereotype.Repository;

import com.revature.springboot.model.Pokemon;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface PokemonDao extends JpaRepository<Pokemon, Integer> { // <Model, primarykey datatype>
    /*
     * -This will have all the capabilities of a CRUD operation
     * -.save(), .delete(), .find...() to name a few
     */
}
