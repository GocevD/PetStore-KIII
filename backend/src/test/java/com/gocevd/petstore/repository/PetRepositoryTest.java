package com.gocevd.petstore.repository;

import com.gocevd.petstore.model.Cat;
import com.gocevd.petstore.model.Pet;
import com.gocevd.petstore.repository.jpa.PetRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class PetRepositoryTest {
    @Autowired
    private PetRepository petRepository;

    @Test
    void testSaveAndFind() {
        Cat cat = new Cat("Kitty", "desc", LocalDate.now().minusYears(2));
        Pet saved = petRepository.save(cat);
        assertNotNull(saved.getId());
        Pet found = petRepository.findById(saved.getId()).orElse(null);
        assertNotNull(found);
        assertEquals("Kitty", found.getName());
    }

    @Test
    void testFindFirstByOwnerIsNullOrderById() {
        Cat cat1 = new Cat("Cat1", "desc1", LocalDate.now().minusYears(1));
        Cat cat2 = new Cat("Cat2", "desc2", LocalDate.now().minusYears(2));
        petRepository.save(cat1);
        petRepository.save(cat2);
        Pet found = petRepository.findFirstByOwnerIsNullOrderById();
        assertNotNull(found);
        assertTrue(found.getName().equals("Cat1") || found.getName().equals("Cat2"));
    }
} 