package com.saludsystem.domain.operaciones.port.in.service;

import com.saludsystem.operaciones.application.dto.get.PresentacionDTO;
import com.saludsystem.operaciones.application.dto.post.CrearPresentacionDTO;
import com.saludsystem.operaciones.application.dto.put.ActualizarPresentacionDTO;
import com.saludsystem.shared.application.service.GenericService;

import java.util.UUID;

public interface PresentacionService extends GenericService<
        PresentacionDTO,
        CrearPresentacionDTO,
        ActualizarPresentacionDTO,
        UUID> {
}