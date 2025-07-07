package com.saludsystem.operaciones.application.service;

import com.saludsystem.operaciones.application.dto.res.PresentacionDTO;
import com.saludsystem.operaciones.application.dto.req.CrearPresentacionDTO;
import com.saludsystem.shared.application.service.GenericService;

import java.util.UUID;

public interface PresentacionService extends GenericService<
        CrearPresentacionDTO,
        PresentacionDTO,
        UUID> {
}