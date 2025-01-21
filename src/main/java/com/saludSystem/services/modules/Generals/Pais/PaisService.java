package com.saludSystem.services.modules.Generals.Pais;

import com.saludSystem.dtos.Generals.PaisDTO;
import java.util.List;


public interface PaisService {

    PaisDTO savePais(PaisDTO paisDTO);

    List<PaisDTO> getAllPais(int page, int rows);

    List<PaisDTO> getPaisList();

    long getTotalCount();
}