package com.sdt.queryService.dto;

import jakarta.persistence.Id;
import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class ResultDto {
    private Integer queryId;
    private String result;
    private String status;
}
