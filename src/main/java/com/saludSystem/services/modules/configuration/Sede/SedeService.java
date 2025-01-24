package com.saludSystem.services.modules.configuration.Sede;

import com.saludSystem.dtos.configuration.Sede.CrearSedeDTO;
import com.saludSystem.dtos.configuration.Sede.SedeDTO;
import com.saludSystem.services.PaginatedService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public interface SedeService extends PaginatedService {

    CrearSedeDTO saveSede(CrearSedeDTO crearSedeDTO);

    SedeDTO updateSede(UUID id, SedeDTO sedeDTO);

    void deleteSede(UUID id);

    Optional<SedeDTO> getSedeById(UUID id);

    List<SedeDTO> getSedeList();

}
