package com.saludsystem.domain.configuracion.port.in.service;


import com.configuracion.application.dto.get.UsuarioDTO;
import com.configuracion.application.dto.post.NewUserDto;
import com.configuracion.application.dto.put.ActualizarUsuarioDTO;
import com.configuracion.domain.model.UserEntity;
import com.shared.infrastructure.adapters.in.response.ApiResponse;
import com.shared.infrastructure.adapters.in.response.ListResponse;

import java.util.UUID;

public interface UsuarioService {

    ListResponse<UsuarioDTO> getAllUsuario(UUID hospitalId, int page, int rows);

    UserEntity saveUsuario(NewUserDto newUserDto);

    ActualizarUsuarioDTO updateUsuario(UUID userI, ActualizarUsuarioDTO actualizarUsuarioDTO);

    ApiResponse deleteUsuario(UUID userId);

}