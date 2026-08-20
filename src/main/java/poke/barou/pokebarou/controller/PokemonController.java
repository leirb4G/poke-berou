package poke.barou.pokebarou.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import poke.barou.pokebarou.entity.PokemonEntity;
import poke.barou.pokebarou.repository.PokemonRepository;
import poke.barou.pokebarou.service.PokemonService;

import java.util.List;

@RestController
@RequestMapping("/pokemon")
@CrossOrigin("*")


public class PokemonController {
    @Autowired
    private PokemonRepository comands;
    private PokemonService tools;

    @PostMapping
    public PokemonEntity savePokemon(@RequestBody PokemonEntity Pokemon){
        return comands.save(Pokemon);
    }

    @GetMapping
    public List<PokemonEntity> listPokemon(){
        return comands.findAll();
    }

    @PutMapping("/{id}")
    public PokemonEntity updatePokemon(@PathVariable Integer id, @RequestBody PokemonEntity alterPokemon){
        PokemonEntity actualPokemon = comands.findById(id).orElseThrow();

        actualPokemon.setPokemon_name(alterPokemon.getPokemon_name());

        return comands.save(actualPokemon);
    }

    @DeleteMapping("/{id}")
    public void deletePokemon(@PathVariable Integer id){
        comands.deleteById(id);
        return ;
    }
    @PostMapping("/sync-all")
    public ResponseEntity<String> syncAllPokemons() {
        // Dispara a Thread em background para o Insomnia/Postman não ficar aguardando o carregamento dos 1000+ Pokémons
        new Thread(() -> {
            try {
                tools.fetchAllAndSave();
            } catch (Exception e) {
                System.err.println("Erro no processo de sincronização: " + e.getMessage());
            }
        }).start();

        return ResponseEntity.ok("Sincronização iniciada em background! Olhe o terminal/console da sua IDE para ver o progresso.");
    }

}
