package com.saludsystem.domain.principal.port.out.service;

import com.saludsystem.application.dto.get.InformacionClinicaDTO;
import com.saludsystem.application.dto.post.CrearInformacionClinicaDTO;
import com.saludsystem.application.dto.put.ActualizarInformacionClinicaDTO;
import com.configuracion.application.services.GenericService;

import java.util.UUID;

public interface InformacionClinicaService extends GenericService<
        InformacionClinicaDTO,
        CrearInformacionClinicaDTO,
        ActualizarInformacionClinicaDTO,
        UUID> {
}