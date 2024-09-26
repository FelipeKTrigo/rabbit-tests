package com.fila.rodado;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.QueueBuilder;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class AMQPConfiguration {
    @Autowired
    private ApplicationValues properties;

    @Bean
    public Queue criaFila(){
        return QueueBuilder.nonDurable(properties.getFiladeteste1()).build();
    }
    @Bean
    public RabbitAdmin createNewAdmin(ConnectionFactory connectionFactory){
        return new RabbitAdmin(connectionFactory);
    }
    @Bean
    public ApplicationListener<ApplicationReadyEvent> inicializaconexao(RabbitAdmin adm){
        return event -> adm.initialize();
    }
}
