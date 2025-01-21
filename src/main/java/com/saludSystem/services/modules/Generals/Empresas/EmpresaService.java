package com.saludSystem.services.modules.Generals.Empresas;

import com.saludSystem.dtos.Generals.EmpresaDTO;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface EmpresaService {

    List<EmpresaDTO> getEmpresaList();

    EmpresaDTO saveEmpresa(EmpresaDTO empresaDTO);

    Optional<EmpresaDTO> getEmpresaById(UUID id);

    void deleteEmpresa(UUID id);

    EmpresaDTO updateEmpresa(UUID id, EmpresaDTO empresaDTO);
}
