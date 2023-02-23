package com.ade.extra.greenway.service.impl;

import java.time.LocalDateTime;
import java.util.List;

import com.ade.extra.greenway.mapstruct.RecordMapper;
import com.ade.extra.greenway.repository.BizRecordRepository;
import com.ade.extra.greenway.repository.entity.BizRecord;
import com.ade.extra.greenway.service.RecordService;

import com.ade.extra.greenway.service.dto.RecordDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * RecordServiceImpl
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class RecordServiceImpl implements RecordService {

    private final BizRecordRepository bizRecordRepository;
    private final RecordMapper recordMapper;

    @Override
    public List<RecordDto> findRecord(LocalDateTime startTime, LocalDateTime endTime, Pageable pageable) {
        log.info("startTime: {}, endTime: {}, pageable: {}", startTime, endTime, pageable);
        Page<BizRecord> bizRecordPage = bizRecordRepository.findByCreateTimeBetween(startTime, endTime, pageable);

        return recordMapper.toDto(bizRecordPage.getContent());
    }

}
