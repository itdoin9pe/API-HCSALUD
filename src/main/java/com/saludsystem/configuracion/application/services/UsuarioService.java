package com.saludsystem.configuracion.application.services;

import com.saludsystem.configuracion.application.dto.get.UsuarioDTO;
import com.saludsystem.configuracion.application.dto.post.NewUserDto;
import com.saludsystem.configuracion.application.dto.put.ActualizarUsuarioDTO;
import com.saludsystem.configuracion.domain.model.UserEntity;
import com.saludsystem.shared.infrastructure.adapters.in.response.ApiResponse;
import com.saludsystem.shared.infrastructure.adapters.in.response.ListResponse;

import java.util.UUID;

public interface UsuarioService {

    ListResponse<UsuarioDTO> getAllUsuario(UUID hospitalId, int page, int rows);

    UserEntity saveUsuario(NewUserDto newUserDto);

    ActualizarUsuarioDTO updateUsuario(UUID userI, ActualizarUsuarioDTO actualizarUsuarioDTO);

    ApiResponse deleteUsuario(UUID userId);

}