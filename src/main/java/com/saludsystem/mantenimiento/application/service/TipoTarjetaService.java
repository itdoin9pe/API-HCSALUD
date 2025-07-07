package com.saludsystem.mantenimiento.application.service;

import com.saludsystem.mantenimiento.application.dto.res.TipoTarjetaDTO;
import com.saludsystem.mantenimiento.application.dto.req.CrearTipoTarjetaDTO;
import com.saludsystem.shared.application.service.GenericService;

import java.util.UUID;

public interface TipoTarjetaService extends GenericService<
        CrearTipoTarjetaDTO,
        TipoTarjetaDTO,
        UUID> {
}