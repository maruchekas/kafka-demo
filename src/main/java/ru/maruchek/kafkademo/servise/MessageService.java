package ru.maruchek.kafkademo.servise;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import ru.maruchek.kafkademo.config.KafkaProducerConfig;

import java.util.concurrent.CompletableFuture;

@Slf4j
@Service
@RequiredArgsConstructor
public class MessageService {

    private final KafkaTemplate<String, String> kafka;

    public void sendMessage(String message) {
        CompletableFuture<SendResult<String, String>> future = kafka.send(KafkaProducerConfig.TOPIC_NAME, message);
        future.whenComplete((result, ex) -> {
            if (ex == null) {
                System.out.println("Sent message=[" + message +
                        "]\n to topic=[" + result.getRecordMetadata().topic()
                        + "]\n with offset=[" + result.getRecordMetadata().offset() + "]\n" +
                        "with partition=[" + result.getRecordMetadata().partition() + "]");
            } else {
                System.out.println("Unable to send message=[" +
                        message + "] due to : " + ex.getMessage());
            }
        });
    }
}
