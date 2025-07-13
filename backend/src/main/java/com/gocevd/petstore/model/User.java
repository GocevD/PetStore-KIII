package com.gocevd.petstore.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column(nullable = false)
    String firstName;

    @Column(nullable = false)
    String lastName;

    @Column(nullable = false)
    String email;

    @Column(nullable = false)
    @Embedded
    Money budget;

    public boolean canAfford(Pet pet){
        return this.budget.amount >= pet.calculatePrice();
    }

    public boolean buyPet(Pet pet){
        if(pet == null){
            return false;
        }
        if(!pet.canBePurchased()){
            System.out.println("Pet already has an owner!");
            return false;
        }
        if(!this.canAfford(pet)){
            System.out.println("Not enough budget to afford pet!");
            return false;
        }
        double petPrice = pet.calculatePrice();
        double newAmount = this.budget.amount - petPrice;

        Money newBudget = new Money(newAmount);
        this.setBudget(newBudget);

        pet.setOwner(this);
        System.out.println(pet.successfulPurchaseMessage());
        return true;
    }
}
