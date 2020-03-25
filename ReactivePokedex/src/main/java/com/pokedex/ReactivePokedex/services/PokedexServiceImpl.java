package com.pokedex.ReactivePokedex.services;

import com.pokedex.ReactivePokedex.document.Pokedex;
import com.pokedex.ReactivePokedex.repository.PokedexRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class PokedexServiceImpl implements PokedexService{

    @Autowired
    PokedexRepository pokedexRepository;


    @Override
    public Flux<Pokedex> findAll() {
        return pokedexRepository.findAll();
    }

    @Override
    public Mono<Pokedex> findById(String id) {
        return pokedexRepository.findById(id);
    }

    @Override
    public Mono<Pokedex> save(Pokedex pokedex) {
        return pokedexRepository.save(pokedex);
    }

}
