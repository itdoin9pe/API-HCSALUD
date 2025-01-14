package com.saludSystem.services.modules.Generals;

import com.saludSystem.dtos.Generals.EmpresaDTO;
import com.saludSystem.entities.Empresa;
import com.saludSystem.repositories.modules.Generals.EmpresaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

    public List<EmpresaDTO> getAllEmpresa(){
        return empresaRepository.findAll()
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public Optional<EmpresaDTO> getEmpresaById(Long id){
        return empresaRepository.findById(id)
                .map(this::convertToDTO);
    }

    public void deleteEmpresa(Long id){
        empresaRepository.deleteById(id);
    }

    public EmpresaDTO updateEmpresa(Long id, EmpresaDTO empresaDTO){
        Empresa empresa = empresaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Empresa no encontrada" + id));
        empresa.setDescripcion(empresaDTO.getDescripcion());
        empresa.setEstado(empresaDTO.isEstado());

        Empresa updatedEmpresa = empresaRepository.save(empresa);

        return convertToDTO(updatedEmpresa);
    }

    private EmpresaDTO convertToDTO(Empresa empresa) {
        EmpresaDTO empresaDTO = new EmpresaDTO();
        empresaDTO.setId(empresa.getId());
        empresaDTO.setDescripcion(empresa.getDescripcion());
        empresaDTO.setEstado(empresa.isEstado());
        return empresaDTO;
    }

}
