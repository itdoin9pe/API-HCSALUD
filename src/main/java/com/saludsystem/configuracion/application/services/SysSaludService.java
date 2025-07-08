package com.saludsystem.configuracion.application.services;

import com.saludsystem.configuracion.application.dto.res.SysSaludResponse;
import com.saludsystem.configuracion.application.dto.req.SysSaludRequest;
import com.saludsystem.configuracion.application.dto.res.ActualizarHospitalDTO;
import com.saludsystem.configuracion.domain.model.SysSaludEntity;
import com.saludsystem.shared.infrastructure.adapters.in.response.ApiResponse;
import com.saludsystem.shared.infrastructure.adapters.in.response.ListResponse;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface SysSaludService {

    SysSaludEntity saveClinica(SysSaludRequest sysSaludRequest);

    ListResponse<SysSaludResponse> getAllHospital(UUID hospitalId, int page, int rows);

    List<SysSaludResponse> getHospitalList();

    ActualizarHospitalDTO updateHospital(UUID hospitalId, ActualizarHospitalDTO actualizarHospitalDTO);

    ApiResponse deleteHospital(UUID hospitald);

    Optional<SysSaludResponse> getHospitalBysId(UUID hospitalId);

}