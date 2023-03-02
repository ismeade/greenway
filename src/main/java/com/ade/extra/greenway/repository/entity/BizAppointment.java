package com.ade.extra.greenway.repository.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

/**
 * 预约
 */
@Data
@Entity(name = "biz_appointment")
public class BizAppointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "car_no")
    private String carNo;
    @Column(name = "appointment_time")
    private LocalDateTime appointmentTime;
    @Column(name = "create_time")
    private LocalDateTime createTime;

}
