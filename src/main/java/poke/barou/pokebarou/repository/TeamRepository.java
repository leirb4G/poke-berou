package poke.barou.pokebarou.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import poke.barou.pokebarou.entity.TeamEntity;

public interface TeamRepository extends JpaRepository<TeamEntity, Integer> {
}
