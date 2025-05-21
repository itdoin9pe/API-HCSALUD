package com.saludSystem.application.services.Paciente;

import com.saludSystem.application.dtos.Paciente.GET.MedicamentoRecetadoDTO;
import com.saludSystem.application.dtos.Paciente.POST.CrearMedicamentoRecetadoDTO;
import com.saludSystem.application.dtos.Paciente.PUT.ActualizarMedicamentoRecetadoDTO;
import com.saludSystem.infrastructure.adapters.in.response.ApiResponse;
import com.saludSystem.infrastructure.adapters.in.response.ListResponse;
import java.util.UUID;

public interface MedicamentoRecetadoService {

    ApiResponse saveMedicamentoRecetado(CrearMedicamentoRecetadoDTO crearMedicamentoRecetadoDTO);

    ListResponse<MedicamentoRecetadoDTO> getAllMedicamentoRecetado(UUID hospitalId, int page, int rows);

    ApiResponse updateMedicamentoRecetado(UUID medicamentoRecetadoId, ActualizarMedicamentoRecetadoDTO actualizarMedicamentoRecetadoDTO);

    MedicamentoRecetadoDTO getMedicamentoRecetadoById(UUID medicamentoRecetadoId);

    ApiResponse deleteMedicamentoRecetado(UUID medicamentoRecetadoId);

}