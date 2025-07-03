package com.saludsystem.application.services.principal;

import com.saludsystem.application.dtos.principal.get.InformacionClinicaDTO;
import com.saludsystem.application.dtos.principal.post.CrearInformacionClinicaDTO;
import com.saludsystem.application.dtos.principal.put.ActualizarInformacionClinicaDTO;
import com.saludsystem.application.services.GenericService;

import java.util.UUID;

public interface InformacionClinicaService extends GenericService<
        InformacionClinicaDTO,
        UUID,
        CrearInformacionClinicaDTO,
        ActualizarInformacionClinicaDTO> {
}