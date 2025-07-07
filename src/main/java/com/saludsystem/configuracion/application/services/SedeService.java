package com.saludsystem.configuracion.application.services;

import com.saludsystem.configuracion.application.dto.req.SedeDTO;
import com.saludsystem.configuracion.application.dto.res.CrearSedeDTO;
import com.saludsystem.shared.application.service.GenericService;

import java.util.UUID;

public interface SedeService extends GenericService<
        CrearSedeDTO,
        SedeDTO,
        UUID> {
}