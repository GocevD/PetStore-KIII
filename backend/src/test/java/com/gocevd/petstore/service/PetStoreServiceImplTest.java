package com.gocevd.petstore.service;

import com.gocevd.petstore.model.Cat;
import com.gocevd.petstore.model.HistoryLog;
import com.gocevd.petstore.model.Pet;
import com.gocevd.petstore.model.User;
import com.gocevd.petstore.service.impl.PetStoreServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Collections;

import static org.mockito.Mockito.*;

class PetStoreServiceImplTest {
    @Mock
    private com.gocevd.petstore.service.PetService petService;
    @Mock
    private com.gocevd.petstore.service.UserService userService;
    @Mock
    private com.gocevd.petstore.service.HistoryLogService historyLogService;

    @InjectMocks
    private PetStoreServiceImpl petStoreService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testBuy() {
        User user = mock(User.class);
        Pet pet = new Cat();
        when(userService.listUsers()).thenReturn(Collections.singletonList(user));
        when(petService.findPetWithoutOwner()).thenReturn(pet);
        when(user.buyPet(pet)).thenReturn(true);
        petStoreService.buy();
        verify(userService).saveUser(user);
        verify(petService).savePet(pet);
        verify(historyLogService).addLog(any(HistoryLog.class));
    }
} 