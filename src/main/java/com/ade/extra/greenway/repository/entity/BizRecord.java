package com.ade.extra.greenway.repository.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
public class BizRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "car_no")
    private String carNo;
    @Column(name = "create_time")
    private LocalDateTime createTime;

}
