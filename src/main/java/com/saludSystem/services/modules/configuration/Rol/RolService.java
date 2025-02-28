package com.saludSystem.services.modules.configuration.Rol;

import com.saludSystem.dtos.configuration.Rol.ActualizarRolDTO;
import com.saludSystem.dtos.configuration.Rol.CrearRolDTO;
import com.saludSystem.dtos.configuration.Rol.RolDTO;
import com.saludSystem.dtos.responses.ApiResponse;
import com.saludSystem.dtos.responses.ListResponse;
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