package com.saludsystem.mantenimiento.application.service;

import com.saludsystem.mantenimiento.application.dto.get.TarifarioDTO;
import com.saludsystem.mantenimiento.application.dto.post.CrearTarifarioDTO;
import com.saludsystem.mantenimiento.application.dto.put.ActualizarTarifarioDTO;
import com.saludsystem.shared.application.service.GenericService;

import java.util.UUID;

public interface TarifarioService extends GenericService<
        TarifarioDTO,
        CrearTarifarioDTO,
        ActualizarTarifarioDTO,
        UUID> {
}