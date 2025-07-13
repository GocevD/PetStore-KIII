package com.gocevd.petstore.service;

import com.gocevd.petstore.model.HistoryLog;
import com.gocevd.petstore.repository.jpa.HistoryLogRepository;
import com.gocevd.petstore.service.impl.HistoryLogServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class HistoryLogServiceImplTest {
    @Mock
    private HistoryLogRepository historyLogRepository;

    @InjectMocks
    private HistoryLogServiceImpl historyLogService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testHistoryLogReturnsList() {
        when(historyLogRepository.findAll()).thenReturn(Collections.singletonList(new HistoryLog()));
        List<HistoryLog> logs = historyLogService.historyLog();
        assertNotNull(logs);
        assertEquals(1, logs.size());
    }

    @Test
    void testAddLog() {
        HistoryLog log = new HistoryLog();
        historyLogService.addLog(log);
        verify(historyLogRepository).save(log);
    }
} 