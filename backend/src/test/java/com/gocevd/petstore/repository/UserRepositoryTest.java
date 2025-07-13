package com.gocevd.petstore.repository;

import com.gocevd.petstore.model.Money;
import com.gocevd.petstore.model.User;
import com.gocevd.petstore.repository.jpa.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class UserRepositoryTest {
    @Autowired
    private UserRepository userRepository;

    @Test
    void testSaveAndFind() {
        User user = new User();
        user.setFirstName("John");
        user.setLastName("Doe");
        user.setEmail("john@doe.com");
        user.setBudget(new Money(100));
        User saved = userRepository.save(user);
        assertNotNull(saved.getId());
        User found = userRepository.findById(saved.getId()).orElse(null);
        assertNotNull(found);
        assertEquals("John", found.getFirstName());
    }
} 