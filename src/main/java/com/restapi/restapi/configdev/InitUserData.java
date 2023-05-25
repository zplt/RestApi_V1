package com.restapi.restapi.configdev;

import com.restapi.restapi.entity.User;
import com.restapi.restapi.service.UserService;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.ArrayList;
import java.util.List;

@Component
public class InitUserData {

    private UserService userService;

    public InitUserData(UserService userService) {
        this.userService = userService;
    }

    @PostConstruct
    public String createUser(){
        List<User> users = new ArrayList<>();
       // users.add(new User(1, 'ADMIN', '', 'active', 1));
        //create post data for dev env.

        return "";
    }
}
