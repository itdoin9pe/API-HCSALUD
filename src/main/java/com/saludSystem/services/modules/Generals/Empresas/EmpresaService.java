package com.saludSystem.services.modules.Generals.Empresas;

import com.saludSystem.dtos.Generals.Empresa.ActualizarEmpresaDTO;
import com.saludSystem.dtos.Generals.Empresa.CrearEmpresaDTO;
import com.saludSystem.dtos.Generals.Empresa.EmpresaDTO;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface EmpresaService {

    List<EmpresaDTO> getEmpresaList();

    CrearEmpresaDTO saveEmpresa(CrearEmpresaDTO crearEmpresaDTO);

    Optional<EmpresaDTO> getEmpresaById(UUID empresaId);

    void deleteEmpresa(UUID empresaId);

    ActualizarEmpresaDTO updateEmpresa(UUID empresaId, ActualizarEmpresaDTO actualizarEmpresaDTO);

}