package com.revature.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.revature.springboot.model.Pokemon;
import com.revature.springboot.service.PokemonService;

@RestController
@RequestMapping("/pokemon")
public class PokemonController {

    @Autowired
    PokemonService pokeServ;

    // @PostMapping(value = "/add")
    @RequestMapping(method = RequestMethod.POST, value = "/add", consumes = "application/json")
    public Pokemon AddPokemon(@RequestBody Pokemon p) {
        return pokeServ.AddPokemon(p);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{pokeId}")
    public Pokemon GetPokeById(@PathVariable("pokeId") int pokeId) {
        return pokeServ.GetPokemonById(pokeId);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/update")
    public Pokemon UpdatePokemon(@RequestBody Pokemon poke) {
        return pokeServ.UpdatePokemon(poke);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/{pokeId}")
    public void DeletePokemon(@PathVariable("pokeId") int id) {
        pokeServ.deletePokemon(id);
    }
}
