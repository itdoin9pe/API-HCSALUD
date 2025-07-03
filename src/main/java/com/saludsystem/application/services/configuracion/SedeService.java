package com.saludsystem.application.services.configuracion;

import com.saludsystem.application.dtos.configuracion.get.SedeDTO;
import com.saludsystem.application.dtos.configuracion.post.CrearSedeDTO;
import com.saludsystem.application.dtos.configuracion.put.ActualizarSedeDTO;
import com.saludsystem.application.services.GenericService;
import org.springframework.stereotype.Service;

import java.util.UUID;


@Service
public interface SedeService extends GenericService<
        SedeDTO,
        UUID,
        CrearSedeDTO,
        ActualizarSedeDTO> {
}