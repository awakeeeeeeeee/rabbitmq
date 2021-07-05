package com.steven.producer;

import com.rabbitmq.client.ConnectionFactory;
import org.junit.jupiter.api.Test;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;
import java.time.LocalDateTime;

@SpringBootTest
class ProducerApplicationTests {

//    @Autowired
//    private AmqpTemplate amqpTemplate;

    @Autowired
    private RabbitTemplate rabbitTemplate;


    @Test
    void contextLoads() {


        LocalDateTime now = LocalDateTime.now();

// 广播
//        amqpTemplate.convertAndSend("fanout_exchange","",now.toString());

//工作者/worker
//        for (int i = 1; i <21 ; i++) {
//
//            amqpTemplate.convertAndSend("","workQueue","工作者消息:"+i);
//        }

        rabbitTemplate.convertAndSend("","workQueue","工作者消息:"+1);

//死信
//        rabbitTemplate.convertAndSend("deadQueue",now.toString());

//        try {
//            System.in.read();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

    }

}
