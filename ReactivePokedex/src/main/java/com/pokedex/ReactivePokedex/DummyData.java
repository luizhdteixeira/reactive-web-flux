package com.pokedex.ReactivePokedex;

import com.pokedex.ReactivePokedex.document.Pokedex;
import com.pokedex.ReactivePokedex.repository.PokedexRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

import java.util.UUID;

@Component
public class DummyData implements CommandLineRunner {

    private final PokedexRepository pokedexRepository;

    DummyData(PokedexRepository pokedexRepository) {
        this.pokedexRepository = pokedexRepository;
    }

    @Override
    public void run(String...args) throws Exception {

        pokedexRepository.deleteAll()
                .thenMany(
                        Flux.just("Bulbasaur", "Venusaur", "Charmander", "Charmeleon", "Squirtle", "Wartortle", "Blastoise", "Metapod")
                            .map(nome -> new Pokedex (UUID.randomUUID().toString(), nome))
                                .flatMap(pokedexRepository::save))
                .subscribe(System.out::println);
    }

}
