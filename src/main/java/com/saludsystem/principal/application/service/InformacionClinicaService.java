package com.saludsystem.principal.application.service;

import com.saludsystem.principal.application.dto.res.InformacionClinicaDTO;
import com.saludsystem.principal.application.dto.req.CrearInformacionClinicaDTO;
import com.saludsystem.shared.application.service.GenericService;

import java.util.UUID;

public interface InformacionClinicaService extends GenericService<
        CrearInformacionClinicaDTO,
        InformacionClinicaDTO,
        UUID> {
}