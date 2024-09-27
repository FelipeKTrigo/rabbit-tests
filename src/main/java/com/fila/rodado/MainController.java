package com.fila.rodado;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1")
public class MainController {

    @Autowired
    private RabbitTemplate template;
    @Autowired
    private ApplicationValues properties;

    @PostMapping("/save")
    public ResponseEntity<?> salvas(@RequestParam String mensagem){
        template.send(properties.getFiladeteste1(),new Message(mensagem.getBytes()));
        return ResponseEntity.ok("mensagem enviadado");
    }
    @GetMapping("/pega")
    public ResponseEntity getMessages(){
        return ResponseEntity.ok(template.receive(properties.getFiladeteste1()).getBody());
    }
}
