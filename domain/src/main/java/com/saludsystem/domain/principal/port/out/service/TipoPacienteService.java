package com.saludsystem.domain.principal.port.out.service;

import com.saludsystem.application.dto.get.TipoPacienteDTO;

import java.util.List;

public interface TipoPacienteService {

    List<TipoPacienteDTO> getTipoPacienteList();

}