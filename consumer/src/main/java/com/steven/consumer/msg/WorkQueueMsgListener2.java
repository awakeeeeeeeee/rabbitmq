package com.steven.consumer.msg;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.io.IOException;


@Component
@Slf4j
public class WorkQueueMsgListener2 {


//    @RabbitListener(queues = "workQueue")
    public void getMsg2(String msg) throws IOException {
        log.info("消費者2收到消息：-> "+msg);
    }
}
