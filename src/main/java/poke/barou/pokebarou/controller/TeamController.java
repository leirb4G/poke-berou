package poke.barou.pokebarou.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import poke.barou.pokebarou.entity.TeamEntity;
import poke.barou.pokebarou.repository.TeamRepository;

import java.util.List;

@RestController
@RequestMapping("/team")
@CrossOrigin("*")

public class TeamController {
    @Autowired
    private TeamRepository comands;
    @PostMapping
    public TeamEntity saveTeam(@RequestBody TeamEntity Team){
        return comands.save(Team);
    }

    @GetMapping
    public List<TeamEntity> listTeam(){
        return comands.findAll();
    }

    @PutMapping("/{id}")
    public TeamEntity updateTeam(@PathVariable Integer id, @RequestBody TeamEntity alterTeam){
        TeamEntity actualTeam = comands.findById(id).orElseThrow();

        actualTeam.setTeam_name(alterTeam.getTeam_name());

        return comands.save(actualTeam);
    }

    @DeleteMapping("/{id}")
    public void deleteTeam(@PathVariable Integer id){
        comands.deleteById(id);
        return ;
    }

}
