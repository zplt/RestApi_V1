package com.restapi.restapi.service;

import com.restapi.restapi.dao.UserRepository;
import com.restapi.restapi.model.dto.UserDTO;
import com.restapi.restapi.model.entity.User;
import com.restapi.restapi.rest.UserNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;


import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{

    private UserRepository userService;
    private ModelMapper modelMapper;

    @Autowired
    public UserServiceImpl(UserRepository userService,ModelMapper modelMapper) {
        this.userService = userService;
        this.modelMapper=modelMapper;
    }

    @Override
    public Page<User> findAllUser(Pageable pageable) {
        return userService.findAll(pageable);
    }

    @Override
    public UserDTO findById(Integer id) {
        User user=userService.findById(id) .orElseThrow(() -> new UserNotFoundException("Did not find user id - " + id));
        UserDTO userDTO=modelMapper.map(user, UserDTO.class);
        return userDTO;
    }

    @Override
    public User save(User theUser) {
       return userService.save(theUser);
    }

    @Override
    public void deleteById(Integer id) {
        userService.deleteById(id);
    }
}
