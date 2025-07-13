package com.gocevd.petstore.web.graphql;

import com.gocevd.petstore.model.User;
import com.gocevd.petstore.service.UserService;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class UserGraphQLController {

    private final UserService userService;

    public UserGraphQLController(UserService userService) {
        this.userService = userService;
    }

    @QueryMapping
    public List<User> listUsers() {
        return userService.listUsers();
    }

    @MutationMapping
    public List<User> createUsers(){
        return userService.createUsers();
    }


}
