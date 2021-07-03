package msg;

import org.springframework.amqp.rabbit.annotation.RabbitListener;


public class MsgListener {

    @RabbitListener(queues = "",group = "")
    public void getMsg(){


    }
}
