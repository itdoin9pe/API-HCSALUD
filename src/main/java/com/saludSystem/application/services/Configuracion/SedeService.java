package com.saludSystem.application.services.Configuracion;

import com.saludSystem.application.dtos.Configuracion.PUT.ActualizarSedeDTO;
import com.saludSystem.application.dtos.Configuracion.POST.CrearSedeDTO;
import com.saludSystem.application.dtos.Configuracion.GET.SedeDTO;
import com.saludSystem.infrastructure.adapters.in.response.ApiResponse;
import com.saludSystem.infrastructure.adapters.in.response.ListResponse;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public interface SedeService  {

    ApiResponse saveSede(CrearSedeDTO crearSedeDTO);

    ListResponse<SedeDTO> getAllEmpresa(UUID hospitalId, int page, int rows);

    SedeDTO getSedeById(UUID sedeId);

    List<SedeDTO> getSedeList();

    ApiResponse updateSede(UUID sedeId, ActualizarSedeDTO actualizarSedeDTO);

    ApiResponse deleteSede(UUID sedeId);

}