package com.pokedex.ReactivePokedex.controller;

import com.pokedex.ReactivePokedex.document.Pokedex;
import com.pokedex.ReactivePokedex.services.PokedexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class PokedexController {

    @Autowired
    PokedexService service;

    @GetMapping(value = "/pokedex")
    public Flux<Pokedex> listarPokedex() {
        return service.findAll();
    }

    @GetMapping(value = "pokedex/{id}")
    public Mono<Pokedex> listarIdPokedex(@PathVariable String id) {
        return service.findById(id);
    }

    @PostMapping
    public Mono<Pokedex> inserirPokedex(@RequestBody Pokedex pokedex) {
        return service.save(pokedex);
    }

}
