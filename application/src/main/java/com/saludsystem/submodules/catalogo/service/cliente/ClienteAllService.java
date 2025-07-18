package com.saludsystem.submodules.catalogo.service.cliente;

import com.saludsystem.submodules.catalogo.mapper.ClienteMapper;
import com.saludsystem.submodules.catalogo.model.dto.ClienteDTO;
import com.saludsystem.submodules.catalogo.port.dao.ClienteDao;
import com.saludsystem.submodules.response.ListResponse;
import com.saludsystem.submodules.response.PaginationRequest;

import java.util.UUID;

public class ClienteAllService {

    private final ClienteDao dao;

    public ClienteAllService(ClienteDao dao) {
        this.dao = dao;
    }

    public ListResponse<ClienteDTO> execute(UUID hospitalId, PaginationRequest paginationRequest) {
        var result = dao.getAll(hospitalId, paginationRequest.getPage(), paginationRequest.getRows());
        var data = result.getData().stream().map(ClienteMapper::toDto).toList();
        return new ListResponse<>(data, result.getTotalElements(), result.getTotalPages(), result.getCurrentPage());
    }

}