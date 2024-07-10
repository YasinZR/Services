package com.sdt.queryService.kafka;

import com.sdt.queryService.dto.QueryCreatedEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class KafkaProducer {
    private final KafkaTemplate<String, QueryCreatedEvent> kafkaTemplate;

    public void sendMessage(QueryCreatedEvent event) {
        kafkaTemplate.send("query-status-topic", event);
    }
}
