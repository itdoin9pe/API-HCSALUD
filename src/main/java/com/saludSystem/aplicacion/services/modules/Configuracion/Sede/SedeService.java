package com.saludSystem.aplicacion.services.modules.Configuracion.Sede;

import com.saludSystem.aplicacion.dtos.Configuracion.Sede.ActualizarSedeDTO;
import com.saludSystem.aplicacion.dtos.Configuracion.Sede.CrearSedeDTO;
import com.saludSystem.aplicacion.dtos.Configuracion.Sede.SedeDTO;
import com.saludSystem.aplicacion.dtos.responses.ApiResponse;
import com.saludSystem.aplicacion.dtos.responses.ListResponse;
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