package com.saludsystem.application.services.configuracion;

import com.saludsystem.application.dtos.configuracion.get.UsuarioDTO;
import com.saludsystem.application.dtos.configuracion.post.NewUserDto;
import com.saludsystem.application.dtos.configuracion.put.ActualizarUsuarioDTO;
import com.saludsystem.domain.model.configuracion.UserEntity;
import com.saludsystem.infrastructure.adapters.in.response.ApiResponse;
import com.saludsystem.infrastructure.adapters.in.response.ListResponse;

import java.util.UUID;

public interface UsuarioService {

    ListResponse<UsuarioDTO> getAllUsuario(UUID hospitalId, int page, int rows);

    UserEntity saveUsuario(NewUserDto newUserDto);

    ActualizarUsuarioDTO updateUsuario(UUID userI, ActualizarUsuarioDTO actualizarUsuarioDTO);

    ApiResponse deleteUsuario(UUID userId);

}