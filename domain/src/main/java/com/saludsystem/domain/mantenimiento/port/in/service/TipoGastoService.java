package com.saludsystem.domain.mantenimiento.port.in.service;

import com.saludsystem.mantenimiento.application.dto.get.TipoGastoDTO;
import com.saludsystem.mantenimiento.application.dto.post.CrearTipoGastoDTO;
import com.saludsystem.mantenimiento.application.dto.put.ActualizarTipoGastoDTO;
import com.saludsystem.shared.application.service.GenericService;

import java.util.UUID;

public interface TipoGastoService extends GenericService<
        TipoGastoDTO,
        CrearTipoGastoDTO,
        ActualizarTipoGastoDTO,
        UUID> {
}