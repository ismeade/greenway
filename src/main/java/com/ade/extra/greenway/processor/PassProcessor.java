package com.ade.extra.greenway.processor;

import com.ade.extra.greenway.listener.InfraredListener;
import com.ade.extra.greenway.listener.StressListener;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * 通行处理器
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class PassProcessor implements IProcessor {

    private final InfraredListener infraredListener;
    private final StressListener stressListener;

    /**
     * 开始一次车辆通过
     * @param car 通行车辆信息
     */
    public void start(PassCar car) {

        // 等待车辆进入地感线圈，由地感线圈放开
        car.carWait();
        log.info("车辆 {}，【触发】地感线圈", car.getNo());
        // TODO 触发地感线圈动作
        // 等待车辆离开地感线圈，由地感线圈放开
        car.carWait();
        log.info("车辆 {}，【离开】地感线圈", car.getNo());
    }

}
