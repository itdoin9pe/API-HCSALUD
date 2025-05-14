package com.saludSystem.application.services.Configuracion;

import com.saludSystem.application.dtos.Configuracion.PUT.ActualizarRolDTO;
import com.saludSystem.application.dtos.Configuracion.POST.CrearRolDTO;
import com.saludSystem.application.dtos.Configuracion.GET.RolDTO;
import com.saludSystem.infrastructure.adapters.in.response.ApiResponse;
import com.saludSystem.infrastructure.adapters.in.response.ListResponse;
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