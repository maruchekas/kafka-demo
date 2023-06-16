package ru.maruchek.kafkademo.controller;

import java.util.HashMap;
import java.util.Map;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.maruchek.kafkademo.model.UserDetails;
import ru.maruchek.kafkademo.producer.MessagePublisher;


/**
 * @author mahes
 *
 */
@RestController
@RequestMapping("/api/publish")
@RequiredArgsConstructor
public class MessagePublishController {

    private final MessagePublisher messagePublisher;

    @PostMapping
    public ResponseEntity<Map<String, Object>> publishMessage(@RequestBody UserDetails userDetails) {
        Map<String, Object> map = new HashMap<>();
        map.put("message-id", userDetails.getUserId());
        map.putAll(messagePublisher.publishMessage(userDetails));
        return new ResponseEntity<>(map, HttpStatus.OK);
    }
}
