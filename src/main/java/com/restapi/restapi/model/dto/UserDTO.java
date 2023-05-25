package com.restapi.restapi.model.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {

    private int sicil_no;
    private String username;
    private String firstname;
    private String lastname;
    private String status;

}
