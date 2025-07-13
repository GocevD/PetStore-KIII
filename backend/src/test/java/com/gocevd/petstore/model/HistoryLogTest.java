package com.gocevd.petstore.model;

import com.gocevd.petstore.model.HistoryLog;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class HistoryLogTest {
    @Test
    void testIncreaseSuccessfulPurchases() {
        HistoryLog log = new HistoryLog();
        log.setSuccessfulPurchases(0);
        log.increaseSuccessfulPurchases();
        assertEquals(1, log.getSuccessfulPurchases());
    }

    @Test
    void testIncreaseFailedPurchases() {
        HistoryLog log = new HistoryLog();
        log.setFailedPurchases(0);
        log.increaseFailedPurchases();
        assertEquals(1, log.getFailedPurchases());
    }
} 