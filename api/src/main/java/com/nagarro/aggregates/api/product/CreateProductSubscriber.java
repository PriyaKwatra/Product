package com.nagarro.aggregates.api.product;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class CreateProductSubscriber {

    private static final String EXCHANGE_NAME = "nagarroExchange";

    public void onCreateProductMessage() throws IOException, TimeoutException {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        Connection connection = connectionFactory.newConnection();
        Channel channel = connection.createChannel();
        channel.exchangeDeclare(EXCHANGE_NAME, "topic");
        String queueName = channel.queueDeclare().getQueue();
        channel.queueBind(queueName, EXCHANGE_NAME, "command.product.create");
        final DeliverCallback deliverCallback = new DeliverCallback() {
            public void handle(String consumerTag, Delivery message) throws IOException {
                String message1 = new String(message.getBody(), "UTF-8");
                System.out.println(message1);
            }
        };
        channel.basicConsume(queueName, true, deliverCallback, new CancelCallback() {
            public void handle(String consumerTag) throws IOException {
            }
        });
    }
}
