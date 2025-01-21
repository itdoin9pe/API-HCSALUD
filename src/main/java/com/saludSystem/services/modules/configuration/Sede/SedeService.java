package com.saludSystem.services.modules.configuration.Sede;

import com.saludSystem.dtos.configuration.SedeDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public interface SedeService {

    SedeDTO saveSede(SedeDTO sedeDTO);

    List<SedeDTO> getAllSede(int page, int rows);

    SedeDTO updateSede(UUID id, SedeDTO sedeDTO);

    void deleteSede(UUID id);

    Optional<SedeDTO> getSedeById(UUID id);

    List<SedeDTO> getSedeList();

    long getTotalCount();

}
