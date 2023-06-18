package ru.maruchek.kafkademo.model;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.support.SendResult;
import org.springframework.util.concurrent.ListenableFutureCallback;

@Slf4j
public class StringCallbackListener implements ListenableFutureCallback<SendResult<String, String>> {
    @Override
    public void onFailure(Throwable ex) {
        log.error("Failed to send message: " + ex.getMessage());
    }

    @Override
    public void onSuccess(SendResult<String, String> result) {
        if (result == null || result.getRecordMetadata() == null) {
            throw new RuntimeException("Something went wrong");
        }
        log.info("Successful sending message to topic: {}\nOffset: {}\nPartition: {}",
                result.getRecordMetadata().topic(),
                result.getRecordMetadata().offset(),
                result.getRecordMetadata().partition());
    }
}
