package ru.maruchek.kafkademo.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.maruchek.kafkademo.model.UserDetails;
import ru.maruchek.kafkademo.servise.MessageService;

import java.util.Map;


/**
 * @author mahes
 */
@RestController
@RequestMapping("/api/publish")
@RequiredArgsConstructor
public class MessagePublishController {

    private final MessageService messageService;

    @PostMapping
    public ResponseEntity<Map<String, Object>> publishMessage(@RequestBody UserDetails userDetails) {
        return new ResponseEntity<>(messageService.publish(userDetails), HttpStatus.OK);
    }
}
