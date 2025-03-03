package com.saludSystem.application.services.modules.Configuracion.User;

import com.saludSystem.application.dtos.Configuracion.User.NewUserDto;
import com.saludSystem.application.dtos.Configuracion.User.ActualizarUsuarioDTO;
import com.saludSystem.application.dtos.Configuracion.User.UsuarioDTO;
import com.saludSystem.application.dtos.responses.ApiResponse;
import com.saludSystem.application.dtos.responses.ListResponse;
import com.saludSystem.domain.entities.Configuracion.User;

import java.util.UUID;

public interface UsuarioService {

    ListResponse<UsuarioDTO> getAllUsuario(UUID hospitalId, int page, int rows);

    User saveUsuario(NewUserDto newUserDto);

    ActualizarUsuarioDTO updateUsuario(UUID userI, ActualizarUsuarioDTO actualizarUsuarioDTO);

    ApiResponse deleteUsuario(UUID userId);

}