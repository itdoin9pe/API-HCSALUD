package com.saludSystem.services.modules.Generals.Pais;

import com.saludSystem.dtos.Generals.PaisDTO;
import java.util.List;


public interface PaisService {

    PaisDTO savePais(PaisDTO paisDTO);

    List<PaisDTO> getAllPais();

    List<String> getPaisList();

}