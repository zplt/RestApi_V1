package com.restapi.restapi.service;

import com.restapi.restapi.entity.User;

import java.util.List;

public interface UserService {

    List<User> findAllUser();

    User findById(Integer id);

    User save(User theUser);

    void deleteById(Integer id);

}
