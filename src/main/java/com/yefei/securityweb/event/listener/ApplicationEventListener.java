package com.yefei.securityweb.event.listener;

import com.yefei.securityweb.event.MessageEvent;
import org.springframework.context.event.EventListener;

/**
 * @Author: yefei
 * @Date: create in 2019-11-25
 * @Desc:
 */
public class ApplicationEventListener {

    @EventListener
    public void processMessageEvent(MessageEvent event) {
        System.out.println(event);
    }
}
