package com.restapi.restapi.model.dto;

import lombok.Data;

@Data
public class RequestParamDTO {
    private int page=0;
    private int size=3;
}
