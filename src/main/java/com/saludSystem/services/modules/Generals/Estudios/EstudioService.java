package com.saludSystem.services.modules.Generals.Estudios;

import com.saludSystem.dtos.Generals.Estudio.CrearEstudioDTO;
import com.saludSystem.dtos.Generals.Estudio.EstudioDTO;
import com.saludSystem.services.PaginatedService;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface EstudioService extends PaginatedService {

    CrearEstudioDTO saveEstudio(CrearEstudioDTO crearEstudioDTO);

    Optional<EstudioDTO> getEstudioById(Integer id);

    void deleteEstudio(Integer id);

    EstudioDTO updateEstudio(Integer id, EstudioDTO estudioDTO);

    List<EstudioDTO> getEstudioList();

}