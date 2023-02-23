package com.ade.extra.greenway.controller;

import com.ade.extra.greenway.controller.vo.RecordVo;
import com.ade.extra.greenway.mapstruct.RecordMapper;
import com.ade.extra.greenway.service.RecordService;
import com.ade.extra.greenway.service.dto.RecordDto;
import com.ade.extra.greenway.utils.TimeUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * record
 */
@Slf4j
@RestController
@RequestMapping("/records")
@RequiredArgsConstructor
public class RecordController {

    private final RecordService recordService;

    @GetMapping("")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<List<RecordVo>> getRecord(@RequestParam(required = false, defaultValue = "0") Integer page,
                                                    @RequestParam(required = false, defaultValue = "10") Integer pageSize,
                                                    @RequestParam String startTime,
                                                    @RequestParam String endTime) {
        log.info("page: {}, pageSize: {}, startTime: {}, endTime: {}", page, pageSize, startTime, endTime);
        final List<RecordDto> record = recordService.findRecord(TimeUtil.toDate(startTime),
                TimeUtil.toDate(endTime),
                PageRequest.of(page, pageSize));

        return ResponseEntity.ok().body(RecordMapper.INSTANCE.toVo(record));
    }
}
