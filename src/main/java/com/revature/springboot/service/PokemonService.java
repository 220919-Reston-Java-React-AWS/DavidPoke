package com.revature.springboot.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import com.revature.springboot.dao.PokemonBoxDao;
import com.revature.springboot.dao.PokemonDao;
import com.revature.springboot.model.Pokemon;
import com.revature.springboot.model.PokemonBox;

@Service
public class PokemonService {

    @Autowired
    private PokemonDao pokeDao;

    @Autowired
    private PokemonBoxDao pokeBoxDao;

    @Transactional(propagation = Propagation.REQUIRED) // will create a new transaction if there is none running
    public Pokemon AddPokemon(Pokemon poke) {
        PokemonBox pokeBox;

        Optional<PokemonBox> foundBox = pokeBoxDao.findById(poke.getPokemonBox().getBoxId());
        if (foundBox.isEmpty()) {
            pokeBox = pokeBoxDao.save(new PokemonBox());
        } else {
            pokeBox = foundBox.get();
        }
        poke.getPokemonBox().setBoxId(pokeBox.getBoxId());
        return pokeDao.save(poke);

    }

    public Pokemon GetPokemonById(int id) {
        Optional<Pokemon> foundPoke = pokeDao.findById(id);

        if (foundPoke.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Pokemon not found");
        } else {
            return foundPoke.get();
        }
    }

    public Pokemon UpdatePokemon(Pokemon poke) {
        GetPokemonById(poke.getId());
        return pokeDao.save(poke); // save() method will either add a new resource or update existing one
    }

    public void deletePokemon(int id) {
        Pokemon found = GetPokemonById(id);
        pokeDao.delete(found);
    }

}
