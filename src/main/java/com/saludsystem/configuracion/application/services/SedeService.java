package com.saludsystem.configuracion.application.services;

import com.saludsystem.configuracion.application.dto.get.SedeDTO;
import com.saludsystem.configuracion.application.dto.post.CrearSedeDTO;
import com.saludsystem.configuracion.application.dto.put.ActualizarSedeDTO;
import com.saludsystem.shared.application.service.GenericService;

import java.util.UUID;

public interface SedeService extends GenericService<
        SedeDTO,
        CrearSedeDTO,
        ActualizarSedeDTO,
        UUID> {
}