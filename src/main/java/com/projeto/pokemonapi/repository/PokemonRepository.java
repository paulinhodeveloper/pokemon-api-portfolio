package com.projeto.pokemonapi.repository;

import com.projeto.pokemonapi.model.Pokemon;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PokemonRepository extends JpaRepository<Pokemon, Long> {
}