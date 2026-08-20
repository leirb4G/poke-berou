package poke.barou.pokebarou.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import poke.barou.pokebarou.entity.MoveEntity;
import poke.barou.pokebarou.repository.MoveRepository;

import java.util.List;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@RestController
@RequestMapping("/move")
@CrossOrigin("*")

public class MoveController {
    @Autowired
    private MoveRepository comands;
    @PostMapping
    public MoveEntity saveMove(@RequestBody MoveEntity move){
        return comands.save(move);
    }

    @GetMapping
    public List<MoveEntity> listMove(){
        return comands.findAll();
    }

    @PutMapping("/{id}")
    public MoveEntity updateMove(@PathVariable Integer id, @RequestBody MoveEntity alterMove){
        MoveEntity actualMove = comands.findById(id).orElseThrow();

        actualMove.setMove_name(alterMove.getMove_name());

        return comands.save(actualMove);
    }

    @DeleteMapping("/{id}")
    public void deleteMove(@PathVariable Integer id){
        comands.deleteById(id);
        return ;
    }



}
