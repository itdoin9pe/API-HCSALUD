package com.saludSystem.Configuracion.Sede.aplicacion.services;

import com.saludSystem.Configuracion.Sede.aplicacion.dtos.ActualizarSedeDTO;
import com.saludSystem.Configuracion.Sede.aplicacion.dtos.CrearSedeDTO;
import com.saludSystem.Configuracion.Sede.aplicacion.dtos.SedeDTO;
import com.saludSystem.Generals.response.ApiResponse;
import com.saludSystem.Generals.response.ListResponse;
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