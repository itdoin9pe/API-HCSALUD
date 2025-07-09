package com.saludsystem.shared.application.service;

import com.saludsystem.shared.infrastructure.adapters.in.response.ApiResponse;
import com.saludsystem.shared.infrastructure.adapters.in.response.ListResponse;

import java.util.List;
import java.util.UUID;

public interface GenericService<R, C, U, ID> {
    ApiResponse save(C dto);
    List<R> getList();
    R getById(ID id);
    ApiResponse update(ID id, U dto);
    ListResponse<R> getAllPaginated(UUID hospitalId, int page, int rows);
    ApiResponse delete(ID id);
}