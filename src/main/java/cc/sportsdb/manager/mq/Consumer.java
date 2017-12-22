package cc.sportsdb.manager.mq;

import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.io.IOException;

//@Component
public class Consumer {

    @RabbitListener(bindings = @QueueBinding(
            exchange = @Exchange(value = Producer.EXCHANGE_NAME, durable = "true"),
            value = @Queue(value = Producer.QUEUE_NAME, durable = "true", autoDelete = "false"),
            key = Producer.ROUTING_KEY
    ), containerFactory = "simpleRabbitListenerContainerFactory")
    public void onMessage(People people, Message message, Channel channel) throws IOException {
        try {
            System.out.println(people);
        } finally {
            channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
        }
    }
}
