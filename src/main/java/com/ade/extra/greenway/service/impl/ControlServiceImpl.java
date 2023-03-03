package com.ade.extra.greenway.service.impl;

import com.ade.extra.greenway.service.ControlService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class ControlServiceImpl implements ControlService {

    @Override
    public void signalLight(int status) {
        //TODO 信号灯
    }

    @Override
    public void roadblock(int status) {
        //TODO 路障
    }

    @Override
    public void shootX(int status) {
        //TODO x发射端
    }

    @Override
    public void receiveX(int status) {
        //TODO x接收端
    }
}
