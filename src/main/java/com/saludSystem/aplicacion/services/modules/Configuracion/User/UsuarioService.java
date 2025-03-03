package com.saludSystem.aplicacion.services.modules.Configuracion.User;

import com.saludSystem.aplicacion.dtos.Configuracion.User.NewUserDto;
import com.saludSystem.aplicacion.dtos.Configuracion.User.ActualizarUsuarioDTO;
import com.saludSystem.aplicacion.dtos.Configuracion.User.UsuarioDTO;
import com.saludSystem.aplicacion.responses.ApiResponse;
import com.saludSystem.aplicacion.responses.ListResponse;
import com.saludSystem.dominio.entities.Configuracion.User;

import java.util.UUID;

public interface UsuarioService {

    ListResponse<UsuarioDTO> getAllUsuario(UUID hospitalId, int page, int rows);

    User saveUsuario(NewUserDto newUserDto);

    ActualizarUsuarioDTO updateUsuario(UUID userI, ActualizarUsuarioDTO actualizarUsuarioDTO);

    ApiResponse deleteUsuario(UUID userId);

}