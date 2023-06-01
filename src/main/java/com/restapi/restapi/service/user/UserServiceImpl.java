package com.restapi.restapi.service.user;

import com.restapi.restapi.dao.UserRepository;
import com.restapi.restapi.model.dto.UserDTO;
import com.restapi.restapi.model.entity.User;
import com.restapi.restapi.model.dto.UserNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

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

    //using specification purpose of filter
    @Override
    public List<User> findAll(Specification<User> specification) {
        return userService.findAll(specification);
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
