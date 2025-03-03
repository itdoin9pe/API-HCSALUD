package com.saludSystem.aplicacion.services.modules.Configuracion.Rol;

import com.saludSystem.aplicacion.dtos.Configuracion.Rol.ActualizarRolDTO;
import com.saludSystem.aplicacion.dtos.Configuracion.Rol.CrearRolDTO;
import com.saludSystem.aplicacion.dtos.Configuracion.Rol.RolDTO;
import com.saludSystem.aplicacion.dtos.responses.ApiResponse;
import com.saludSystem.aplicacion.dtos.responses.ListResponse;
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