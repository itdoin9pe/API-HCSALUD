package com.saludSystem.application.dtos.responses;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ListResponse<T> {
    @Schema(description = "Lista de elementos", example = "[]")
    private List<T> data;

    @Schema(description = "Número total de elementos", example = "0")
    private int totalData;

    public ListResponse(List<T> data, int totalData) {
        this.data = data;
        this.totalData = totalData;
    }
}
