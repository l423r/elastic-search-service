package ru.maaax.elasticsearchservice.dto;

import lombok.Data;

@Data
public class ProductDtoRequest {
    private String id;
    private String name;
    private String description;
}
