package com.saludsystem.application.services.catalogo;

import com.saludsystem.application.dtos.catalogo.get.ConsentimientoDTO;
import com.saludsystem.application.dtos.catalogo.post.CrearConsentimientoDTO;
import com.saludsystem.application.dtos.catalogo.put.ActualizarConsentimientoDTO;
import com.saludsystem.application.services.GenericService;

import java.util.UUID;

public interface ConsentimientoService extends GenericService<
        ConsentimientoDTO,
        UUID,
        CrearConsentimientoDTO,
        ActualizarConsentimientoDTO> {
}