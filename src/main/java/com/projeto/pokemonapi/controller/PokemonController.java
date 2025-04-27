package com.projeto.pokemonapi.controller;

import com.projeto.pokemonapi.model.Pokemon;
import com.projeto.pokemonapi.service.PokemonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pokemons")
public class PokemonController {

    @Autowired
    private PokemonService pokemonService;

    @GetMapping
    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    public List<Pokemon> getAllPokemons() {
        return pokemonService.getAllPokemons();
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    public Pokemon getPokemonById(@PathVariable Long id) {
        return pokemonService.getPokemonById(id);
    }

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public Pokemon createPokemon(@RequestBody Pokemon pokemon) {
        return pokemonService.createPokemon(pokemon);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public Pokemon updatePokemon(@PathVariable Long id, @RequestBody Pokemon pokemon) {
        return pokemonService.updatePokemon(id, pokemon);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public void deletePokemon(@PathVariable Long id) {
        pokemonService.deletePokemon(id);
    }
}