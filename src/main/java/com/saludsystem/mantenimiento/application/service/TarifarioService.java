package com.saludsystem.mantenimiento.application.service;

import com.saludsystem.mantenimiento.application.dto.res.TarifarioDTO;
import com.saludsystem.mantenimiento.application.dto.req.CrearTarifarioDTO;
import com.saludsystem.shared.application.service.GenericService;

import java.util.UUID;

public interface TarifarioService extends GenericService<
        CrearTarifarioDTO,
        TarifarioDTO,
        UUID> {
}