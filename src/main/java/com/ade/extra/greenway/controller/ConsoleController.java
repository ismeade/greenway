package com.ade.extra.greenway.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * dashboard
 */
@Slf4j
@RestController
@RequestMapping("/consoles")
@RequiredArgsConstructor
public class ConsoleController {

    // get all dashboard info
    @GetMapping
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<Object> getConsoleInfo() {
        log.info("getConsoleInfo");
        // TODO get console info code

        return ResponseEntity.ok("consoles");
    }

    // send a command
    @PostMapping("/command")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<Object> sendCommand() {
        // TODO send command code

        return ResponseEntity.ok("sendCommand");
    }

}
