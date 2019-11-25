package com.yefei.securityweb.event;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.ApplicationEvent;

import java.util.Date;

/**
 * @Author: yefei
 * @Date: create in 2019-11-25
 * @Desc:
 */
@Data
public class MessageEvent {
    private String message;
    private Date happenTime;

    public MessageEvent(String message, Date happenTime) {
        this.message = message;
        this.happenTime = happenTime;
    }
}
