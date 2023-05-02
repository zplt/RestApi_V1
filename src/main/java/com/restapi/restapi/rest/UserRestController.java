package com.restapi.restapi.rest;

import com.restapi.restapi.entity.User;
import com.restapi.restapi.entity.UserErrorResponse;
import com.restapi.restapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api_v1")
public class UserRestController {

    private UserService userService;

    @Autowired
    public UserRestController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public List<User> getAll(){
        List<User> users= userService.findAllUser();
        return users;
    }

    @GetMapping("/users/{userId}")
    public User getById(@PathVariable("userId") int id){
        User user=userService.findById(id);
        return  user;
    }

    @PostMapping("/users")
    public String saveUser(@RequestBody User user){
        User theUser=userService.save(user);
        return "User saved -id " + theUser.getId();
    }

    @DeleteMapping("/users/{userId}")
    public String deletUser(@PathVariable("userId") int id) {
        userService.deleteById(id);
        return "User removed from record";
    }


}
