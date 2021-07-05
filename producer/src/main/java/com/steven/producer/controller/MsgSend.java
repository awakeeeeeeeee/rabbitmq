package com.steven.producer.controller;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
public class MsgSend {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @GetMapping("/sennd")
    public void send(){

        LocalDateTime now = LocalDateTime.now();
//        rabbitTemplate.convertAndSend("deadQueue",now.toString());
        //发送失败，找不到对队列，回调接口 rabbitTemplateConfiguration
        rabbitTemplate.convertAndSend("deadQueue123",now.toString());
    }
}
