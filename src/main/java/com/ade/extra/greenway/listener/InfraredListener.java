package com.ade.extra.greenway.listener;

import com.ade.extra.greenway.processor.IProcessor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * 红外消息接听
 * TODO 在这里实现设备红外设备对接
 */
@Slf4j
@Component
public class InfraredListener extends AbstractListener {

    public InfraredListener(IProcessor processor) {
        super(processor);
    }

    @Override
    public void init() {

    }


    // TODO 实现红外监听
    // 将事件发给processor.event(PassCarEvent event)

}
