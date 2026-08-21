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

    public PokemonController(PokemonRepository comands, PokemonService tools) {
    this.comands = comands;
    this.tools = tools;
}


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
        new Thread(() -> {
            try {
                tools.fetchAllAndSave();
            } catch (Exception e) {
                System.err.println("Error: " + e.getMessage());
            }
        }).start();

        return ResponseEntity.ok("Synchronization initialized in background!");
    }

}
