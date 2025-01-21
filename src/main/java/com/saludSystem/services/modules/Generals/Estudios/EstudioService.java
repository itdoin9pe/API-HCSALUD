package com.saludSystem.services.modules.Generals.Estudios;

import com.saludSystem.dtos.Generals.AseguradoraDTO;
import com.saludSystem.dtos.Generals.EstudioDTO;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface EstudioService {

    EstudioDTO saveEstudio(EstudioDTO estudioDTO);

    List<EstudioDTO> getAllEstudios(UUID hospitalId, int page, int rows);

    Optional<EstudioDTO> getEstudioById(Integer id);

    void deleteEstudio(Integer id);

    EstudioDTO updateEstudio(Integer id, EstudioDTO estudioDTO);

    List<EstudioDTO> getEstudioList();

    long getTotalCount();

}
