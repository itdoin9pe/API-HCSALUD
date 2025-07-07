package com.saludsystem.mantenimiento.application.service;

import com.saludsystem.mantenimiento.application.dto.res.CajaDTO;
import com.saludsystem.mantenimiento.application.dto.req.CrearCajaDTO;
import com.saludsystem.shared.application.service.GenericService;

import java.util.UUID;

public interface CajaService extends GenericService<
        CrearCajaDTO,
        CajaDTO,
        UUID> {
}