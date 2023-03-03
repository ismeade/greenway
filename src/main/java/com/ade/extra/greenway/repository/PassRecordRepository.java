package com.ade.extra.greenway.repository;

import java.time.LocalDateTime;

import com.ade.extra.greenway.repository.entity.PassRecord;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * BizRecordRepository
 */
@Repository
public interface PassRecordRepository extends JpaRepository<PassRecord, Long> {

    Page<PassRecord> findByCreateTimeBetween(LocalDateTime startTime, LocalDateTime endTime, Pageable pageable);

}
