package com.saludSystem.application.services.Paciente;

import com.saludSystem.application.dtos.Paciente.GET.MedicamentoRecetadoDTO;
import com.saludSystem.application.dtos.Paciente.POST.CrearMedicamentoRecetadoDTO;
import com.saludSystem.application.dtos.Paciente.PUT.ActualizarMedicamentoRecetadoDTO;
import com.saludSystem.application.services.GenericService;

import java.util.UUID;

public interface MedicamentoRecetadoService extends GenericService<
        MedicamentoRecetadoDTO,
        UUID,
        CrearMedicamentoRecetadoDTO,
        ActualizarMedicamentoRecetadoDTO> {
}