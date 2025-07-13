package com.gocevd.petstore.service;

import com.gocevd.petstore.model.Money;
import com.gocevd.petstore.model.User;
import com.gocevd.petstore.repository.jpa.UserRepository;
import com.gocevd.petstore.service.impl.UserServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class UserServiceImplTest {
    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserServiceImpl userService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testListUsersReturnsList() {
        when(userRepository.findAll()).thenReturn(Collections.singletonList(new User()));
        List<User> users = userService.listUsers();
        assertNotNull(users);
        assertEquals(1, users.size());
    }

    @Test
    void testSaveUser() {
        User user = new User();
        when(userRepository.save(user)).thenReturn(user);
        User saved = userService.saveUser(user);
        assertEquals(user, saved);
    }

    @Test
    void testCreateUsersCallsSave() {
        userService.createUsers();
        verify(userRepository, atLeastOnce()).save(any(User.class));
    }
} 