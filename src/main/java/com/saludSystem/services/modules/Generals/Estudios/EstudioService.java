package com.saludSystem.services.modules.Generals.Estudios;

import com.saludSystem.dtos.Generals.Estudio.ActualizarEstudioDTO;
import com.saludSystem.dtos.Generals.Estudio.CrearEstudioDTO;
import com.saludSystem.dtos.Generals.Estudio.EstudioDTO;
import com.saludSystem.services.PaginatedService;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface EstudioService extends PaginatedService {

    CrearEstudioDTO saveEstudio(CrearEstudioDTO crearEstudioDTO);

    Optional<EstudioDTO> getEstudioById(UUID estudioId);

    void deleteEstudio(UUID estudioId);

    ActualizarEstudioDTO updateEstudio(UUID estudioId, ActualizarEstudioDTO actualizarEstudioDTO);

    List<EstudioDTO> getEstudioList();

}