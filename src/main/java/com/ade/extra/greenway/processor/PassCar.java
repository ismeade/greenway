package com.ade.extra.greenway.processor;

import lombok.Data;

@Data
public class PassCar {

    /**
     * 车牌号
     */
    private String no;

    /**
     * 车辆当前状态
     * 0初始化 1
     */
    private int status;

    public void carWait() {
        try {
            // 等待车辆进入地感线圈，由地感线圈放开
            this.wait();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void carNotify() {
        // 等待车辆进入地感线圈，由地感线圈放开
        this.notify();
    }

}
