package com.ade.extra.greenway.controller;

import com.ade.extra.greenway.controller.vo.PassRecordVo;
import com.ade.extra.greenway.mapstruct.PassRecordMapper;
import com.ade.extra.greenway.service.PassRecordService;
import com.ade.extra.greenway.service.dto.PassRecordDto;
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
public class PassRecordController {

    private final PassRecordService passRecordService;

    @GetMapping
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<List<PassRecordVo>> getPassRecord(@RequestParam(required = false, defaultValue = "0") Integer page,
                                                            @RequestParam(required = false, defaultValue = "10") Integer pageSize,
                                                            @RequestParam String startTime,
                                                            @RequestParam String endTime) {
        log.info("page: {}, pageSize: {}, startTime: {}, endTime: {}", page, pageSize, startTime, endTime);
        final List<PassRecordDto> record = passRecordService.findRecord(TimeUtil.toDate(startTime),
                TimeUtil.toDate(endTime),
                PageRequest.of(page, pageSize));

        return ResponseEntity.ok().body(PassRecordMapper.INSTANCE.toVo(record));
    }
}
