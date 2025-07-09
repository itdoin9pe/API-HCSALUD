package com.saludsystem.shared.application.service;

import com.saludsystem.shared.infrastructure.adapters.in.response.ApiResponse;
import com.saludsystem.shared.infrastructure.adapters.in.response.ListResponse;

import java.util.List;
import java.util.UUID;

public interface GenericService<R, C, U, I> {
    ApiResponse save(C dto);
    List<R> getList();
    R getById(I id);
    ApiResponse update(I id, U dto);
    ListResponse<R> getAllPaginated(UUID hospitalId, int page, int rows);
    ApiResponse delete(I id);
}