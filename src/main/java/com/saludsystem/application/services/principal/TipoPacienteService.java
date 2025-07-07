package com.saludsystem.application.services.principal;

import com.saludsystem.application.dtos.principal.res.TipoPacienteDTO;
import java.util.List;

public interface TipoPacienteService {

    List<TipoPacienteDTO> getTipoPacienteList();

}