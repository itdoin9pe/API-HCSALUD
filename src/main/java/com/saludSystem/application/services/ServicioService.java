package com.saludSystem.application.services;

import com.saludSystem.application.dtos.Principal.GET.ServicioDTO;
import com.saludSystem.application.dtos.Principal.POST.CrearServicioDTO;
import com.saludSystem.application.dtos.Principal.PUT.ActualizarServicioDTO;
import com.saludSystem.infrastructure.adapters.in.response.ApiResponse;

import java.util.List;

public interface ServicioService {
    List<ServicioDTO> listarTodos();
    ApiResponse guardar(CrearServicioDTO crearServicioDTO);
    ServicioDTO buscarPorId(Long id);
    ApiResponse updateServicio(Long id, ActualizarServicioDTO actualizarServicioDTO);
    ApiResponse eliminar(Long id);
}