package com.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

/**
 * @author HanYanBing
 * @date 2020/11/17 15:41
 * @description:
 */
@RestController
public class kafkaProducer {

    @Value("${kafka.topic.name}")
    String topic;

    @Autowired
    private KafkaTemplate<String,Object> kafkaTemplate;

    @PostMapping("sendMessage")
    public void sendMessage(@RequestParam String msg){
        System.out.println("msg = " + msg);
        kafkaTemplate.send(topic,msg);
    }

}
