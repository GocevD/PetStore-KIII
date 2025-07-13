package com.gocevd.petstore.service;

import com.gocevd.petstore.model.Cat;
import com.gocevd.petstore.model.Dog;
import com.gocevd.petstore.model.Pet;
import com.gocevd.petstore.repository.jpa.PetRepository;
import com.gocevd.petstore.service.impl.PetServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class PetServiceImplTest {
    @Mock
    private PetRepository petRepository;

    @InjectMocks
    private PetServiceImpl petService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testListPetsReturnsList() {
        when(petRepository.findAll()).thenReturn(Collections.singletonList(new Cat()));
        List<Pet> pets = petService.listPets();
        assertNotNull(pets);
        assertEquals(1, pets.size());
    }

    @Test
    void testSavePet() {
        Cat cat = new Cat();
        when(petRepository.save(cat)).thenReturn(cat);
        Pet saved = petService.savePet(cat);
        assertEquals(cat, saved);
    }

    @Test
    void testFindPetWithoutOwner() {
        Dog dog = new Dog();
        when(petRepository.findFirstByOwnerIsNullOrderById()).thenReturn(dog);
        Pet found = petService.findPetWithoutOwner();
        assertEquals(dog, found);
    }

    @Test
    void testCreatePetsCallsSave() {
        petService.createPets();
        verify(petRepository, atLeastOnce()).save(any(Pet.class));
    }
} 