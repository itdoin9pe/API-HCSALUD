package com.saludsystem.application.services.principal;

import com.saludsystem.application.dtos.principal.get.TipoPacienteDTO;
import java.util.List;

public interface TipoPacienteService {

    List<TipoPacienteDTO> getTipoPacienteList();

}