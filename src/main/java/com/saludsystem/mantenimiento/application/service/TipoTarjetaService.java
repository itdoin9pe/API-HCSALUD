package com.saludsystem.mantenimiento.application.service;

import com.saludsystem.mantenimiento.application.dto.get.TipoTarjetaDTO;
import com.saludsystem.mantenimiento.application.dto.post.CrearTipoTarjetaDTO;
import com.saludsystem.mantenimiento.application.dto.put.ActualizarTipoTarjetaDTO;
import com.saludsystem.shared.application.service.GenericService;

import java.util.UUID;

public interface TipoTarjetaService extends GenericService<
        TipoTarjetaDTO,
        CrearTipoTarjetaDTO,
        ActualizarTipoTarjetaDTO,
        UUID> {
}