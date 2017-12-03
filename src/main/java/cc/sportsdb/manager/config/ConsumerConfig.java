package cc.sportsdb.manager.config;

import cc.sportsdb.manager.mq.Consumer;
import cc.sportsdb.manager.mq.Producer;
import org.springframework.amqp.core.AcknowledgeMode;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConsumerConfig {

    @Bean
    public SimpleMessageListenerContainer simpleMessageListenerContainer(ConnectionFactory connectionFactory, MessageConverter messageConverter) {
        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer(connectionFactory);
//        container.setAcknowledgeMode(AcknowledgeMode.MANUAL);
        container.setQueueNames(Producer.QUEUE_NAME);
        container.setMessageConverter(messageConverter);
        container.setMessageListener(new MessageListenerAdapter(new Consumer()));
        return container;
    }

}
