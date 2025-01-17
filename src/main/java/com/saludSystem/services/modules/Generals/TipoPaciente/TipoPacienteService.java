package com.saludSystem.services.modules.Generals.TipoPaciente;

import com.saludSystem.dtos.Generals.TipoPacienteDTO;
import java.util.List;
import java.util.Optional;

public interface TipoPacienteService {

    List<TipoPacienteDTO> getAllTipoPaciente();

    Optional<TipoPacienteDTO> getTipoPacienteById(int tipoPacienteId);

    void deleteTipoPaciente(int tipoPacienteId);

    TipoPacienteDTO updateTipoPaciente(int tipoPacienteId, TipoPacienteDTO tipoPacienteDTO);

}
