package poke.barou.pokebarou.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class TeamEntity {
    @Id
    private int id_team;
    private String team_name;
    private int pokemon1;
    private int pokemon2;
    private int pokemon3;
    private int pokemon4;
    private int pokemon5;
    private int pokemon6;


    public String getTeam_name() {
        return team_name;
    }

    public void setTeam_name(String team_name) {
        this.team_name = team_name;
    }

    public int getId_team() {
        return id_team;
    }

    public void setId_team(int id_team) {
        this.id_team = id_team;
    }

    public int getPokemon1() {
        return pokemon1;
    }

    public void setPokemon1(int pokemon1) {
        this.pokemon1 = pokemon1;
    }

    public int getPokemon2() {
        return pokemon2;
    }

    public void setPokemon2(int pokemon2) {
        this.pokemon2 = pokemon2;
    }

    public int getPokemon3() {
        return pokemon3;
    }

    public void setPokemon3(int pokemon3) {
        this.pokemon3 = pokemon3;
    }

    public int getPokemon4() {
        return pokemon4;
    }

    public void setPokemon4(int pokemon4) {
        this.pokemon4 = pokemon4;
    }

    public int getPokemon5() {
        return pokemon5;
    }

    public void setPokemon5(int pokemon5) {
        this.pokemon5 = pokemon5;
    }

    public int getPokemon6() {
        return pokemon6;
    }

    public void setPokemon6(int pokemon6) {
        this.pokemon6 = pokemon6;
    }
}
