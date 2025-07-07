package com.saludsystem.shared.application.service;

import com.saludsystem.shared.infrastructure.adapters.in.response.ApiResponse;
import com.saludsystem.shared.infrastructure.adapters.in.response.ListResponse;

import java.util.List;
import java.util.UUID;

public interface GenericService<REQ, RES, ID> {
    ApiResponse save(REQ dto);
    List<RES> getList();
    RES getById(ID id);
    ApiResponse update(ID id, REQ dto);
    ListResponse<RES> getAllPaginated(UUID hospitalId, int page, int rows);
    ApiResponse delete(ID id);
}