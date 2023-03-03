package com.ade.extra.greenway.listener.event;

public enum PassCarEvent {

    /**
     * 地感线圈1事件
     */
    STRESS_1_DOWN, // 按压
    STRESS_1_UP, // 抬起
    /**
     * 地感线圈2事件
     */
    STRESS_2_DOWN, // 按压
    STRESS_2_UP, // 抬起
    /**
     * 红外1事件
     */
    INFRARED_1_OFF, // 进入; 红外断开
    INFRARED_1_ON, // 未进入或离开; 红外接通
    /**
     * 红外2事件
     */
    INFRARED_2_OFF, // 进入; 红外断开
    INFRARED_2_ON, // 未进入或离开; 红外接通

    /**
     * 预约事件
     */
    APPOINTMENT, // 预约完成


}
