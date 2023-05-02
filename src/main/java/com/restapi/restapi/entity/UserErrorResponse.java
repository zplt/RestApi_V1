package com.restapi.restapi.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserErrorResponse {

    public int status;

    public String message;

    public long timeStamp;

}
