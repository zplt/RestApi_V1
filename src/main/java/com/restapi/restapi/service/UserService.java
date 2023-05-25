package com.restapi.restapi.service;

import com.restapi.restapi.model.dto.UserDTO;
import com.restapi.restapi.model.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UserService {

    //Updated with UserDTO
    Page<UserDTO> findAllUser(Pageable pageable);

    User findById(Integer id);

    User save(User theUser);

    void deleteById(Integer id);

}
