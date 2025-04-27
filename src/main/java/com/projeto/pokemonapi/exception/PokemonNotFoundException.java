package com.projeto.pokemonapi.exception;

public class PokemonNotFoundException extends RuntimeException {
    public PokemonNotFoundException(Long id) {
        super("Pokemon not found with ID: " + id);
    }
}