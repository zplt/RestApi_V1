package com.restapi.restapi.model.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.boot.context.properties.bind.DefaultValue;

@Data
public class RequestParamDTO {
    @JsonProperty(defaultValue = "1")
    private int page;
    @JsonProperty(defaultValue = "3")
    private int size;
}
