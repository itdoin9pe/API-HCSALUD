package com.saludSystem.Configuracion.SysSalud.aplicacion.services;

import com.saludSystem.Configuracion.SysSalud.aplicacion.dtos.ActualizarHospitalDTO;
import com.saludSystem.Configuracion.SysSalud.aplicacion.dtos.CrearSysSaludDTO;
import com.saludSystem.Configuracion.SysSalud.aplicacion.dtos.SysSaludDTO;
import com.saludSystem.Configuracion.SysSalud.dominio.SysSaludModel;
import com.saludSystem.Generals.response.ApiResponse;
import com.saludSystem.Generals.response.ListResponse;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface SysSaludService {

    SysSaludModel saveClinica(CrearSysSaludDTO crearSysSaludDTO);

    ListResponse<SysSaludDTO> getAllHospital(UUID hospitalId, int page, int rows);

    List<SysSaludDTO> getHospitalList();

    ActualizarHospitalDTO updateHospital(UUID hospitalId, ActualizarHospitalDTO actualizarHospitalDTO);

    ApiResponse deleteHospital(UUID hospitald);

    Optional<SysSaludDTO> getHospitalBysId(UUID hospitalId);

}