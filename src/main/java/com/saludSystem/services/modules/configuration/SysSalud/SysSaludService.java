package com.saludSystem.services.modules.configuration.SysSalud;

import com.saludSystem.dtos.configuration.SysSaludModule.ActualizarHospitalDTO;
import com.saludSystem.dtos.configuration.SysSaludModule.CrearSysSaludDTO;
import com.saludSystem.dtos.configuration.SysSaludModule.SysSaludDTO;
import com.saludSystem.dtos.responses.ApiResponse;
import com.saludSystem.dtos.responses.ListResponse;
import com.saludSystem.entities.configuracion.SysSalud;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface SysSaludService {

    SysSalud saveClinica(CrearSysSaludDTO crearSysSaludDTO);

    ListResponse<SysSaludDTO> getAllHospital(UUID hospitalId, int page, int rows);

    List<SysSaludDTO> getHospitalList();

    ActualizarHospitalDTO updateHospital(UUID hospitalId, ActualizarHospitalDTO actualizarHospitalDTO);

    ApiResponse deleteHospital(UUID hospitald);

    Optional<SysSaludDTO> getHospitalBysId(UUID hospitalId);

}