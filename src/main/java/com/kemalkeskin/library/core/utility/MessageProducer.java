
package com.kemalkeskin.library.core.utility;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class MessageProducer {
    @Value("${rabbitmq.exchange}")
    private String exchange;

    @Value("${rabbitmq.routingkey}")
    private String routingKey;

    private final AmqpTemplate amqpTemplate;

    public MessageProducer(AmqpTemplate amqpTemplate) {
        this.amqpTemplate = amqpTemplate;
    }

    public void sendMessage(Object message) {
        amqpTemplate.convertAndSend(exchange, routingKey, message);  // rabbbitMQ mesaj gönderir
        System.out.println("RabbitMQ -> Mesaj gönderildi: " + message);  // mesajı konsola yazar
    }
}
