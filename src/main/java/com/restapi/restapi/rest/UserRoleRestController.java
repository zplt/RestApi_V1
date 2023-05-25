package com.restapi.restapi.rest;

import com.restapi.restapi.model.entity.UserRole;
import com.restapi.restapi.service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/userRole")
public class UserRoleRestController {

    private UserRoleService userRoleService;

    @Autowired
    public UserRoleRestController(UserRoleService userRoleService) {
        this.userRoleService = userRoleService;
    }

    @GetMapping("")
    public List<UserRole> getAll(){
        List<UserRole> userRoles= userRoleService.findAllUser();
        return userRoles;
    }

    @GetMapping("/{userRoleId}")
    public UserRole getById(@PathVariable("userRoleId") int id){
        UserRole userRole=userRoleService.findById(id);
        return  userRole;
    }

    @PostMapping("")
    public String saveUser(@RequestBody UserRole userRole){
        UserRole theUserRole=userRoleService.save(userRole);
        return "UserRole saved -id " + theUserRole.getId();
    }

    @DeleteMapping("/{userRoleId}")
    public String deletUser(@PathVariable("userRoleId") int id) {
        userRoleService.deleteById(id);
        return "UserRole removed from record";
    }

}
