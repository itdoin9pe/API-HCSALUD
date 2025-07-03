package com.saludsystem.application.services.mantenimiento;

import com.saludsystem.application.dtos.mantenimiento.get.TarifarioDTO;
import com.saludsystem.application.dtos.mantenimiento.post.CrearTarifarioDTO;
import com.saludsystem.application.dtos.mantenimiento.put.ActualizarTarifarioDTO;
import com.saludsystem.application.services.GenericService;

import java.util.UUID;

public interface TarifarioService extends GenericService<
        TarifarioDTO,
        UUID,
        CrearTarifarioDTO,
        ActualizarTarifarioDTO> {
}