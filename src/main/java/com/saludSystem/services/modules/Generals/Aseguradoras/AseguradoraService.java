package com.saludSystem.services.modules.Generals.Aseguradoras;

import com.saludSystem.dtos.Generals.AseguradoraDTO;

import java.util.List;
import java.util.Optional;

public interface AseguradoraService {
    AseguradoraDTO saveAseguradora(AseguradoraDTO aseguradoraDTO);

    List<AseguradoraDTO> getAllAseguradoras(int page, int rows);

    List<AseguradoraDTO> getAseguradoraList();

    Optional<AseguradoraDTO> getAseguradoraById(int aseguradoraId);

    AseguradoraDTO updateAseguradora(int aseguradoraId, AseguradoraDTO aseguradoraDTO);

    void deleteAseguradora(int aseguradoraId);

    long getTotalCount();
}
