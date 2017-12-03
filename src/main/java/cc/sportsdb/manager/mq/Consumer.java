package cc.sportsdb.manager.mq;

import org.springframework.stereotype.Component;

import java.util.Map;

//@Component
//@RabbitListener(bindings = @QueueBinding(
//        exchange = @Exchange(value = Producer.EXCHANGE_NAME, durable = "true"),
//        value = @Queue(value = Producer.QUEUE_NAME, durable = "true", autoDelete = "false"),
//        key = Producer.ROUTING_KEY
//), containerFactory = "simpleRabbitListenerContainerFactory")
public class Consumer/* implements ChannelAwareMessageListener */ {

//    @Override
//    public void onMessage(Message message, Channel channel) throws Exception {
//        System.out.println(message.toString());
//    }

    public void handleMessage(String data) {
        System.out.println("Receive: " + data.toString());
    }
}
