package com.gocevd.petstore.repository.jpa;

import com.gocevd.petstore.model.HistoryLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
public interface HistoryLogRepository extends JpaRepository<HistoryLog, LocalDateTime> {
}
