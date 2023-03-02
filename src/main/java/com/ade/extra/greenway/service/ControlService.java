package com.ade.extra.greenway.service;

public interface ControlService {

    // 控制信号灯
    void signalLight(int status);

    // 控制杆
    void roadblock(int status);

    // 控制发射器
    void shootX(int status);

    // 控制接收器
    void receiveX(int status);

}
