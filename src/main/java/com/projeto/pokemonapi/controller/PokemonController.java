package com.projeto.pokemonapi.controller;

import com.projeto.pokemonapi.model.Pokemon;
import com.projeto.pokemonapi.service.PokemonService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pokemons")
public class PokemonController {

    private final PokemonService service;

    public PokemonController(PokemonService service) {
        this.service = service;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Pokemon criar(@Valid @RequestBody Pokemon p) {
        return service.criar(p);
    }

    @GetMapping
    public List<Pokemon> listar() {
        return service.listarTodos();
    }

    @GetMapping("/{id}")
    public Pokemon obter(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    @PutMapping("/{id}")
    public Pokemon atualizar(@PathVariable Long id,
                             @Valid @RequestBody Pokemon p) {
        return service.atualizar(id, p);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletar(@PathVariable Long id) {
        service.deletar(id);
    }
}
