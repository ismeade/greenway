package com.ade.extra.greenway.listener;

import com.ade.extra.greenway.listener.event.PassCarEvent;
import com.ade.extra.greenway.processor.IProcessor;
import com.ade.extra.greenway.processor.PassProcessor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * 地感线圈消息监听器
 * TODO 在这里实现地感线圈设备对接
 */
@Slf4j
@Component
public class StressListener extends AbstractListener {

    public StressListener(IProcessor processor) {
        super(processor);
    }

    @Override
    public void init() {
        // TODO 设备连接初始化方法
    }

    // TODO 实现地感线圈监听
    // 将事件发给processor.event(PassCarEvent event)
    // processor.event(PassCarEvent.STRESS_DOWN);



}
