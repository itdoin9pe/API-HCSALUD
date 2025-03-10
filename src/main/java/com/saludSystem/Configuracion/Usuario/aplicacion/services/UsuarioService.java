package com.saludSystem.Configuracion.Usuario.aplicacion.services;

import com.saludSystem.Configuracion.Usuario.aplicacion.dtos.NewUserDto;
import com.saludSystem.Configuracion.Usuario.aplicacion.dtos.ActualizarUsuarioDTO;
import com.saludSystem.Configuracion.Usuario.aplicacion.dtos.UsuarioDTO;
import com.saludSystem.Configuracion.Usuario.dominio.UserModel;
import com.saludSystem.Generals.response.ApiResponse;
import com.saludSystem.Generals.response.ListResponse;

import java.util.UUID;

public interface UsuarioService {

    ListResponse<UsuarioDTO> getAllUsuario(UUID hospitalId, int page, int rows);

    UserModel saveUsuario(NewUserDto newUserDto);

    ActualizarUsuarioDTO updateUsuario(UUID userI, ActualizarUsuarioDTO actualizarUsuarioDTO);

    ApiResponse deleteUsuario(UUID userId);

}