package com.saludSystem.infrastructure.adapters.in.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ListResponse<T> {

    @Schema(description = "Lista de elementos", example = "[]")
    private List<T> data;

    private long totalElements;
    private int totalPages;
    private int currentPage;

    public ListResponse(List<T> data, long totalElements, int totalPages, int currentPage) {
        this.data = data;
        this.totalElements = totalElements;
        this.totalPages = totalPages;
        this.currentPage = currentPage;
    }

}