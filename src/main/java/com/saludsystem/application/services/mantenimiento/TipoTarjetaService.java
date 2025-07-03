package com.saludsystem.application.services.mantenimiento;

import com.saludsystem.application.dtos.mantenimiento.get.TipoTarjetaDTO;
import com.saludsystem.application.dtos.mantenimiento.post.CrearTipoTarjetaDTO;
import com.saludsystem.application.dtos.mantenimiento.put.ActualizarTipoTarjetaDTO;
import com.saludsystem.application.services.GenericService;

import java.util.UUID;

public interface TipoTarjetaService extends GenericService<TipoTarjetaDTO,
        UUID,
        CrearTipoTarjetaDTO,
        ActualizarTipoTarjetaDTO> {
}