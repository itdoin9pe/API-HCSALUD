package com.saludsystem.application.services.mantenimiento;

import com.saludsystem.application.dtos.mantenimiento.get.TipoGastoDTO;
import com.saludsystem.application.dtos.mantenimiento.post.CrearTipoGastoDTO;
import com.saludsystem.application.services.GenericService;

import java.util.UUID;

public interface TipoGastoService extends GenericService<
        CrearTipoGastoDTO,
        TipoGastoDTO,
        UUID> {
}