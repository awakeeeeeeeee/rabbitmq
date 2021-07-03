package com.steven.producer;

import org.junit.jupiter.api.Test;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

@SpringBootTest
class ProducerApplicationTests {

    @Autowired
    private AmqpTemplate amqpTemplate;


    @Test
    void contextLoads() {

        System.out.println(amqpTemplate);

        LocalDateTime now = LocalDateTime.now();
        amqpTemplate.convertAndSend("mytopic-1",now.toString());
    }

}
