package com.saludsystem.submodules.configuracion.service;

import com.saludsystem.submodules.configuracion.dtos.get.UsuarioDTO;
import com.saludsystem.submodules.configuracion.mapper.UsuarioMapper;
import com.saludsystem.submodules.configuracion.port.in.dao.UserDao;
import com.saludsystem.submodules.response.ListResponse;
import com.saludsystem.submodules.response.PaginationRequest;

import java.util.UUID;

public class UserAllService {

    private final UserDao userDao;

    public UserAllService(UserDao userDao) {
        this.userDao = userDao;
    }

    public ListResponse<UsuarioDTO> execute(UUID hospitalId, PaginationRequest paginationRequest){

        var result = userDao.getAll(hospitalId, paginationRequest.getPage(), paginationRequest.getRows());

        var data = result.getData().stream()
                .map(UsuarioMapper::toDto)
                .toList();

        return new ListResponse<>(data, result.getTotalElements(), result.getTotalPages(),
                result.getCurrentPage());

    }
}