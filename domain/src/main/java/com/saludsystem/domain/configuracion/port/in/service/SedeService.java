package com.saludsystem.domain.configuracion.port.in.service;

import com.configuracion.application.dto.get.SedeDTO;
import com.configuracion.application.dto.post.CrearSedeDTO;
import com.configuracion.application.dto.put.ActualizarSedeDTO;
import com.saludsystem.domain.shared.port.in.GenericService;

import java.util.UUID;

public interface SedeService extends GenericService<
        SedeDTO,
        CrearSedeDTO,
        ActualizarSedeDTO,
        UUID> {
}