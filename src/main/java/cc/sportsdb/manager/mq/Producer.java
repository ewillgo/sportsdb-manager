package cc.sportsdb.manager.mq;

import cc.sportsdb.common.data.mq.MqUtil;
import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

@Component
@EnableScheduling
public class Producer {

    private AtomicLong atomicLong = new AtomicLong(0);

    @Autowired
    private AmqpTemplate amqpTemplate;

    @Autowired
    private AmqpAdmin amqpAdmin;

    private volatile boolean inited = false;
    public static final String EXCHANGE_NAME = "order.direct";
    public static final String ROUTING_KEY = "order";
    public static final String QUEUE_NAME = "order.queue";
    private Exchange exchange;
    private Queue queue;
    private Binding binding;

    @Scheduled(fixedRate = 1000)
    public void sendMessage() {
        init();
        long number = atomicLong.getAndAdd(1);
        Map<String, Object> dataMap = new LinkedHashMap<>();
        dataMap.put("id", number);
        amqpTemplate.convertAndSend(EXCHANGE_NAME, ROUTING_KEY, dataMap);
        System.out.println(Thread.currentThread().getName() + " send number: " + dataMap);
    }

    private void init() {
        if (inited) {
            return;
        }
        this.exchange = MqUtil.declareDirectExchange(EXCHANGE_NAME, true, false);
        this.queue = MqUtil.declareDurableQueue(QUEUE_NAME);
        this.binding = MqUtil.binding(queue, exchange, ROUTING_KEY);
        inited = true;
    }
}
