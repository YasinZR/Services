package com.sdt.queryService.dto;

import jakarta.persistence.Id;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Data
public class QueryInfoDto {
    private Integer id;
    private Integer userId;
    private Integer areaId;
    private List<String> imageIds;
    private String status;
}
