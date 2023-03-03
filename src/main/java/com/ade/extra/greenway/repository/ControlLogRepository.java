package com.ade.extra.greenway.repository;

import com.ade.extra.greenway.repository.entity.ControlLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ControlLogRepository extends JpaRepository<ControlLog, Long> {
}
