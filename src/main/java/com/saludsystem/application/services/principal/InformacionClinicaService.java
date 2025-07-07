package com.saludsystem.application.services.principal;

import com.saludsystem.application.dtos.principal.res.InformacionClinicaDTO;
import com.saludsystem.application.dtos.principal.req.CrearInformacionClinicaDTO;
import com.saludsystem.application.services.GenericService;

import java.util.UUID;

public interface InformacionClinicaService extends GenericService<
        CrearInformacionClinicaDTO,
        InformacionClinicaDTO,
        UUID> {
}