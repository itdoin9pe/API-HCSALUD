package com.saludSystem.services.modules.Generals.Estudios;

import com.saludSystem.dtos.Generals.EstudioDTO;
import java.util.List;
import java.util.Optional;

public interface EstudioService {

    EstudioDTO saveEstudio(EstudioDTO estudioDTO);

    List<EstudioDTO> getAllEstudios();

    Optional<EstudioDTO> getEstudioById(int id);

    void deleteEstudio(int id);

    EstudioDTO updateEstudio(int id, EstudioDTO estudioDTO);

}
