package com.gocevd.petstore.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
public class HistoryLog{
    @Id
    private LocalDateTime dateOfExecution;
    @Column
    private int successfulPurchases;
    @Column
    private int failedPurchases;



    public void increaseSuccessfulPurchases(){
        this.successfulPurchases++;
    }

    public void increaseFailedPurchases(){
        this.failedPurchases++;
    }
}
