package com.sdt.queryService.dto;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.List;
@Data
@Component
public class QueryCreateDto {
    private Integer areaId;
    private List<String> imageIds;
}