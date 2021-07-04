package com.steven.consumer.msg;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;


@Component
@Slf4j

public class MsgListener {

    @RabbitListener(queues = "fanout_queue1")
    public void getMsg1(String msg){

        log.info("fanout_queue1消费者受到消息：-> "+msg);
    }

    @RabbitListener(queues = "fanout_queue2")
    public void getMsg2(String msg){

        log.info("fanout_queue2消费者受到消息：-> "+msg);
    }
}
