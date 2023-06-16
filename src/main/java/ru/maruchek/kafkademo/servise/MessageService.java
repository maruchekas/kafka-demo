package ru.maruchek.kafkademo.servise;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.maruchek.kafkademo.model.UserDetails;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class MessageService {

    private final MessagePublisher messagePublisher;

    public Map<String, Object> publish(UserDetails userDetails) {
        String id = UUID.randomUUID().toString();
        userDetails.setUserId(id);
        Map<String, Object> map = new HashMap<>();
        map.put("message-id", userDetails.getUserId());
        map.putAll(messagePublisher.publishMessage(userDetails));

        return map;
    }
}
