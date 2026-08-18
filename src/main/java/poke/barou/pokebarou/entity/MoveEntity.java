package poke.barou.pokebarou.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class MoveEntity {

    @Id
    private String id_move;
    private String move_name;
    private String type;
    private String description;
    private String atkType;


    public String getId_move() {
        return id_move;
    }

    public void setId_move(String id_move) {
        this.id_move = id_move;
    }

    public String getMove_name() {
        return move_name;
    }

    public void setMove_name(String nome) {
        this.move_name = nome;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAtkType() {
        return atkType;
    }

    public void setAtkType(String atkType) {
        this.atkType = atkType;
    }
}
