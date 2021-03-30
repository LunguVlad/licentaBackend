package licenta.backend.controllers;


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

    @PostMapping(path = "createUser")
    public ResponseEntity createUser(@RequestBody User user){
        try {
            userService.createUser(user);
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
