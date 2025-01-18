package com.saludSystem.services.modules.Generals.Aseguradoras;

import com.saludSystem.dtos.Generals.AseguradoraDTO;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface AseguradoraService {
    AseguradoraDTO saveAseguradora(AseguradoraDTO aseguradoraDTO);

    List<AseguradoraDTO> getAllAseguradoras(int page, int rows);

    List<AseguradoraDTO> getAseguradoraList();

    Optional<AseguradoraDTO> getAseguradoraById(UUID aseguradoraId);

    AseguradoraDTO updateAseguradora(UUID aseguradoraId, AseguradoraDTO aseguradoraDTO);

    void deleteAseguradora(UUID aseguradoraId);

    long getTotalCount();
}