package com.gocevd.petstore.web;


import com.gocevd.petstore.model.HistoryLog;
import com.gocevd.petstore.service.HistoryLogService;
import com.gocevd.petstore.service.PetStoreService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/api")
public class PetStoreController {
    private final PetStoreService petStoreService;
    private final HistoryLogService historyLogService;

    public PetStoreController(PetStoreService petStoreService, HistoryLogService historyLogService) {
        this.petStoreService = petStoreService;
        this.historyLogService = historyLogService;
    }
    @PostMapping("/buy")
    public void buy() {
        petStoreService.buy();
    }

    @GetMapping("/history")
    public List<HistoryLog> historyLog() {
        return historyLogService.historyLog();
    }

}
