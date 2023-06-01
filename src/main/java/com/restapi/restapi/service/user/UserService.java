package com.restapi.restapi.service.user;

import com.restapi.restapi.model.dto.UserDTO;
import com.restapi.restapi.model.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;

public interface UserService {


    Page<User> findAllUser(Pageable pageable);

    //For search specification method , progressing on it ......!
    List<User> findAll(Specification<User> specification);

    UserDTO findById(Integer id);

    User save(User theUser);

    void deleteById(Integer id);

}
