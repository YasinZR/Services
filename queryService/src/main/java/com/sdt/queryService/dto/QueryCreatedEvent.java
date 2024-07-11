package com.sdt.queryService.dto;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.List;


@Data
public class QueryCreatedEvent {
    private Integer queryId;
    private List<String> imagesId;
    private String soilType;
    private String sowingDate;
}
