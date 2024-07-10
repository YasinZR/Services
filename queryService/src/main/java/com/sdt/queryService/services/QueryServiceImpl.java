package com.sdt.queryService.services;

import com.sdt.queryService.dto.QueryCreateDto;
import com.sdt.queryService.dto.QueryCreatedEvent;
import com.sdt.queryService.dto.QueryInfoDto;
import com.sdt.queryService.dto.QueryResultDto;
import com.sdt.queryService.models.Queries;
import com.sdt.queryService.repos.QueryRepository;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Data
public class QueryServiceImpl implements QueryService {

    private final QueryRepository queryRepository;
    private final KafkaTemplate<String, QueryCreatedEvent> kafkaTemplate;
    private  RestTemplate restTemplate;


//    @Override
//    public QueryInfoDto createQuery(QueryCreateDto query) {
//        // Логика создания запроса
//        QueryCreatedEvent event = new QueryCreatedEvent();
//        // Заполнение события event
//        kafkaTemplate.send("query-status-topic", event);
//        return new QueryInfoDto();
//    }
    @Override
    public QueryInfoDto createQuery(QueryCreateDto queryDto) {
        Queries query = new Queries();
        query.setAreaId(queryDto.getAreaId());
        query.setStatus("Created");
        Queries savedQuery = queryRepository.save(query);

        QueryInfoDto queryInfoDto = new QueryInfoDto();
        queryInfoDto.setId(savedQuery.getId());
        queryInfoDto.setAreaId(savedQuery.getAreaId());
        queryInfoDto.setStatus(savedQuery.getStatus());

        // Send an event to Kafka (example)
        kafkaTemplate.send("query-topic", queryInfoDto);

        return queryInfoDto;
    }

    @Override
    public QueryInfoDto getQueryInfo(Integer id) {
        Queries query = queryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Query not found"));

        QueryInfoDto queryInfoDto = new QueryInfoDto();
        queryInfoDto.setId(query.getId());
        queryInfoDto.setAreaId(query.getAreaId());
        queryInfoDto.setStatus(query.getStatus());

        return queryInfoDto;
    }

    @Override
    public Page<QueryInfoDto> getAllQueriesInfo(Integer page, Integer size) {
        Page<Queries> queriesPage = queryRepository.findAll(PageRequest.of(page, size));
        List<QueryInfoDto> queryInfoDtos = queriesPage.stream().map(query -> {
            QueryInfoDto queryInfoDto = new QueryInfoDto();
            queryInfoDto.setId(query.getId());
            queryInfoDto.setAreaId(query.getAreaId());
            queryInfoDto.setStatus(query.getStatus());
            return queryInfoDto;
        }).collect(Collectors.toList());

        return new PageImpl<>(queryInfoDtos, PageRequest.of(page, size), queriesPage.getTotalElements());
    }

    @Override
    public QueryResultDto getQueryResult(Integer id) {
        Queries query = queryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Query not found"));

        QueryResultDto queryResultDto = new QueryResultDto();
        queryResultDto.setId(query.getId());
        queryResultDto.setAreaId(query.getAreaId());
        queryResultDto.setStatus(query.getStatus());

        return queryResultDto;
    }

    @Override
    public Page<QueryResultDto> getAllQueryResults(Integer page, Integer size) {
        Page<Queries> queriesPage = queryRepository.findAll(PageRequest.of(page, size));
        List<QueryResultDto> queryResultDtos = queriesPage.stream().map(query -> {
            QueryResultDto queryResultDto = new QueryResultDto();
            queryResultDto.setId(query.getId());
            queryResultDto.setAreaId(query.getAreaId());
            queryResultDto.setStatus(query.getStatus());
            return queryResultDto;
        }).collect(Collectors.toList());

        return new PageImpl<>(queryResultDtos, PageRequest.of(page, size), queriesPage.getTotalElements());
    }

    @Override
    public List<Integer> getAllQueriesByUser(Integer userId) {
        // Implement the method to fetch queries by userId if required
        return List.of();
    }
}
