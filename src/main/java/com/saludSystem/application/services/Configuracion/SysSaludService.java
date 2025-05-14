package com.saludSystem.application.services.Configuracion;

import com.saludSystem.application.dtos.Configuracion.PUT.ActualizarHospitalDTO;
import com.saludSystem.application.dtos.Configuracion.POST.CrearSysSaludDTO;
import com.saludSystem.application.dtos.Configuracion.GET.SysSaludDTO;
import com.saludSystem.domain.model.Configuracion.SysSaludEntity;
import com.saludSystem.infrastructure.adapters.in.response.ApiResponse;
import com.saludSystem.infrastructure.adapters.in.response.ListResponse;
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