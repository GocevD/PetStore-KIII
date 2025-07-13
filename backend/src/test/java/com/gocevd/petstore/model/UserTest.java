package com.gocevd.petstore.model;

import com.gocevd.petstore.model.*;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {
    @Test
    void testCanAffordTrue() {
        User user = new User();
        user.setBudget(new Money(100));
        Cat cat = new Cat("Kitty", "desc", LocalDate.now().minusYears(2));
        assertTrue(user.canAfford(cat));
    }

    @Test
    void testCanAffordFalse() {
        User user = new User();
        user.setBudget(new Money(1));
        Dog dog = new Dog("Doggo", "desc", LocalDate.now().minusYears(5), 10);
        assertFalse(user.canAfford(dog));
    }

    @Test
    void testBuyPetNull() {
        User user = new User();
        assertFalse(user.buyPet(null));
    }

    @Test
    void testBuyPetAlreadyOwned() {
        User user = new User();
        user.setBudget(new Money(100));
        Cat cat = new Cat("Kitty", "desc", LocalDate.now().minusYears(2));
        User other = new User();
        cat.setOwner(other);
        assertFalse(user.buyPet(cat));
    }

    @Test
    void testBuyPetNotEnoughBudget() {
        User user = new User();
        user.setBudget(new Money(1));
        Cat cat = new Cat("Kitty", "desc", LocalDate.now().minusYears(2));
        assertFalse(user.buyPet(cat));
    }

    @Test
    void testBuyPetSuccess() {
        User user = new User();
        user.setFirstName("Alice");
        user.setLastName("Smith");
        user.setBudget(new Money(10));
        Cat cat = new Cat("Kitty", "desc", LocalDate.now().minusYears(2));
        assertTrue(user.buyPet(cat));
        assertEquals(user, cat.getOwner());
        assertTrue(user.getBudget().getAmount() < 10);
    }
} 