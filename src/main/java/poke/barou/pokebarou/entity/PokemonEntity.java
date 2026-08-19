package poke.barou.pokebarou.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class PokemonEntity {

    @Id
    private int  id_pokemon;
    private String pokemon_name;
    private String type1;
    private String type2;
    private int hp;
    private int atk;
    private int def;
    private int spAtk;
    private int spDef;
    private int speed;
    private int item;
    private int move1;
    private int move2;
    private int move3;
    private int move4;

    public int getId_pokemon() {
        return id_pokemon;
    }

    public void setId_pokemon(int id_pokemon) {
        this.id_pokemon = id_pokemon;
    }

    public int getMove1() {
        return move1;
    }

    public void setMove1(int move1) {
        this.move1 = move1;
    }

    public int getMove2() {
        return move2;
    }

    public void setMove2(int move2) {
        this.move2 = move2;
    }

    public int getMove3() {
        return move3;
    }

    public void setMove3(int move3) {
        this.move3 = move3;
    }

    public int getMove4() {
        return move4;
    }

    public void setMove4(int move4) {
        this.move4 = move4;
    }

    public int getItem() {
        return item;
    }

    public void setItem(int item) {
        this.item = item;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getSpDef() {
        return spDef;
    }

    public void setSpDef(int spDef) {
        this.spDef = spDef;
    }

    public int getSpAtk() {
        return spAtk;
    }

    public void setSpAtk(int spAtk) {
        this.spAtk = spAtk;
    }

    public int getDef() {
        return def;
    }

    public void setDef(int def) {
        this.def = def;
    }

    public int getAtk() {
        return atk;
    }

    public void setAtk(int atk) {
        this.atk = atk;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public String getType2() {
        return type2;
    }

    public void setType2(String type2) {
        this.type2 = type2;
    }

    public String getType1() {
        return type1;
    }

    public void setType1(String type1) {
        this.type1 = type1;
    }

    public String getPokemon_name() {
        return pokemon_name;
    }

    public void setPokemon_name(String pokemon_name) {
        this.pokemon_name = pokemon_name;
    }
}
