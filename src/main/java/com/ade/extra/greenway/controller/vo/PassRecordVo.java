package com.ade.extra.greenway.controller.vo;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * 通行记录
 */
@Data
public class PassRecordVo {

    private Long id;
    private String carNo;
    private String picFront;
    private String picBack;
    private String picTop;
    private String picX;
    private LocalDateTime passTime;
    private LocalDateTime createTime;

}
