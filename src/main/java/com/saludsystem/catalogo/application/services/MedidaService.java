package com.saludsystem.catalogo.application.services;

import com.saludsystem.catalogo.application.dtos.res.MedidaDTO;
import com.saludsystem.catalogo.application.dtos.req.CrearMedidaDTO;
import com.saludsystem.shared.application.service.GenericService;

import java.util.UUID;

public interface MedidaService extends GenericService<
        CrearMedidaDTO,
        MedidaDTO,
        UUID> {
}