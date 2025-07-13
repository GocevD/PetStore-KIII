package com.gocevd.petstore.model;

import com.gocevd.petstore.model.Dog;
import com.gocevd.petstore.model.User;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class DogTest {
    @Test
    void testCalculatePriceReturnsAgePlusRating() {
        LocalDate birthDate = LocalDate.now().minusYears(4);
        Dog dog = new Dog("Buddy", "Test dog", birthDate, 7);
        assertEquals(4 + 7, dog.calculatePrice());
    }

    @Test
    void testSuccessfulPurchaseMessage() {
        Dog dog = new Dog("Buddy", "Test dog", LocalDate.now(), 5);
        User user = new User();
        user.setFirstName("Bob");
        user.setLastName("Jones");
        dog.setOwner(user);
        String message = dog.successfulPurchaseMessage();
        assertTrue(message.contains("Woof, dog Buddy has owner Bob"));
    }
} 