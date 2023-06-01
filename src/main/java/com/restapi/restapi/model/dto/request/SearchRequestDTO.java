package com.restapi.restapi.model.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class SearchRequestDTO {
    private String column;
    private String value;

    @JsonProperty("operation")
    private Operation operation;

    public enum Operation {
        EQUAL, LIKE, IN, GREATER_THAN, LESS_THAN, BETWEEN, JOIN;
    }

}


