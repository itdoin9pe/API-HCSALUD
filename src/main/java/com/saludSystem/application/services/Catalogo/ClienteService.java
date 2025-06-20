package com.saludSystem.application.services.Catalogo;

import com.saludSystem.application.dtos.Catalogo.GET.ClienteDTO;
import com.saludSystem.application.dtos.Catalogo.POST.CrearClienteDTO;
import com.saludSystem.application.dtos.Catalogo.PUT.ActualizarClienteDTO;
import com.saludSystem.application.services.GenericService;

import java.util.UUID;

public interface ClienteService extends GenericService<
        ClienteDTO,
        UUID,
        CrearClienteDTO,
        ActualizarClienteDTO> {
}