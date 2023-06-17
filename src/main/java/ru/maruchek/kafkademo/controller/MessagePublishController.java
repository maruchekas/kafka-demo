package ru.maruchek.kafkademo.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.maruchek.kafkademo.servise.MessageService;

@RestController
@RequestMapping("/api/publish")
@RequiredArgsConstructor
public class MessagePublishController {

    private final MessageService messageService;

    @GetMapping("/string")
    public void sendString(@RequestParam("message") String message) {
        messageService.sendMessage(message);
    }
}
