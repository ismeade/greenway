package com.ade.extra.greenway.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * car
 */
@Slf4j
@RestController
@RequestMapping("/cars")
@RequiredArgsConstructor
public class CarController {

    /**
     * 车辆预约
     * @param carNo 车牌号
     * @return 预约结果
     */
    @PostMapping("/{carNo}/appointments")
    @PreAuthorize("hasRole('ROLE_GUEST')")
    public ResponseEntity<Object> createAppointment(@PathVariable String carNo) {
        log.info("carNo: {}", carNo);
        // TODO appointment code

        return ResponseEntity.ok("cars");
    }

}
