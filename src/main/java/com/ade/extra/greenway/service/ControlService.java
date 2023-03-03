package com.ade.extra.greenway.service;

public interface ControlService {

    /**
     * 控制信号灯
     * @param status 0 关闭 1 红 2 黄 3 绿
     */
    void signalLight(int status);

    /**
     * 控制路障
     * @param status 1 开 0 关
     */
    void roadblock(int status);

    /**
     * X发射器
     * @param status 1 开 0 关
     */
    void shootX(int status);

    /**
     * X接收器
     * @param status 1 开 0 关
     */
    void receiveX(int status);

}
