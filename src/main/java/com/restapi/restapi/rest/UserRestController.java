package com.restapi.restapi.rest;

import com.restapi.restapi.model.dto.UserDTO;
import com.restapi.restapi.model.entity.User;
import com.restapi.restapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/user")
public class UserRestController {

    private UserService userService;

    @Autowired
    public UserRestController(UserService userService) {
        this.userService = userService;
    }

    //Catch'e gerek yok, global exception handler yazıldı.
    //Response için dto yazılması gerekli.
    //getAll yerine search metodu yazılmalı. Ve belli kriterlere göre arama yapılmalı.
    //Pagination için pageable sınıfı kullanılabilir
    //Request parametreleri için dto yazılmalı.
    //Swagger ile endpoint dokümantasyonu yapılmalı.
    @GetMapping("")
    public ResponseEntity<Map<String,Object>> getAll(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "3") int size){
        try {
            List<User> users= new ArrayList<>();
            Pageable paging= PageRequest.of(page, size);
            Page<UserDTO> pageUser=userService.findAllUser(paging);
            users=pageUser.getContent();
            Map<String,Object> response=new HashMap<>();
            response.put("users",users);
            response.put("currentPage",pageUser.getNumber());
            response.put("totalItems",pageUser.getTotalElements());
            response.put("totalPages",pageUser.getTotalPages());
            return new ResponseEntity<>(response,HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //User entity'si yerine UserResponseDto yazılmalı.
    @GetMapping("/{userId}")
    public User getById(@PathVariable("userId") int id) {
        User user=userService.findById(id);
        return  user;
    }

    //Başarılı işlemde String döndürmek yerine standart bir body belirlenebilir.
    // {
    //   "success": true,
    //   "message": "İşlem Başarılı"
    // }
    @PostMapping("")
    public String saveUser(@RequestBody User user){
        User theUser=userService.save(user);
        return "User saved -id " + theUser.getId();
    }

    //Başarılı işlemde String döndürmek yerine standart bir body belirlenebilir.
    @DeleteMapping("/{userId}")
    public String deletUser(@PathVariable("userId") int id) {
        userService.deleteById(id);
        return "User removed from record";
    }


}
