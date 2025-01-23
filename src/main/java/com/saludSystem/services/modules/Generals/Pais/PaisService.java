package com.saludSystem.services.modules.Generals.Pais;

import com.saludSystem.dtos.Generals.Pais.CrearPaisDTO;
import com.saludSystem.dtos.Generals.Pais.PaisDTO;
import java.util.List;


public interface PaisService {

    CrearPaisDTO savePais(CrearPaisDTO crearPaisDTO);

    List<PaisDTO> getAllPais(int page, int rows);

    List<PaisDTO> getPaisList();

    long getTotalCount();
}