package com.projeto.pokemonapi.service;

import com.projeto.pokemonapi.exception.PokemonNotFoundException;
import com.projeto.pokemonapi.model.Pokemon;
import com.projeto.pokemonapi.repository.PokemonRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PokemonService {

    private final PokemonRepository repo;

    public PokemonService(PokemonRepository repo) {
        this.repo = repo;
    }

    public Pokemon criar(Pokemon p) {
        return repo.save(p);
    }

    public List<Pokemon> listarTodos() {
        return repo.findAll();
    }

    public Pokemon buscarPorId(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new PokemonNotFoundException(id));
    }

    public Pokemon atualizar(Long id, Pokemon dados) {
        Pokemon existente = buscarPorId(id);
        existente.setNome(dados.getNome());
        existente.setTipo(dados.getTipo());
        return repo.save(existente);
    }

    public void deletar(Long id) {
        if (!repo.existsById(id)) {
            throw new PokemonNotFoundException(id);
        }
        repo.deleteById(id);
    }
}
