package com.saludSystem.services.modules.Generals.Aseguradoras;

import com.saludSystem.dtos.Generals.Aseguradora.AseguradoraDTO;
import com.saludSystem.dtos.Generals.Aseguradora.CrearAseguradoraDTO;
import com.saludSystem.services.PaginatedService;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface AseguradoraService extends PaginatedService {

    CrearAseguradoraDTO saveAseguradora(CrearAseguradoraDTO crearAseguradoraDTO);

    List<AseguradoraDTO> getAseguradoraList();

    Optional<AseguradoraDTO> getAseguradoraById(UUID aseguradoraId);

    AseguradoraDTO updateAseguradora(UUID aseguradoraId, AseguradoraDTO aseguradoraDTO);

    void deleteAseguradora(UUID aseguradoraId);

}