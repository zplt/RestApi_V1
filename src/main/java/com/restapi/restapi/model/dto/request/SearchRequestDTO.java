package com.restapi.restapi.model.dto.request;

import lombok.Data;

@Data
public class SearchRequestDTO {
    private String column;
    private String value;
}


