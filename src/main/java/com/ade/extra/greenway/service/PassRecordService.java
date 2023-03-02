package com.ade.extra.greenway.service;

import java.time.LocalDateTime;
import java.util.List;

import com.ade.extra.greenway.service.dto.PassRecordDto;
import org.springframework.data.domain.Pageable;

/**
 * RecordService
 */
public interface PassRecordService {

    List<PassRecordDto> findRecord(LocalDateTime startTime, LocalDateTime endTime, Pageable pageable);

}
