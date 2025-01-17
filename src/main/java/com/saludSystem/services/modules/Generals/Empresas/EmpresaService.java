package com.saludSystem.services.modules.Generals.Empresas;

import com.saludSystem.dtos.Generals.EmpresaDTO;
import java.util.List;
import java.util.Optional;

public interface EmpresaService {
    EmpresaDTO saveEmpresa(EmpresaDTO empresaDTO);

    List<EmpresaDTO> getAllEmpresa();

    Optional<EmpresaDTO> getEmpresaById(Integer id);

    void deleteEmpresa(Integer id);

    EmpresaDTO updateEmpresa(Integer id, EmpresaDTO empresaDTO);
}
