package com.gocevd.petstore.service.impl;

import com.gocevd.petstore.model.Money;
import com.gocevd.petstore.model.User;
import com.gocevd.petstore.repository.jpa.UserRepository;
import com.gocevd.petstore.service.UserService;
import net.datafaker.Faker;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    Faker faker = new Faker();

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> createUsers() {
        List<User> createdUsers = new ArrayList<>();
        for(int i = 1; i < 11; i++) {
            Money money = new Money();
            User user = new User();
            money.setAmount(Math.round(200+Math.random()*100));
            user.setFirstName(faker.name().firstName());
            user.setLastName(faker.name().lastName());
            user.setEmail(faker.internet().emailAddress());
            user.setBudget(money);
            createdUsers.add(userRepository.save(user));
        }
        return createdUsers;
    }

    @Override
    public List<User> listUsers() {
        return userRepository.findAll();
    }

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }
}
