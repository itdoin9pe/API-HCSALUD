package com.saludSystem.Generals.adapter.Empresa.aplicacion.services;


import com.saludSystem.Generals.adapter.Empresa.aplicacion.dtos.ActualizarEmpresaDTO;
import com.saludSystem.Generals.adapter.Empresa.aplicacion.dtos.CrearEmpresaDTO;
import com.saludSystem.Generals.adapter.Empresa.aplicacion.dtos.EmpresaDTO;
import com.saludSystem.Generals.response.ApiResponse;

import java.util.List;
import java.util.UUID;

public interface EmpresaService {

    List<EmpresaDTO> getEmpresaList();

    ApiResponse saveEmpresa(CrearEmpresaDTO crearEmpresaDTO);

    EmpresaDTO getEmpresaById(UUID empresaId);

    ApiResponse deleteEmpresa(UUID empresaId);

    ApiResponse updateEmpresa(UUID empresaId, ActualizarEmpresaDTO actualizarEmpresaDTO);

}