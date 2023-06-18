package ru.maruchek.kafkademo.controller;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.maruchek.kafkademo.servise.MessageService;

@RestController
@RequestMapping("/api/publish")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class MessagePublishController {

    MessageService messageService;

    @GetMapping("/string")
    public void sendString(@RequestParam("key") String key,
                           @RequestParam("message") String message) {
        messageService.sendMessage(key, message);
    }
}
