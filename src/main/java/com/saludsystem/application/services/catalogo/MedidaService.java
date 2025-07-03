package com.saludsystem.application.services.catalogo;

import com.saludsystem.application.dtos.catalogo.get.MedidaDTO;
import com.saludsystem.application.dtos.catalogo.post.CrearMedidaDTO;
import com.saludsystem.application.dtos.catalogo.put.ActualizarMedidaDTO;
import com.saludsystem.application.services.GenericService;

import java.util.UUID;

public interface MedidaService extends GenericService<
        MedidaDTO,
        UUID,
        CrearMedidaDTO,
        ActualizarMedidaDTO> {
}