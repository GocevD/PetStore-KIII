package com.gocevd.petstore.model;

import com.gocevd.petstore.model.enumerations.Type;
import jakarta.persistence.Entity;
import java.time.LocalDate;

@Entity
public class Cat extends Pet {
    public Cat(String name, String description, LocalDate birthDate) {
        super(name, description, birthDate);
        setType(Type.CAT);
    }

    public Cat() {}

    @Override
    public double calculatePrice(){
        return this.getAge();
    }

    @Override
    public String successfulPurchaseMessage() {
        return "Meow, cat " + this.getName() + " has owner " + this.getOwnerName();
    }

}
