package com.saludSystem.services.modules.configuration.Sede;

import com.saludSystem.dtos.configuration.Sede.ActualizarSedeDTO;
import com.saludSystem.dtos.configuration.Sede.CrearSedeDTO;
import com.saludSystem.dtos.configuration.Sede.SedeDTO;
import com.saludSystem.dtos.responses.ApiResponse;
import com.saludSystem.dtos.responses.ListResponse;
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