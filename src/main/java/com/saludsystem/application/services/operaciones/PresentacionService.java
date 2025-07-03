package com.saludsystem.application.services.operaciones;

import com.saludsystem.application.dtos.operaciones.get.PresentacionDTO;
import com.saludsystem.application.dtos.operaciones.post.CrearPresentacionDTO;
import com.saludsystem.application.dtos.operaciones.put.ActualizarPresentacionDTO;
import com.saludsystem.application.services.GenericService;

import java.util.UUID;

public interface PresentacionService extends GenericService<
        PresentacionDTO,
        UUID,
        CrearPresentacionDTO,
        ActualizarPresentacionDTO> {
}