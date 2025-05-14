package com.saludSystem.application.services.Configuracion;

import com.saludSystem.application.dtos.Configuracion.POST.NewUserDto;
import com.saludSystem.application.dtos.Configuracion.PUT.ActualizarUsuarioDTO;
import com.saludSystem.application.dtos.Configuracion.GET.UsuarioDTO;
import com.saludSystem.domain.model.Configuracion.UserEntity;
import com.saludSystem.infrastructure.adapters.in.response.ApiResponse;
import com.saludSystem.infrastructure.adapters.in.response.ListResponse;

import java.util.UUID;

public interface UsuarioService {

    ListResponse<UsuarioDTO> getAllUsuario(UUID hospitalId, int page, int rows);

    UserEntity saveUsuario(NewUserDto newUserDto);

    ActualizarUsuarioDTO updateUsuario(UUID userI, ActualizarUsuarioDTO actualizarUsuarioDTO);

    ApiResponse deleteUsuario(UUID userId);

}