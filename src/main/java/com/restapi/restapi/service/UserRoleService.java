package com.restapi.restapi.service;

import com.restapi.restapi.model.entity.UserRole;

import java.util.List;

public interface UserRoleService {


    List<UserRole> findAllUser();

    UserRole findById(Integer id);

    UserRole save(UserRole theUser);

    void deleteById(Integer id);


}
