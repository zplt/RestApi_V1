package com.restapi.restapi.service;

import com.restapi.restapi.entity.User;
import com.restapi.restapi.entity.UserRole;

import java.util.List;

public interface UserRoleService {


    List<UserRole> findAllUser();

    UserRole findById(Integer id);

    UserRole save(UserRole theUser);

    void deleteById(Integer id);


}
