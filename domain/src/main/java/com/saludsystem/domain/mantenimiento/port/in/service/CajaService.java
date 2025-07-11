package com.saludsystem.domain.mantenimiento.port.in.service;

import com.saludsystem.mantenimiento.application.dto.get.CajaDTO;
import com.saludsystem.mantenimiento.application.dto.post.CrearCajaDTO;
import com.saludsystem.mantenimiento.application.dto.put.ActualizarCajaDTO;
import com.saludsystem.shared.application.service.GenericService;

import java.util.UUID;

public interface CajaService extends GenericService<
        CajaDTO,
        CrearCajaDTO,
        ActualizarCajaDTO,
        UUID> {
}