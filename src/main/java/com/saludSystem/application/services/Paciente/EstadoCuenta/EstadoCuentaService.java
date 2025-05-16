package com.saludSystem.application.services.Paciente.EstadoCuenta;

import com.saludSystem.application.dtos.Paciente.GET.EstadoCuenta.EstadoCuentaDTO;
import com.saludSystem.application.dtos.Paciente.POST.EstadoCuenta.CrearEstadoCuentaDTO;
import com.saludSystem.application.dtos.Paciente.PUT.EstadoCuenta.ActualizarEstadoCuentaDTO;
import com.saludSystem.infrastructure.adapters.in.response.ApiResponse;
import com.saludSystem.infrastructure.adapters.in.response.ListResponse;

import java.util.UUID;

public interface EstadoCuentaService {

    ApiResponse saveEstadoCuenta(CrearEstadoCuentaDTO crearEstadoCuentaDTO);

    ListResponse<EstadoCuentaDTO> getAllEstadoCuenta(UUID hospitalId, int page, int rows);

    ApiResponse updateEstadoCuenta(UUID pacienteEstadoCuentaId, ActualizarEstadoCuentaDTO actualizarEstadoCuentaDTO);

    EstadoCuentaDTO getEstadoCuentaById(UUID pacienteEstadoCuentaId);

    ApiResponse deleteEstadoCuenta(UUID pacienteEstadoCuentaId);

}