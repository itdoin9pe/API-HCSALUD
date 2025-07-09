package com.saludsystem.principal.application.service;

import com.saludsystem.principal.application.dto.get.InformacionClinicaDTO;
import com.saludsystem.principal.application.dto.post.CrearInformacionClinicaDTO;
import com.saludsystem.principal.application.dto.put.ActualizarInformacionClinicaDTO;
import com.saludsystem.shared.application.service.GenericService;

import java.util.UUID;

public interface InformacionClinicaService extends GenericService<
        InformacionClinicaDTO,
        CrearInformacionClinicaDTO,
        ActualizarInformacionClinicaDTO,
        UUID> {
}