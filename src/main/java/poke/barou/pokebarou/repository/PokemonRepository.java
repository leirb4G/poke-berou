package poke.barou.pokebarou.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import poke.barou.pokebarou.entity.PokemonEntity;

public interface PokemonRepository extends JpaRepository<PokemonEntity, Integer> {
}
