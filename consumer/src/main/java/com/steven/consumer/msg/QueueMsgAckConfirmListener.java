package com.steven.consumer.msg;


import com.rabbitmq.client.Channel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.boot.autoconfigure.amqp.RabbitProperties;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
@Slf4j
public class QueueMsgAckConfirmListener {


    @RabbitListener(queues = "workQueue")
    public void receiveMsg(Message msg, Channel channel) throws IOException {

        log.info("msg: ->" + msg.toString());
        long deliveryTag = msg.getMessageProperties().getDeliveryTag();
        log.info("deliveryTag: ->" + deliveryTag);

        //手动确认消息已消费
//        try{
//            if(deliveryTag % 2 == 0){
//                channel.basicAck(deliveryTag,true);
//            }else {
//                //把消费失败的消息重新放入队列
//                channel.basicNack(deliveryTag,false,true);
//            }
//        }catch (Exception e){
//            log.error(e.getMessage());
//            channel.basicNack(deliveryTag,false,true);
//        }

        channel.basicNack(deliveryTag,false,true);
    }

}
