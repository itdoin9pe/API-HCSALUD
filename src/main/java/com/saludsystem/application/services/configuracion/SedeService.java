package com.saludsystem.application.services.configuracion;

import com.saludsystem.application.dtos.configuracion.get.SedeDTO;
import com.saludsystem.application.dtos.configuracion.post.CrearSedeDTO;
import com.saludsystem.application.services.GenericService;

import java.util.UUID;

public interface SedeService extends GenericService<
        CrearSedeDTO,
        SedeDTO,
        UUID> {
}