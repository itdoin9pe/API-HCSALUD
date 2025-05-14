package com.saludSystem.application.services.Catalogo;

import com.saludSystem.application.dtos.Catalogo.PUT.ActualizarClienteDTO;
import com.saludSystem.application.dtos.Catalogo.GET.ClienteDTO;
import com.saludSystem.application.dtos.Catalogo.POST.CrearClienteDTO;
import com.saludSystem.infrastructure.adapters.in.response.ApiResponse;
import com.saludSystem.infrastructure.adapters.in.response.ListResponse;

import java.util.UUID;

public interface ClienteService {

    ApiResponse saveCliente(CrearClienteDTO crearClienteDTO);

    ApiResponse updateCliente(UUID clienteId, ActualizarClienteDTO actualizarClienteDTO);

    ClienteDTO getClienteById(UUID clienteId);

    ApiResponse deleteCliente(UUID clienteId);

    ListResponse<ClienteDTO> getAllCliente(UUID hospitalId, int page, int rows);

}