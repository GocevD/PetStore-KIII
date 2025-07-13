package com.gocevd.petstore.service;

import com.gocevd.petstore.model.HistoryLog;
import org.springframework.stereotype.Service;

import java.util.List;

public interface HistoryLogService {
    List<HistoryLog> historyLog();
    void addLog(HistoryLog log);
}
