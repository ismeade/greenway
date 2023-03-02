package com.ade.extra.greenway.controller;

import com.ade.extra.greenway.controller.vo.ControlCommandVo;
import com.ade.extra.greenway.service.ControlService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * dashboard
 */
@Slf4j
@RestController
@RequestMapping("/control")
@RequiredArgsConstructor
public class ControlController {

    private final ControlService controlService;

    /**
     * 返回控制台信息
     * @return 控制台信息
     */
    @GetMapping
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<Object> getConsoleInfo() {
        log.info("getConsoleInfo");
        // TODO get console info code

        return ResponseEntity.ok("consoles");
    }

    /**
     * 发送命令到设备
     * @param controlCommandVo 命令
     * @return 结果
     */
    @PostMapping("/command")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<Object> sendCommand(@Valid @RequestBody ControlCommandVo controlCommandVo) {
        // TODO send command code

        return ResponseEntity.ok("sendCommand");
    }

}
