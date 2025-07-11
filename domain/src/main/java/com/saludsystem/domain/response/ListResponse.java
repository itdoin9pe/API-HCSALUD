package com.saludsystem.domain.response;

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
    private long totalElements;
    @Schema(description = "Número total de paginas", example = "0")
    private int totalPages;
    @Schema(description = "Número total de paginas actuales", example = "0")
    private int currentPage;

    public ListResponse(List<T> data, long totalElements, int totalPages, int currentPage) {
        this.data = data;
        this.totalElements = totalElements;
        this.totalPages = totalPages;
        this.currentPage = currentPage;
    }
}