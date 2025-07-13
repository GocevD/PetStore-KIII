package com.gocevd.petstore.model;

import com.gocevd.petstore.model.Cat;
import com.gocevd.petstore.model.User;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class CatTest {
    @Test
    void testCalculatePriceReturnsAge() {
        LocalDate birthDate = LocalDate.now().minusYears(5);
        Cat cat = new Cat("Kitty", "Test cat", birthDate);
        assertEquals(5, cat.calculatePrice());
    }

    @Test
    void testSuccessfulPurchaseMessage() {
        Cat cat = new Cat("Kitty", "Test cat", LocalDate.now());
        User user = new User();
        user.setFirstName("Alice");
        user.setLastName("Smith");
        cat.setOwner(user);
        String message = cat.successfulPurchaseMessage();
        assertTrue(message.contains("Meow, cat Kitty has owner Alice Smith"));
    }
} 