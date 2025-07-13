package com.gocevd.petstore.repository;

import com.gocevd.petstore.model.HistoryLog;
import com.gocevd.petstore.repository.jpa.HistoryLogRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class HistoryLogRepositoryTest {
    @Autowired
    private HistoryLogRepository historyLogRepository;

    @Test
    void testSaveAndFind() {
        HistoryLog log = new HistoryLog();
        log.setDateOfExecution(LocalDateTime.now());
        log.setSuccessfulPurchases(2);
        log.setFailedPurchases(1);
        historyLogRepository.save(log);
        HistoryLog found = historyLogRepository.findById(log.getDateOfExecution()).orElse(null);
        assertNotNull(found);
        assertEquals(2, found.getSuccessfulPurchases());
        assertEquals(1, found.getFailedPurchases());
    }
} 