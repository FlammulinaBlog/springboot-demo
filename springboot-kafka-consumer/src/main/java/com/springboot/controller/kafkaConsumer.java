package com.springboot.controller;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * @author HanYanBing
 * @date 2020/11/17 15:17
 * @description:
 */
@Slf4j
@Component
public class kafkaConsumer {

    @KafkaListener(topics = {"test1"})
    public void listen(ConsumerRecord<?, ?> record) {
        Optional<?> optional = Optional.ofNullable( record.value() );
        if (optional.isPresent()) {
            Object msg = optional.get();
            log.info( "record:{}", record );
            log.info( "message:{}", msg );
        }
    }

    @KafkaListener(topics = {"test"})
    public void listenTest (ConsumerRecord<?, ?> record){
        System.out.printf("topic is %s, offset is %d, value is %s \n", record.topic(), record.offset(), record.value());
    }

}
