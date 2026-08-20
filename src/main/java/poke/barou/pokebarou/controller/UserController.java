package poke.barou.pokebarou.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import poke.barou.pokebarou.entity.UserEntity;
import poke.barou.pokebarou.repository.UserRepository;

import java.util.List;

@RestController
@RequestMapping("/user")
@CrossOrigin("*")


public class UserController {
    @Autowired
    private UserRepository comands;
    @PostMapping
    public UserEntity saveUser(@RequestBody UserEntity User){
        return comands.save(User);
    }

    @GetMapping
    public List<UserEntity> listUser(){
        return comands.findAll();
    }

    @PutMapping("/{id}")
    public UserEntity updateUser(@PathVariable Integer id, @RequestBody UserEntity alterUser){
        UserEntity actualUser = comands.findById(id).orElseThrow();

        actualUser.setUser_name(alterUser.getUser_name());

        return comands.save(actualUser);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Integer id){
        comands.deleteById(id);
        return ;
    }
    

}
