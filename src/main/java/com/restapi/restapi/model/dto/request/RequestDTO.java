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

//PostMan Request Data write in ReadMe file after ...!
/*
{
    "gLobalOperator": "OR",

    "searchRequestDTOs":[
        {
            "column":"username",
            "value":"user16"
        },

        {
            "column":"username",
            "value":"user10"
        }
    ]
}*/