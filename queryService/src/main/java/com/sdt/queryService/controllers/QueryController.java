package com.sdt.queryService.controllers;

import com.sdt.queryService.dto.QueryCreateDto;
import com.sdt.queryService.dto.QueryInfoDto;
import com.sdt.queryService.dto.QueryResultDto;
import com.sdt.queryService.services.QueryService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/queries")
@RequiredArgsConstructor
public class QueryController {
    private final QueryService queryService;

    @PostMapping
    public QueryInfoDto createQuery(@RequestBody QueryCreateDto query) {
        return queryService.createQuery(query);
    }

    @GetMapping("/info/{id}")
    public QueryInfoDto getQueryInfo(@PathVariable Integer id) {
        return queryService.getQueryInfo(id);
    }

    @GetMapping("/info")
    public Page<QueryInfoDto> getAllQueriesInfo(@RequestParam Integer page, @RequestParam Integer size) {
        return queryService.getAllQueriesInfo(page, size);
    }

    @GetMapping("/result/{id}")
    public QueryResultDto getQueryResult(@PathVariable Integer id) {
        return queryService.getQueryResult(id);
    }

    @GetMapping("/result")
    public Page<QueryResultDto> getAllQueryResults(@RequestParam Integer page, @RequestParam Integer size) {
        return queryService.getAllQueryResults(page, size);
    }

    @GetMapping("/users/{userId}")
    public List<Integer> getAllQueriesByUser(@PathVariable Integer userId) {
        return queryService.getAllQueriesByUser(userId);
    }
}
