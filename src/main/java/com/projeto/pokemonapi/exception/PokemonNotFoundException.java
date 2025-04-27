package com.projeto.pokemonapi.exception;

public class PokemonNotFoundException extends RuntimeException {
    public PokemonNotFoundException(Long id) {
        super("Pokémon não encontrado: " + id);
    }
}