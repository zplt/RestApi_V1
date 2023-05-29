package com.restapi.restapi.rest;

import com.restapi.restapi.model.dto.RequestParamDTO;
import com.restapi.restapi.model.dto.ResponseDTO;
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

    //getAll yerine search metodu yazılmalı. Ve belli kriterlere göre arama yapılmalı.
    @GetMapping("")
    public ResponseEntity<Map<String,Object>> getAll(@ModelAttribute RequestParamDTO requestParamDTO){
            List<User> users= new ArrayList<>();
            Pageable paging= PageRequest.of(requestParamDTO.getPage(), requestParamDTO.getSize());
            Page<User> pageUser=userService.findAllUser(paging);
            users=pageUser.getContent();
            Map<String,Object> response=new HashMap<>();
            response.put("users",users);
            response.put("currentPage",pageUser.getNumber());
            response.put("totalItems",pageUser.getTotalElements());
            response.put("totalPages",pageUser.getTotalPages());

            return new ResponseEntity<>(response,HttpStatus.OK);


    }


    @GetMapping("/{userId}")
    public ResponseEntity<UserDTO> getById(@PathVariable("userId") int id) {
        UserDTO userDTO=userService.findById(id);
        return  new ResponseEntity<UserDTO>(userDTO,HttpStatus.OK);
    }


    @PostMapping("")
    public ResponseEntity<ResponseDTO> saveUser(@RequestBody User user){
        ResponseDTO responseDTO=new ResponseDTO();
        User theUser=userService.save(user);
        if (!(theUser==null)){
            responseDTO.setMessage("İşlem Başarılı");
            responseDTO.setSuccess(true);
            return new ResponseEntity<ResponseDTO>(responseDTO,HttpStatus.OK) ;
        }else {
            responseDTO.setMessage("İşlem Başarısız");
            responseDTO.setSuccess(false);
            return new ResponseEntity<ResponseDTO>(responseDTO,HttpStatus.BAD_REQUEST) ;
        }
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<ResponseDTO> deletUser(@PathVariable("userId") int id) {
        UserDTO user=userService.findById(id);
        if (!(user==null)){
            ResponseDTO responseDTO=new ResponseDTO();
            userService.deleteById(id);
            responseDTO.setMessage("İşlem Başarılı");
            responseDTO.setSuccess(true);
            return new ResponseEntity<ResponseDTO>(responseDTO,HttpStatus.OK) ;
        }
        return null; // -->>with global execption if the user not found in db the userService throw exception!!!
    }
}
