package com.saludSystem.application.services.Catalogo;

import com.saludSystem.application.dtos.Catalogo.GET.MedicamentoDTO;
import com.saludSystem.application.dtos.Catalogo.POST.CrearMedicamentoDTO;
import com.saludSystem.application.dtos.Catalogo.PUT.ActualizarMedicamentoDTO;
import com.saludSystem.application.services.GenericService;

import java.util.UUID;

public interface MedicamentoService extends GenericService<
        MedicamentoDTO,
        UUID,
        CrearMedicamentoDTO,
        ActualizarMedicamentoDTO> {
}