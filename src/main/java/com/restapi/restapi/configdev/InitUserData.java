package com.restapi.restapi.configdev;

import com.restapi.restapi.model.entity.User;
import com.restapi.restapi.service.UserService;
import jakarta.annotation.PostConstruct;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@ConditionalOnProperty(name = "spring.profiles.active", havingValue = "dev")
public class InitUserData {

    private UserService userService;

    public InitUserData(UserService userService) {
        this.userService = userService;
    }

    @PostConstruct
    public void createUser(){
        List<User> users = new ArrayList<>();
        users.add(new User("H001", 12345, "user1", "pass1", "John", "Doe", 1, "active", "Some attributes 1"));
        users.add(new User("H002", 67890, "user2", "pass2", "Jane", "Smith", 2, "inactive", "Some attributes 2"));
        users.add(new User("H003", 98765, "user3", "pass3", "Michael", "Johnson", 1, "active", "Some attributes 3"));
        users.add(new User("H004", 23765, "user4", "pass3", "Michael", "Johnson", 1, "active", "Some attributes 3"));
        users.add(new User("H005", 23765, "user5", "pass3", "Danyy", "Johnson", 1, "active", "Some attributes 3"));
        users.add(new User("H006", 545765, "user6", "pass3", "Donzo", "Johnson", 1, "active", "Some attributes 3"));
        users.add(new User("H007", 922365, "user7", "pass3", "Mordor", "Johnson", 1, "active", "Some attributes 3"));
        users.add(new User("H008", 98765, "user8", "pass3", "Mildrid", "Johnson", 1, "active", "Some attributes 3"));
        users.add(new User("H009", 964555, "user9", "pass3", "Can", "Johnson", 1, "active", "Some attributes 3"));
        users.add(new User("H010", 982345, "user10", "pass3", "Candy", "Johnson", 1, "active", "Some attributes 3"));
        users.add(new User("H011", 91115, "user11", "pass3", "Dany", "Johnson", 1, "active", "Some attributes 3"));
        users.add(new User("H013", 90005, "user12", "pass3", "Elf", "Johnson", 1, "active", "Some attributes 3"));
        users.add(new User("H014", 933235, "user13", "pass3", "Elidor", "Johnson", 1, "active", "Some attributes 3"));
        users.add(new User("H015", 95432, "user14", "pass3", "Tunny", "Johnson", 1, "active", "Some attributes 3"));
        users.add(new User("H016", 2345, "user15", "pass3", "Lendy", "Johnson", 1, "active", "Some attributes 3"));
        users.add(new User("H017", 9209885, "user16", "pass3", "Pablo", "Johnson", 1, "active", "Some attributes 3"));
        users.add(new User("H018", 109093, "user18", "pass3", "Olm", "Johnson", 1, "active", "Some attributes 3"));
        users.add(new User("H019", 234523, "user19", "pass3", "Tre", "Johnson", 1, "active", "Some attributes 3"));

        for (User u:users) {
            userService.save(u);
        }
    }
}
