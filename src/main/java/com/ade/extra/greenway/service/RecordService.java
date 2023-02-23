package com.ade.extra.greenway.service;

import java.time.LocalDateTime;
import java.util.List;

import com.ade.extra.greenway.repository.entity.BizRecord;

import com.ade.extra.greenway.service.dto.RecordDto;
import org.springframework.data.domain.Pageable;

/**
 * RecordService
 */
public interface RecordService {

    List<RecordDto> findRecord(LocalDateTime startTime, LocalDateTime endTime, Pageable pageable);

}
