package com.saludsystem.configuracion.application.services;

import com.saludsystem.configuracion.application.dto.get.RolDTO;
import com.saludsystem.configuracion.application.dto.post.CrearRolDTO;
import com.saludsystem.configuracion.application.dto.put.ActualizarRolDTO;
import com.saludsystem.shared.infrastructure.adapters.in.response.ApiResponse;
import com.saludsystem.shared.infrastructure.adapters.in.response.ListResponse;

import java.util.List;
import java.util.UUID;

public interface RolService {
    ApiResponse saveRole(CrearRolDTO crearRolDTO);
    ListResponse<RolDTO> getAllRole(UUID hospitalId, int page, int rows);
    List<RolDTO> getRoleList();
    RolDTO getRoleById(UUID roleId);
    ApiResponse updateRole(UUID roleId, ActualizarRolDTO actualizarRolDTO);
    ApiResponse deleteRole(UUID roleId);
}