package com.saludSystem.application.services.Mantenimiento;

import com.saludSystem.application.services.GenericService;
import com.saludSystem.application.dtos.Mantenimiento.PUT.ActualizarBancoDTO;
import com.saludSystem.application.dtos.Mantenimiento.GET.BancoDTO;
import com.saludSystem.application.dtos.Mantenimiento.POST.CrearBancoDTO;

import java.util.UUID;

public interface BancoService extends GenericService<
        BancoDTO,
        UUID,
        CrearBancoDTO,
        ActualizarBancoDTO> {
}