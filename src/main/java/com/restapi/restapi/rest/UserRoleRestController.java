package com.restapi.restapi.rest;

import com.restapi.restapi.model.dto.*;
import com.restapi.restapi.model.dto.request.RequestParamDTO;
import com.restapi.restapi.model.dto.response.ResponseDTO;
import com.restapi.restapi.model.dto.response.ResponseListDTO;
import com.restapi.restapi.model.entity.UserRole;
import com.restapi.restapi.service.userrole.UserRoleService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/api/userRole")
public class UserRoleRestController {

    private UserRoleService userRoleService;
    private ModelMapper modelMapper;

    @Autowired
    public UserRoleRestController(UserRoleService userRoleService,ModelMapper modelMapper) {
        this.userRoleService = userRoleService;
        this.modelMapper=modelMapper;
    }
    /*@GetMapping("")
    public List<UserRole> getAll(){
        List<UserRole> userRoles= userRoleService.findAllUser();
        return userRoles;
    }*/
    @GetMapping("")
    public ResponseEntity<ResponseListDTO> getAll(@ModelAttribute RequestParamDTO requestParamDTO) {
        Pageable paging = PageRequest.of(requestParamDTO.getPage(), requestParamDTO.getSize());
        ResponseListDTO responseListDTO=new ResponseListDTO();
        List<UserRoleDTO> userRoleDTO=new ArrayList<>();
        Page<UserRole> pageUser = userRoleService.findAllUser(paging);
        List<UserRole> userRoles = pageUser.getContent();
        for (UserRole u: userRoles) {
            UserRoleDTO us=modelMapper.map(u,UserRoleDTO.class);
            userRoleDTO.add(us);
        }
        responseListDTO.setUser(Collections.singletonList(userRoleDTO));
        responseListDTO.setTotalItems(pageUser.getTotalElements());
        responseListDTO.setCurrentPage(pageUser.getNumber());
        responseListDTO.setTotalPages(pageUser.getTotalPages());
        return new ResponseEntity<ResponseListDTO>(responseListDTO, HttpStatus.OK);
    }


    @GetMapping("/{userRoleId}")
    public ResponseEntity<UserRoleDTO> getById(@PathVariable("userRoleId") int id){
        UserRoleDTO userRole=userRoleService.findById(id);
        return  new ResponseEntity<UserRoleDTO>(userRole,HttpStatus.OK);
    }
    @PostMapping("")
    public ResponseEntity<ResponseDTO> saveUser(@RequestBody UserRole userRole){
        ResponseDTO responseDTO = new ResponseDTO();
        UserRole theUserRole=userRoleService.save(userRole);
        if (!(theUserRole == null)){
            responseDTO.setMessage("İşlem Başarılı");
            responseDTO.setSuccess(true);
            return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
        } else {
            responseDTO.setMessage("İşlem Başarısız");
            responseDTO.setSuccess(false);
            return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{userRoleId}")
    public ResponseEntity<ResponseDTO> deletUser(@PathVariable("userRoleId") int id) {
        UserRoleDTO userRole=userRoleService.findById(id);
        if (!(userRole == null)){
            ResponseDTO responseDTO = new ResponseDTO();
            userRoleService.deleteById(id);
            responseDTO.setMessage("İşlem Başarılı");
            responseDTO.setSuccess(true);
            return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
        }
        return null;
    }

}
