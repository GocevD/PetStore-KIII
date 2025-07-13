package com.gocevd.petstore.web.graphql;

import com.gocevd.petstore.model.HistoryLog;
import com.gocevd.petstore.service.HistoryLogService;
import com.gocevd.petstore.service.PetStoreService;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class PetStoreGraphQLController {
    private final PetStoreService petStoreService;
    private final HistoryLogService historyLogService;
    public PetStoreGraphQLController(PetStoreService petStoreService, HistoryLogService historyLogService) {
        this.petStoreService = petStoreService;
        this.historyLogService = historyLogService;
    }

    @MutationMapping
    public HistoryLog buy() {
        return petStoreService.buy();
    }

    @QueryMapping
    public List<HistoryLog> historyLogs() {
        return historyLogService.historyLog();
    }

}
