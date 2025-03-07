package com.saludSystem.aplicacion.services.modules.Catalogo.Alergia;

import com.saludSystem.aplicacion.dtos.Catalogo.Alergias.ActualizarAlergiaDTO;
import com.saludSystem.aplicacion.dtos.Catalogo.Alergias.AlergiaDTO;
import com.saludSystem.aplicacion.dtos.Catalogo.Alergias.CrearAlergiaDTO;
import com.saludSystem.aplicacion.responses.ApiResponse;
import com.saludSystem.aplicacion.responses.ListResponse;

import java.util.List;
import java.util.UUID;

public interface AlergiaService {

    ApiResponse saveAlergia(CrearAlergiaDTO crearAlergiaDTO);

    List<AlergiaDTO> getAlergiaList();

    ApiResponse deleteAlergia(UUID alergiaId);

    ApiResponse updateAlergia(UUID alergiaId, ActualizarAlergiaDTO actualizarAlergiaDTO);

    AlergiaDTO getAlergiaById(UUID alergiaId);

    ListResponse<AlergiaDTO> getAllAlergia(UUID hospitalId, int page, int rows);

}