package com.saludsystem.mantenimiento.application.service;

import com.saludsystem.mantenimiento.application.dto.res.TipoGastoDTO;
import com.saludsystem.mantenimiento.application.dto.req.CrearTipoGastoDTO;
import com.saludsystem.shared.application.service.GenericService;

import java.util.UUID;

public interface TipoGastoService extends GenericService<
        CrearTipoGastoDTO,
        TipoGastoDTO,
        UUID> {
}