package com.ade.extra.greenway.service.impl;

import java.time.LocalDateTime;
import java.util.List;

import com.ade.extra.greenway.mapstruct.PassRecordMapper;
import com.ade.extra.greenway.repository.PassRecordRepository;
import com.ade.extra.greenway.repository.entity.PassRecord;
import com.ade.extra.greenway.service.PassRecordService;

import com.ade.extra.greenway.service.dto.PassRecordDto;
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
public class PassRecordServiceImpl implements PassRecordService {

    private final PassRecordRepository passRecordRepository;

    @Override
    public List<PassRecordDto> findRecord(LocalDateTime startTime, LocalDateTime endTime, Pageable pageable) {
        log.info("startTime: {}, endTime: {}, pageable: {}", startTime, endTime, pageable);
        Page<PassRecord> bizRecordPage = passRecordRepository.findByCreateTimeBetween(startTime, endTime, pageable);

        return PassRecordMapper.INSTANCE.toDto(bizRecordPage.getContent());
    }

}
