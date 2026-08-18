package poke.barou.pokebarou.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import poke.barou.pokebarou.entity.MoveEntity;

public interface MoveRepository extends JpaRepository<MoveEntity, Integer> {
}
