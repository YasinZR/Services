package com.sdt.queryService.services;

import com.sdt.queryService.dto.QueryCreateDto;
import com.sdt.queryService.dto.QueryInfoDto;
import com.sdt.queryService.dto.QueryResultDto;
import org.springframework.data.domain.Page;

import java.util.List;

public interface QueryService {
    QueryInfoDto createQuery(QueryCreateDto query);
    QueryInfoDto getQueryInfo(Integer id);
    Page<QueryInfoDto> getAllQueriesInfo(Integer page, Integer size);
    QueryResultDto getQueryResult(Integer id);
    Page<QueryResultDto> getAllQueryResults(Integer page, Integer size);
    List<Integer> getAllQueriesByUser(Integer id);
}
