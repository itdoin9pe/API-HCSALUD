package com.saludsystem.application.services.configuracion;

import com.saludsystem.application.dtos.configuracion.get.SysSaludDTO;
import com.saludsystem.application.dtos.configuracion.post.CrearSysSaludDTO;
import com.saludsystem.application.dtos.configuracion.put.ActualizarHospitalDTO;
import com.saludsystem.domain.model.configuracion.SysSaludEntity;
import com.saludsystem.infrastructure.adapters.in.response.ApiResponse;
import com.saludsystem.infrastructure.adapters.in.response.ListResponse;
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