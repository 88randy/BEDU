package org.bedu.apipokemon.service;

import java.util.List;
import java.util.Optional;

import org.bedu.apipokemon.entity.Pokemon;

public interface IPokemonService {

    List<Pokemon> getAll();

    Optional<Pokemon> getOneByNumber(int number);

    Pokemon create(Pokemon data);
}