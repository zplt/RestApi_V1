package com.restapi.restapi.service;

import com.restapi.restapi.dao.UserRepository;
import com.restapi.restapi.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{

    private UserRepository userService;

    @Autowired
    public UserServiceImpl(UserRepository userService) {
        this.userService = userService;
    }

    @Override
    public List<User> findAllUser() {
        return userService.findAll();
    }

    @Override
    public User findById(Integer id) {
        Optional<User> result=userService.findById(id);
        User theUser=null;
        if (result.isPresent()){
            theUser=result.get();
        }else {
            throw  new RuntimeException("Did not find user id - " + id);
        }
        return theUser;
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
