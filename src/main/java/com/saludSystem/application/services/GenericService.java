package com.saludSystem.application.services;

import com.saludSystem.infrastructure.adapters.in.response.ApiResponse;
import com.saludSystem.infrastructure.adapters.in.response.ListResponse;
import com.saludSystem.infrastructure.adapters.in.response.PaginatedResponse;

import java.util.List;
import java.util.UUID;

public interface GenericService<T, ID, CREATE_DTO, UPDATE_DTO> {
    ApiResponse save(CREATE_DTO dto);
    List<T> getList();
    T getById(ID id);
    ApiResponse update(ID id, UPDATE_DTO dto);
    ListResponse<T> getAllPaginated(UUID hospitalId, int page, int rows);
    ApiResponse delete(ID id);
}