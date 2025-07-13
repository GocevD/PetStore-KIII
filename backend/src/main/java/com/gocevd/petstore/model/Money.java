package com.gocevd.petstore.model;


import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Embeddable
public class Money {
    double amount;

    public Money() {}

    public Money(double amount) {
        this.amount = amount;
    }

}
