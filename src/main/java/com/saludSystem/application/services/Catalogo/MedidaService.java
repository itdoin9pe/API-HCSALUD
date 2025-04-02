package com.saludSystem.application.services.Catalogo;

import com.saludSystem.application.dtos.Catalogo.PUT.ActualizarMedidaDTO;
import com.saludSystem.application.dtos.Catalogo.POST.CrearMedidaDTO;
import com.saludSystem.application.dtos.Catalogo.GET.MedidaDTO;
import com.saludSystem.infrastructure.adapters.in.response.ApiResponse;
import com.saludSystem.infrastructure.adapters.in.response.ListResponse;
import java.util.List;
import java.util.UUID;

public interface MedidaService {

    ApiResponse saveMedida(CrearMedidaDTO crearMedidaDTO);

    List<MedidaDTO> getMedidaList();

    MedidaDTO getMedidaById(UUID medidaId);

    ApiResponse updateMedida(UUID medidaId, ActualizarMedidaDTO actualizarMedidaDTO);

    ApiResponse deleteMedida(UUID medidaId);

    ListResponse<MedidaDTO> getAllMedida(UUID hospitalId, int page, int rows);

}