package com.ade.extra.greenway.repository.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * 通行记录
 */
@Data
@Entity(name = "biz_pass_record")
public class BizPassRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "car_no")
    private String carNo;
    @Column(name = "pic_front")
    private String picFront;
    @Column(name = "pic_back")
    private String picBack;
    @Column(name = "pic_top")
    private String picTop;
    @Column(name = "pic_x")
    private String picX;
    @Column(name = "pass_time")
    private LocalDateTime passTime;
    @Column(name = "create_time")
    private LocalDateTime createTime;

}
