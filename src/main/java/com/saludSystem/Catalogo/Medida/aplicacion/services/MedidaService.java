package com.saludSystem.Catalogo.Medida.aplicacion.services;

import com.saludSystem.Catalogo.Medida.aplicacion.dtos.ActualizarMedidaDTO;
import com.saludSystem.Catalogo.Medida.aplicacion.dtos.CrearMedidaDTO;
import com.saludSystem.Catalogo.Medida.aplicacion.dtos.MedidaDTO;
import com.saludSystem.Generals.response.ApiResponse;
import com.saludSystem.Generals.response.ListResponse;
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