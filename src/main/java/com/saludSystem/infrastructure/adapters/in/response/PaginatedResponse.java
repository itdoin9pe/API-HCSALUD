package com.saludSystem.infrastructure.adapters.in.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;

@Data
public class PaginatedResponse<T> {
    private List<T> data;
    @Schema(description = "Total de registros", example = "0")
    private Long totalData;
}