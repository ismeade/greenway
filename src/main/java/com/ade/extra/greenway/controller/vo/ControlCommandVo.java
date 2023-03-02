package com.ade.extra.greenway.controller.vo;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * 控制设备命令
 */
@Data
public class ControlCommandVo {

    // 设备名称
    @NotBlank
    private String deviceName;
    // 设置状态
    @NotBlank
    private String status;

}
