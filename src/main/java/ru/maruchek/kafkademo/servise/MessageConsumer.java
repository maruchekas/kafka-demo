package ru.maruchek.kafkademo.servise;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import static ru.maruchek.kafkademo.config.KafkaConsumerConfig.TOPIC_NAME;

@Slf4j
@Service
public class MessageConsumer {

    @KafkaListener(topics = TOPIC_NAME)
    public void listen(@Payload String message,
                       @Header(KafkaHeaders.RECEIVED_PARTITION_ID) int partition) {
        log.info("Receive message: {} in partition {}", message, partition);
    }
}
