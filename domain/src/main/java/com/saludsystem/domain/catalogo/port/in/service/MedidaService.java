package com.saludsystem.domain.catalogo.port.in.service;

import com.saludsystem.catalogo.application.dtos.get.MedidaDTO;
import com.saludsystem.catalogo.application.dtos.post.CrearMedidaDTO;
import com.saludsystem.catalogo.application.dtos.put.ActualizarMedidaDTO;
import com.saludsystem.shared.application.service.GenericService;

import java.util.UUID;

public interface MedidaService extends GenericService<
        MedidaDTO,
        CrearMedidaDTO,
        ActualizarMedidaDTO,
        UUID> {
}