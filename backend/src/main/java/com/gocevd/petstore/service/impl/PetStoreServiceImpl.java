package com.gocevd.petstore.service.impl;

import com.gocevd.petstore.model.HistoryLog;
import com.gocevd.petstore.model.Pet;
import com.gocevd.petstore.model.User;
import com.gocevd.petstore.service.HistoryLogService;
import com.gocevd.petstore.service.PetService;
import com.gocevd.petstore.service.PetStoreService;
import com.gocevd.petstore.service.UserService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class PetStoreServiceImpl implements PetStoreService {
    private final PetService petService;
    private final UserService userService;
    private final HistoryLogService historyLogService;

    public PetStoreServiceImpl(PetService petService, UserService userService, HistoryLogService historyLogService) {
        this.petService = petService;
        this.userService = userService;
        this.historyLogService = historyLogService;
    }


    @Override
    public HistoryLog buy() {
        HistoryLog historyLog = new HistoryLog();
        historyLog.setDateOfExecution(LocalDateTime.now());
        for(User user : userService.listUsers()){
            Pet pet = petService.findPetWithoutOwner();
            if(user.buyPet(pet)){
                historyLog.increaseSuccessfulPurchases();
                userService.saveUser(user);
                petService.savePet(pet);
            } else historyLog.increaseFailedPurchases();
        }
        historyLogService.addLog(historyLog);
        return historyLog;
    }
}
