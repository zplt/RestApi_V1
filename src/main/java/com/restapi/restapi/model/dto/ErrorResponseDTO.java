package com.restapi.restapi.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ErrorResponseDTO {

    public int status;

    public String message;

    public long timeStamp;

}
