package com.fila.rodado;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Slf4j
@Component
public class AMQPListener {

    @RabbitListener(queues = "${filas.um}")
    public void printerMessages(Message message){
        log.info("listener heard:"+message);

        System.out.println("\n"+ message.toString());
    }
}
