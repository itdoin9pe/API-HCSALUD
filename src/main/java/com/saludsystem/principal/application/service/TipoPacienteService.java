package com.saludsystem.principal.application.service;

import com.saludsystem.principal.application.dto.res.TipoPacienteResponse;
import java.util.List;

public interface TipoPacienteService {

    List<TipoPacienteResponse> getTipoPacienteList();

}