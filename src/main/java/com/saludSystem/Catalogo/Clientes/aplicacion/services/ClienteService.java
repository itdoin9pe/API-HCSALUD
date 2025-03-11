package com.saludSystem.Catalogo.Clientes.aplicacion.services;

import com.saludSystem.Catalogo.Clientes.aplicacion.dtos.ActualizarClienteDTO;
import com.saludSystem.Catalogo.Clientes.aplicacion.dtos.ClienteDTO;
import com.saludSystem.Catalogo.Clientes.aplicacion.dtos.CrearClienteDTO;
import com.saludSystem.Generals.response.ApiResponse;
import com.saludSystem.Generals.response.ListResponse;

import java.util.UUID;

public interface ClienteService {

    ApiResponse saveCliente(CrearClienteDTO crearClienteDTO);

    ApiResponse updateCliente(UUID clienteId, ActualizarClienteDTO actualizarClienteDTO);

    ClienteDTO getClienteById(UUID clienteId);

    ApiResponse deleteCliente(UUID clienteId);

    ListResponse<ClienteDTO> getAllCliente(UUID hospitalId, int page, int rows);

}