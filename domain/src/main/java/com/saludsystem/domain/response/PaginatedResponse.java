package com.saludsystem.domain.response;

import lombok.Data;

import java.util.List;

@Data
public class PaginatedResponse<T> {
    private List<T> data;
    private Long totalData;
}