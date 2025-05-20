package com.saludSystem.application.services.Catalogo;

import com.saludSystem.application.dtos.Catalogo.GET.MedicamentoDTO;
import com.saludSystem.application.dtos.Catalogo.POST.CrearMedicamentoDTO;
import com.saludSystem.application.dtos.Catalogo.PUT.ActualizarMedicamentoDTO;
import com.saludSystem.infrastructure.adapters.in.response.ApiResponse;
import com.saludSystem.infrastructure.adapters.in.response.ListResponse;

import java.util.List;
import java.util.UUID;

public interface MedicamentoService {

    ApiResponse saveMedicamento(CrearMedicamentoDTO crearMedicamentoDTO);

    List<MedicamentoDTO> getMedicamentoList();

    MedicamentoDTO getMedicamentoById(UUID medicamentoId);

    ApiResponse updateMedicamento(UUID medicamentoId, ActualizarMedicamentoDTO actualizarMedicamentoDTO);

    ListResponse<MedicamentoDTO> getAllMedicamento(UUID hospitalId, int page, int rows);

    ApiResponse deleteMedicamento(UUID medicamentoId);

}