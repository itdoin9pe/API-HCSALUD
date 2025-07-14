package com.saludsystem.submodules.response;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ListResponse<T> {
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