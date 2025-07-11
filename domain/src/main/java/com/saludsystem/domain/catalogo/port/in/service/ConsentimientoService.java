package com.saludsystem.domain.catalogo.port.in.service;

import com.saludsystem.catalogo.application.dtos.get.ConsentimientoDTO;
import com.saludsystem.catalogo.application.dtos.post.CrearConsentimientoDTO;
import com.saludsystem.catalogo.application.dtos.put.ActualizarConsentimientoDTO;
import com.saludsystem.shared.application.service.GenericService;

import java.util.UUID;

public interface ConsentimientoService extends GenericService<
        ConsentimientoDTO,
        CrearConsentimientoDTO,
        ActualizarConsentimientoDTO,
        UUID> {
}