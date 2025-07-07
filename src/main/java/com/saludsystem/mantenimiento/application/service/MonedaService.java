package com.saludsystem.mantenimiento.application.service;

import com.saludsystem.mantenimiento.application.dto.res.MonedaDTO;
import com.saludsystem.mantenimiento.application.dto.req.CrearMonedaDTO;
import com.saludsystem.shared.application.service.GenericService;

import java.util.UUID;

public interface MonedaService extends GenericService<
        CrearMonedaDTO,
        MonedaDTO,
        UUID> {
}