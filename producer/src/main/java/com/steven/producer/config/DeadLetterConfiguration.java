package com.steven.producer.config;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class DeadLetterConfiguration {

    private static final String ROUTING = "test";

    @Bean
    DirectExchange directExchange(){
        return new DirectExchange("direct_exchange",true,false);
    }

    @Bean
    Queue deadQueue(){
        Map<String,Object> map = new HashMap<>();
        map.put("x-message-ttl",3000);
        return new Queue("deadQueue",true,false,false,map);
    }

//    @Bean
//    Queue deadQueue1(){
//        return new Queue("deadQueue",true,false,false);
//    }

    @Bean
    public Binding binding(){
        return BindingBuilder.bind(deadQueue()).to(directExchange()).with(ROUTING);
    }


}
