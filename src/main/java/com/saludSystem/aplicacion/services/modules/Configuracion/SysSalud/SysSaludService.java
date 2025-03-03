package com.saludSystem.aplicacion.services.modules.Configuracion.SysSalud;

import com.saludSystem.aplicacion.dtos.Configuracion.SysSalud.ActualizarHospitalDTO;
import com.saludSystem.aplicacion.dtos.Configuracion.SysSalud.CrearSysSaludDTO;
import com.saludSystem.aplicacion.dtos.Configuracion.SysSalud.SysSaludDTO;
import com.saludSystem.aplicacion.dtos.responses.ApiResponse;
import com.saludSystem.aplicacion.dtos.responses.ListResponse;
import com.saludSystem.dominio.entities.Configuracion.SysSalud;

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