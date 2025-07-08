package com.saludsystem.configuracion.application.services;

import com.saludsystem.configuracion.application.dto.res.UsuarioResponse;
import com.saludsystem.configuracion.application.dto.req.NewUserDto;
import com.saludsystem.configuracion.application.dto.res.ActualizarUsuarioDTO;
import com.saludsystem.configuracion.domain.model.UserEntity;
import com.saludsystem.shared.infrastructure.adapters.in.response.ApiResponse;
import com.saludsystem.shared.infrastructure.adapters.in.response.ListResponse;

import java.util.UUID;

public interface UsuarioService {

    ListResponse<UsuarioResponse> getAllUsuario(UUID hospitalId, int page, int rows);

    UserEntity saveUsuario(NewUserDto newUserDto);

    ActualizarUsuarioDTO updateUsuario(UUID userI, ActualizarUsuarioDTO actualizarUsuarioDTO);

    ApiResponse deleteUsuario(UUID userId);

}