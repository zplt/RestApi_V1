package com.restapi.restapi.model.dto;
import lombok.Data;

import java.util.List;


@Data
public class ResponseListDTO {
    private List<Object> user;
    private Integer currentPage;
    private Long totalItems;
    private Integer totalPages;
}
