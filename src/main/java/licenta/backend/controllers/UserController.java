package licenta.backend.controllers;


import com.fasterxml.jackson.annotation.JsonProperty;
import licenta.backend.daos.UserDao;
import licenta.backend.models.User;
import licenta.backend.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RequestMapping("/user")
@RestController
public class UserController {
    @Autowired
    private UserService userService;


    @GetMapping
    public ResponseEntity getAllUsers(){
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @GetMapping("{email}")
    public ResponseEntity getUserByEmail(@PathVariable String email){
        try {
            return ResponseEntity.ok(userService.getUserByEmail(email));
        }catch (NullPointerException ex){
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("{numarBloc}")
    public ResponseEntity getUserByEmail(@PathVariable int numarBloc){
        try {
            return ResponseEntity.ok(userService.getUsersByBloc(numarBloc));
        }catch (NullPointerException ex){
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/login/pls")
    public ResponseEntity getUserByAccount(@RequestBody User user){
        try{
            System.out.println(user.getEmail());
            System.out.println(user.getPassword());
            return ResponseEntity.ok(userService.getUserByAccount(user.getEmail(),user.getPassword()));
        }catch (NullPointerException ex){
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("{scara}/{apartament}")
    public ResponseEntity getUserByScaraAndApartament(@PathVariable int scara, @PathVariable int apartament){
        try{
            return ResponseEntity.ok(userService.getUserByScaraAndApartament(scara,apartament));
        }catch (NullPointerException nullPointerException){
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("{scara}")
    public ResponseEntity getUsersByScara(@PathVariable int scara){
        try{
            return ResponseEntity.ok(userService.getUsersByScara(scara));
        }catch (NullPointerException nullPointerException){
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping(path = "createUser/{numarBloc}")
    public ResponseEntity createUser(@RequestBody User user,@PathVariable int numarBloc){
        try {
            userService.createUser(user,numarBloc);
            return ResponseEntity.ok(true);
        }catch (Exception ex){
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @PatchMapping(path = "updateUser/{email}")
    public ResponseEntity updateUser(@PathVariable String email,@RequestBody User updatedUser){
        userService.updateUser(email,updatedUser);
        return ResponseEntity.ok(true);

    }




}
