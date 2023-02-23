package com.ade.extra.greenway.service.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class RecordDto {

    private Long id;
    private String carNo;

    public Long getId() {
        return id;
    }

    public RecordDto setId(Long id) {
        this.id = id;
        return this;
    }

    public String getCarNo() {
        return carNo;
    }

    public RecordDto setCarNo(String carNo) {
        this.carNo = carNo;
        return this;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public RecordDto setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
        return this;
    }

    private LocalDateTime createTime;

}
