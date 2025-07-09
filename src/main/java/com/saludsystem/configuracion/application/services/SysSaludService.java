package com.saludsystem.configuracion.application.services;

import com.saludsystem.configuracion.application.dto.get.SysSaludDTO;
import com.saludsystem.configuracion.application.dto.post.CrearSysSaludDTO;
import com.saludsystem.configuracion.application.dto.put.ActualizarHospitalDTO;
import com.saludsystem.configuracion.domain.model.SysSaludEntity;
import com.saludsystem.shared.infrastructure.adapters.in.response.ApiResponse;
import com.saludsystem.shared.infrastructure.adapters.in.response.ListResponse;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface SysSaludService {

    SysSaludEntity saveClinica(CrearSysSaludDTO crearSysSaludDTO);

    ListResponse<SysSaludDTO> getAllHospital(UUID hospitalId, int page, int rows);

    List<SysSaludDTO> getHospitalList();

    ActualizarHospitalDTO updateHospital(UUID hospitalId, ActualizarHospitalDTO actualizarHospitalDTO);

    ApiResponse deleteHospital(UUID hospitald);

    Optional<SysSaludDTO> getHospitalBysId(UUID hospitalId);

}