package com.saludSystem.application.services.Paciente.Tratamiento;

import com.saludSystem.application.dtos.Paciente.GET.Tratamiento.CostoTratamientoDTO;
import com.saludSystem.application.dtos.Paciente.POST.Tratamiento.CrearCostoTratamientoDTO;
import com.saludSystem.application.dtos.Paciente.PUT.Tratamiento.ActualizarCostoTratamientoDTO;
import com.saludSystem.application.services.GenericService;

import java.util.UUID;

public interface CostoTratamientoService extends GenericService<
        CostoTratamientoDTO,
        UUID,
        CrearCostoTratamientoDTO,
        ActualizarCostoTratamientoDTO> {
}