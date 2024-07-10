package com.sdt.queryService.services;

import com.sdt.queryService.dto.ResultDto;
import com.sdt.queryService.models.Queries;
import com.sdt.queryService.repos.QueryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ResultServiceImpl implements ResultService {
    private final QueryRepository queryRepository;
    private final KafkaTemplate<String, ResultDto> kafkaTemplate;


//    @Override
//    public void handleResult(ResultDto result) {
//        // Логика обработки результата
//        kafkaTemplate.send("query-status-topic", result);
//    }

    @Override
    public void handleResult(ResultDto resultDto) {
        Queries query = queryRepository.findById(resultDto.getQueryId())
                .orElseThrow(() -> new RuntimeException("Query not found"));

        query.setStatus(resultDto.getStatus());
        query.setResult(resultDto.getResult()); // Сохраняем результат

        queryRepository.save(query);
    }
}
