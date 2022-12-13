package com.revature.springboot.dao;

import org.springframework.stereotype.Repository;

import com.revature.springboot.model.PokemonBox;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface PokemonBoxDao extends JpaRepository<PokemonBox, Integer> {

}
