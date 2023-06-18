package ru.maruchek.kafkademo.servise;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import ru.maruchek.kafkademo.model.StringCallbackListener;

@Slf4j
@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class MessageService {

    KafkaTemplate<String, String> kafka;
    StringCallbackListener stringCallbackListener;
    @Value("${kafka.topic.name}")
    String topicName;

    public void sendMessage(String key, String message) {
        assert key != null;
        val future = kafka.send(topicName, key, message);
        future.addCallback(stringCallbackListener);
    }
}
