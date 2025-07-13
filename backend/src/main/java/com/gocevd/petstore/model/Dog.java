package com.gocevd.petstore.model;

import com.gocevd.petstore.model.enumerations.Type;
import jakarta.persistence.*;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Entity
public class Dog extends Pet{

    @Column(nullable = false)
    int rating;

    public Dog(String name, String description, LocalDate birthDate, int rating) {
        super(name, description, birthDate);
        this.rating = rating;
        setType(Type.DOG);
    }

    public Dog() {}

    @Override
    public double calculatePrice(){
        return this.getAge() + rating;
    }

    @Override
    public String successfulPurchaseMessage() {
        return "Woof, dog " + this.getName() + " has owner " + this.getOwnerName();
    }

}
