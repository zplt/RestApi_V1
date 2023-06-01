package com.restapi.restapi.model.dto.request;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;


import java.util.List;

@Data
public class RequestDTO {

    private List<SearchRequestDTO> searchRequestDTOs;

    @JsonProperty("gLobalOperator")
    private GLobalOperator gLobalOperator;

    public enum GLobalOperator{
        AND, OR;
    }

}

