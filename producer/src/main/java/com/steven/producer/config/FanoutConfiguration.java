package com.steven.producer.config;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FanoutConfiguration {


    @Bean
    public FanoutExchange fanoutExchange(){
        return new FanoutExchange("fanout_exchange",true,false);
    }

    @Bean
    public Queue fanout_queue1(){
        return new Queue("fanout_queue1",true,false,false);
    }

    @Bean
    public Queue fanout_queue2(){
        return new Queue("fanout_queue2",true,false,false);
    }

    @Bean
    public Binding binding1(){

        return BindingBuilder.bind(fanout_queue1()).to(fanoutExchange());
    }

    @Bean
    public Binding binding2(){
        return BindingBuilder.bind(fanout_queue2()).to(fanoutExchange());
    }

//    @Bean
//    public DirectExchange directExchange(){
//        return new DirectExchange("direct-exchange",true,false,null);
//    }

//    @Bean
//    public Queue direct_queue3(){
//        return new Queue("direct_queue3",true,false,false);
//    }
//
//    @Bean
//    public Queue direct_queue4(){
//        return new Queue("direct_queue4",true,false,false);
//    }

//    @Bean
//    public Binding binding3(){
//        return BindingBuilder.bind(direct_queue3()).to(directExchange());
//    }
//
//    @Bean
//    public Binding binding4(){
//        return BindingBuilder.bind(direct_queue4()).to(directExchange());
//    }
}
