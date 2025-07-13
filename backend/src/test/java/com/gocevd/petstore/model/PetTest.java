package com.gocevd.petstore.model;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class PetTest {
    @Test
    void testGetAge() {
        LocalDate birthDate = LocalDate.now().minusYears(3);
        Pet pet = new Cat("Kitty", "desc", birthDate);
        assertEquals(3, pet.getAge());
    }

    @Test
    void testGetOwnerName() {
        Pet pet = new Cat("Kitty", "desc", LocalDate.now());
        User user = new User();
        user.setFirstName("Jane");
        user.setLastName("Doe");
        pet.setOwner(user);
        assertEquals("Jane Doe", pet.getOwnerName());
    }

    @Test
    void testGetPriceAmt() {
        Pet pet = new Cat("Kitty", "desc", LocalDate.now());
        Money money = new Money(55.5);
        pet.setPrice(money);
        assertEquals(55.5, pet.getPriceAmt());
    }

    @Test
    void testCanBePurchased() {
        Pet pet = new Cat("Kitty", "desc", LocalDate.now());
        assertTrue(pet.canBePurchased());
        User user = new User();
        pet.setOwner(user);
        assertFalse(pet.canBePurchased());
    }

    @Test
    void testSetOwner() {
        Pet pet = new Cat("Kitty", "desc", LocalDate.now());
        User user = new User();
        pet.setOwner(user);
        assertEquals(user, pet.getOwner());
    }
} 