package com.restapi.restapi.service;

import com.restapi.restapi.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface UserService {

    Page<User> findAllUser(Pageable pageable);

    User findById(Integer id);

    User save(User theUser);

    void deleteById(Integer id);

}
