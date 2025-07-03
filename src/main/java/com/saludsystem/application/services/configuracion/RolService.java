package com.saludsystem.application.services.configuracion;

import com.saludsystem.application.dtos.configuracion.get.RolDTO;
import com.saludsystem.application.dtos.configuracion.post.CrearRolDTO;
import com.saludsystem.application.dtos.configuracion.put.ActualizarRolDTO;
import com.saludsystem.infrastructure.adapters.in.response.ApiResponse;
import com.saludsystem.infrastructure.adapters.in.response.ListResponse;

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