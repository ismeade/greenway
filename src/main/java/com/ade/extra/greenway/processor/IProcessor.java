package com.ade.extra.greenway.processor;

import com.ade.extra.greenway.listener.event.PassCarEvent;

public interface IProcessor {

    void event(PassCarEvent event);

}
