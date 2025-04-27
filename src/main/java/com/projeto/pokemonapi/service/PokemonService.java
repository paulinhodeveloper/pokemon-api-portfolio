package com.projeto.pokemonapi.service;

import com.projeto.pokemonapi.model.Pokemon;
import com.projeto.pokemonapi.repository.PokemonRepository;
import com.projeto.pokemonapi.exception.PokemonNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PokemonService {

    @Autowired
    private PokemonRepository pokemonRepository;

    public List<Pokemon> getAllPokemons() {
        return pokemonRepository.findAll();
    }

    public Pokemon getPokemonById(Long id) {
        return pokemonRepository.findById(id).orElseThrow(() -> new PokemonNotFoundException(id));
    }

    public Pokemon createPokemon(Pokemon pokemon) {
        return pokemonRepository.save(pokemon);
    }

    public Pokemon updatePokemon(Long id, Pokemon pokemonDetails) {
        Pokemon pokemon = getPokemonById(id);
        pokemon.setName(pokemonDetails.getName());
        pokemon.setType(pokemonDetails.getType());
        return pokemonRepository.save(pokemon);
    }

    public void deletePokemon(Long id) {
        Pokemon pokemon = getPokemonById(id);
        pokemonRepository.delete(pokemon);
    }
}