package poke.barou.pokebarou.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import poke.barou.pokebarou.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Integer> {
}
