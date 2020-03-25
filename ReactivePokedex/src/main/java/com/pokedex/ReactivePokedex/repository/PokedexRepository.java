package com.pokedex.ReactivePokedex.repository;

import com.pokedex.ReactivePokedex.document.Pokedex;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface PokedexRepository extends ReactiveMongoRepository <Pokedex, String> {

}
