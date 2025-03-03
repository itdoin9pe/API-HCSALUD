package com.saludSystem.application.services.modules.configuration.SysSalud;

import com.saludSystem.application.dtos.configuration.SysSalud.ActualizarHospitalDTO;
import com.saludSystem.application.dtos.configuration.SysSalud.CrearSysSaludDTO;
import com.saludSystem.application.dtos.configuration.SysSalud.SysSaludDTO;
import com.saludSystem.application.dtos.responses.ApiResponse;
import com.saludSystem.application.dtos.responses.ListResponse;
import com.saludSystem.domain.entities.configuracion.SysSalud;

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