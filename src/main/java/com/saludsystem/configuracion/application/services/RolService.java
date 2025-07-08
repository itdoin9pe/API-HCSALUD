package com.saludsystem.configuracion.application.services;

import com.saludsystem.configuracion.application.dto.res.RolResponse;
import com.saludsystem.configuracion.application.dto.req.RolRequest;
import com.saludsystem.configuracion.application.dto.res.ActualizarRolDTO;
import com.saludsystem.shared.infrastructure.adapters.in.response.ApiResponse;
import com.saludsystem.shared.infrastructure.adapters.in.response.ListResponse;

import java.util.List;
import java.util.UUID;

public interface RolService {
    ApiResponse saveRole(RolRequest rolRequest);
    ListResponse<RolResponse> getAllRole(UUID hospitalId, int page, int rows);
    List<RolResponse> getRoleList();
    RolResponse getRoleById(UUID roleId);
    ApiResponse updateRole(UUID roleId, ActualizarRolDTO actualizarRolDTO);
    ApiResponse deleteRole(UUID roleId);
}