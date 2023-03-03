package com.ade.extra.greenway.listener;

import com.ade.extra.greenway.processor.IProcessor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public abstract class AbstractListener implements IListener {

    protected final IProcessor processor;

}
