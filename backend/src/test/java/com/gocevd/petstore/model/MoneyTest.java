package com.gocevd.petstore.model;

import com.gocevd.petstore.model.Money;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MoneyTest {
    @Test
    void testConstructorAndGetter() {
        Money money = new Money(42.5);
        assertEquals(42.5, money.getAmount());
    }

    @Test
    void testSetter() {
        Money money = new Money();
        money.setAmount(99.9);
        assertEquals(99.9, money.getAmount());
    }
} 