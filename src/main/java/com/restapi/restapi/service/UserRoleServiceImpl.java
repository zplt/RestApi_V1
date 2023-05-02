package com.restapi.restapi.service;

import com.restapi.restapi.dao.UserRolesRepository;
import com.restapi.restapi.entity.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserRoleServiceImpl implements UserRoleService {

    private UserRolesRepository userRoleService;

    @Autowired
    public UserRoleServiceImpl(UserRolesRepository userRoleService) {
        this.userRoleService = userRoleService;
    }

    @Override
    public List<UserRole> findAllUser() {
        return userRoleService.findAll();
    }

    @Override
    public UserRole findById(Integer id) {
        Optional<UserRole> result= userRoleService.findById(id);
        UserRole theUserRole=null;
        if (result.isPresent()){
            theUserRole=result.get();
        }else  {
            throw new RuntimeException("User Role Not Found id " + id);
        }
        return theUserRole;
    }

    @Override
    public UserRole save(UserRole theUser) {
        return userRoleService.save(theUser);
    }

    @Override
    public void deleteById(Integer id) {
        userRoleService.deleteById(id);
    }
}
