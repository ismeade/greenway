package com.ade.extra.greenway.repository.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * 操作日志
 */
@Data
@Entity(name = "control_log")
public class ControlLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "user")
    private String user;
    @Column(name = "operator")
    private String operator;
    @Column(name = "operator_time")
    private LocalDateTime operatorTime;

}
