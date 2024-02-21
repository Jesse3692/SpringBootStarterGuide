package com.shiyanlou;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class Consumer {
    @RabbitListener(queues = "QueueA")
    public void receiveQueueA(String msg) {
        System.out.println("消费者 queueA 收到消息：" + msg);
    }

    @RabbitListener(queues = "QueueB")
    public void receiveQueueB(String msg) {
        System.out.println("消费者 queueB 收到消息：" + msg);
    }
}
