package com.saludSystem.services.modules.Generals;

import com.saludSystem.dtos.Generals.EmpresaDTO;
import com.saludSystem.dtos.Generals.InformacionClinicaDTO;
import com.saludSystem.entities.Empresa;
import com.saludSystem.entities.InformacionClinica;
import com.saludSystem.repositories.modules.Generals.EmpresaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmpresaService {

    @Autowired
    EmpresaRepository empresaRepository;

    public EmpresaDTO saveEmpresa(EmpresaDTO empresaDTO){
        Empresa empresa = new Empresa();
        empresa.setDescripcion(empresaDTO.getDescripcion());
        empresa.setEstado(empresaDTO.isEstado());
        Empresa savedEmpresa = empresaRepository.save(empresa);

        return convertToDTO(savedEmpresa);
    }

    private EmpresaDTO convertToDTO(Empresa empresa) {
        EmpresaDTO empresaDTO = new EmpresaDTO();
        empresaDTO.setId(empresa.getId());
        empresaDTO.setDescripcion(empresa.getDescripcion());
        empresaDTO.setEstado(empresa.isEstado());
        return empresaDTO;
    }

}
