package com.restapi.restapi.rest;

import com.restapi.restapi.model.dto.RequestParamDTO;
import com.restapi.restapi.model.dto.ResponseDTO;
import com.restapi.restapi.model.dto.ResponseListDTO;
import com.restapi.restapi.model.dto.UserDTO;
import com.restapi.restapi.model.entity.User;
import com.restapi.restapi.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/user")
public class UserRestController {

    private UserService userService;
    private ModelMapper modelMapper;

    @Autowired
    public UserRestController(UserService userService,ModelMapper modelMapper) {
        this.userService = userService;
        this.modelMapper=modelMapper;
    }

    //getAll yerine search metodu yazılmalı. Ve belli kriterlere göre arama yapılmalı.
    @GetMapping("")
    public ResponseEntity<ResponseListDTO> getAll(@ModelAttribute RequestParamDTO requestParamDTO) {
        Pageable paging = PageRequest.of(requestParamDTO.getPage(), requestParamDTO.getSize());
        ResponseListDTO responseListDTO=new ResponseListDTO();
        List<UserDTO> userDTO=new ArrayList<>();
        Page<User> pageUser = userService.findAllUser(paging);
        List<User> users = pageUser.getContent();
        for (User u: users) {
            UserDTO us=modelMapper.map(u,UserDTO.class);
            userDTO.add(us);
        }
        responseListDTO.setUser(Collections.singletonList(userDTO));
        responseListDTO.setTotalItems(pageUser.getTotalElements());
        responseListDTO.setCurrentPage(pageUser.getNumber());
        responseListDTO.setTotalPages(pageUser.getTotalPages());
        return new ResponseEntity<ResponseListDTO>(responseListDTO, HttpStatus.OK);
    }


    @GetMapping("/{userId}")
    public ResponseEntity<UserDTO> getById(@PathVariable("userId") int id) {
        UserDTO userDTO = userService.findById(id);
        return new ResponseEntity<UserDTO>(userDTO, HttpStatus.OK);
    }


    @PostMapping("")
    public ResponseEntity<ResponseDTO> saveUser(@RequestBody User user) {
        ResponseDTO responseDTO = new ResponseDTO();
        User theUser = userService.save(user);
        if (!(theUser == null)) {
            responseDTO.setMessage("İşlem Başarılı");
            responseDTO.setSuccess(true);
            return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
        } else {
            responseDTO.setMessage("İşlem Başarısız");
            responseDTO.setSuccess(false);
            return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<ResponseDTO> deletUser(@PathVariable("userId") int id) {
        UserDTO user = userService.findById(id);
        if (!(user == null)) {
            ResponseDTO responseDTO = new ResponseDTO();
            userService.deleteById(id);
            responseDTO.setMessage("İşlem Başarılı");
            responseDTO.setSuccess(true);
            return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
        }
        return null; // -->>with global execption if the user not found in db the userService throw exception!!!
    }
}
