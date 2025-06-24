package com.saludSystem.application.services.Mantenimiento;

import com.saludSystem.application.services.GenericService;
import com.saludSystem.application.dtos.Mantenimiento.PUT.ActualizarCuentaDTO;
import com.saludSystem.application.dtos.Mantenimiento.POST.CrearCuentaDTO;
import com.saludSystem.application.dtos.Mantenimiento.GET.CuentaDTO;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public interface CuentaService extends GenericService<
        CuentaDTO,
        UUID,
        CrearCuentaDTO,
        ActualizarCuentaDTO> {
}