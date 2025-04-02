package com.saludSystem.application.services.Principal;

import com.saludSystem.application.dtos.Principal.GET.TipoPacienteDTO;
import java.util.List;

public interface TipoPacienteService {

    List<TipoPacienteDTO> getTipoPacienteList();

}