package com.saludsystem.domain.mantenimiento.port.in.service;

import com.saludsystem.mantenimiento.application.dto.get.MonedaDTO;
import com.saludsystem.mantenimiento.application.dto.post.CrearMonedaDTO;
import com.saludsystem.mantenimiento.application.dto.put.ActualizarMonedaDTO;
import com.saludsystem.shared.application.service.GenericService;

import java.util.UUID;

public interface MonedaService extends GenericService<
        MonedaDTO,
        CrearMonedaDTO,
        ActualizarMonedaDTO,
        UUID> {
}