package com.saludSystem.application.services.Principal;

import com.saludSystem.application.dtos.Principal.PUT.ActualizarInformacionClinicaDTO;
import com.saludSystem.application.dtos.Principal.POST.CrearInformacionClinicaDTO;
import com.saludSystem.application.dtos.Principal.GET.InformacionClinicaDTO;
import com.saludSystem.application.services.GenericService;

import java.util.UUID;

public interface InformacionClinicaService extends GenericService<
        InformacionClinicaDTO,
        UUID,
        CrearInformacionClinicaDTO,
        ActualizarInformacionClinicaDTO> {
}