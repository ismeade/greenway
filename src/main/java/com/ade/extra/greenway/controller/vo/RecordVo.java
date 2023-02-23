package com.ade.extra.greenway.controller.vo;

import lombok.Data;

@Data
public class RecordVo {

    private Long id;
    private String carNo;
    private String createTime;

    public Long getId() {
        return id;
    }

    public RecordVo setId(Long id) {
        this.id = id;
        return this;
    }

    public String getCarNo() {
        return carNo;
    }

    public RecordVo setCarNo(String carNo) {
        this.carNo = carNo;
        return this;
    }

    public String getCreateTime() {
        return createTime;
    }

    public RecordVo setCreateTime(String createTime) {
        this.createTime = createTime;
        return this;
    }
}
