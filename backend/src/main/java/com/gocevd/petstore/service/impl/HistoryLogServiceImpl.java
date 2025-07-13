package com.gocevd.petstore.service.impl;

import com.gocevd.petstore.model.HistoryLog;
import com.gocevd.petstore.repository.jpa.HistoryLogRepository;
import com.gocevd.petstore.service.HistoryLogService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HistoryLogServiceImpl implements HistoryLogService {

    private final HistoryLogRepository historyLogRepository;

    public HistoryLogServiceImpl(HistoryLogRepository historyLogRepository) {
        this.historyLogRepository = historyLogRepository;
    }

    @Override
    public List<HistoryLog> historyLog() {
        return historyLogRepository.findAll();
    }

    @Override
    public void addLog(HistoryLog log){
        historyLogRepository.save(log);
    }
}
