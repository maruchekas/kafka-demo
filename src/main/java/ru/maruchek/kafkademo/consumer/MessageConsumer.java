package ru.maruchek.kafkademo.consumer;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import ru.maruchek.kafkademo.model.UserDetails;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

/**
 * @author mahes
 */
@Slf4j
@Service
public class MessageConsumer {

    @KafkaListener(topics = "#{'${spring.kafka.topic}'}")
    public void subscribeMessage(ConsumerRecord<String, UserDetails> message) throws Exception {
        UserDetails payload = message.value();
        LocalDateTime consumedTime = LocalDateTime.ofInstant(Instant.ofEpochMilli(message.timestamp()),
                ZoneId.systemDefault());
        log.info("Successfully consumed message with id: {} published at: {}", payload.getUserId(), consumedTime);
    }
}