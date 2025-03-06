package com.saludSystem.aplicacion.services.modules.Catalogo.Medida;

import com.saludSystem.aplicacion.dtos.Catalogo.Medida.ActualizarMedidaDTO;
import com.saludSystem.aplicacion.dtos.Catalogo.Medida.CrearMedidaDTO;
import com.saludSystem.aplicacion.dtos.Catalogo.Medida.MedidaDTO;
import com.saludSystem.aplicacion.responses.ApiResponse;
import com.saludSystem.aplicacion.responses.ListResponse;
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