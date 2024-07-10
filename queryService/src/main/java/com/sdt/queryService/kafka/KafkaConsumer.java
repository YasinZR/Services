package com.sdt.queryService.kafka;

import com.sdt.queryService.dto.QueryCreatedEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class KafkaConsumer {

    @KafkaListener(topics = "query-status-topic", groupId = "query-group")
    public void consume(QueryCreatedEvent event) {
        log.info(String.format("Received message: %s", event.toString()));
        // Обработка сообщения в зависимости от статуса
    }
}
