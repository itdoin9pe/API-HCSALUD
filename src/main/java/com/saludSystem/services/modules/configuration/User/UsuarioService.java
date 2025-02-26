package com.saludSystem.services.modules.configuration.User;

import com.saludSystem.dtos.configuration.User.NewUserDto;
import com.saludSystem.dtos.configuration.User.ActualizarUsuarioDTO;
import com.saludSystem.dtos.configuration.User.UsuarioDTO;
import com.saludSystem.dtos.responses.ApiResponse;
import com.saludSystem.dtos.responses.ListResponse;
import com.saludSystem.entities.User;

import java.util.UUID;

public interface UsuarioService {
    ListResponse<UsuarioDTO> getAllUsuario(UUID hospitalId, int page, int rows);

    User saveUsuario(NewUserDto newUserDto);

    ActualizarUsuarioDTO updateUsuario(UUID userI, ActualizarUsuarioDTO actualizarUsuarioDTO);

    ApiResponse deleteUsuario(UUID userId);
}