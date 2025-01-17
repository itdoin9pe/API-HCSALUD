package com.saludSystem.services.modules.Generals.Empresas.impl;

import com.saludSystem.dtos.Generals.EmpresaDTO;
import com.saludSystem.entities.Empresa;
import com.saludSystem.exception.ResourceNotFoundException;
import com.saludSystem.repositories.modules.Generals.EmpresaRepository;
import com.saludSystem.services.modules.Generals.Empresas.EmpresaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EmpresaServiceImpl implements EmpresaService {

    private final EmpresaRepository empresaRepository;

    @Autowired
    public EmpresaServiceImpl(EmpresaRepository empresaRepository){
        this.empresaRepository = empresaRepository;
    }

    @Override
    public EmpresaDTO saveEmpresa(EmpresaDTO empresaDTO){
        Empresa empresa = new Empresa();
        empresa.setDescripcion(empresaDTO.getDescripcion());
        empresa.setEstado(empresaDTO.isEstado());
        Empresa savedEmpresa = empresaRepository.save(empresa);
        return convertToDTO(savedEmpresa);
    }

    @Override
    public List<EmpresaDTO> getAllEmpresa() {
        return empresaRepository.findAll()
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<EmpresaDTO> getEmpresaById(Integer id) {
        return empresaRepository.findById(id)
                .map(this::convertToDTO);
    }

    @Override
    public void deleteEmpresa(Integer id) {
        empresaRepository.deleteById(id);
    }

    @Override
    public EmpresaDTO updateEmpresa(Integer id, EmpresaDTO empresaDTO) {
        Empresa empresa = empresaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Empresa no encontrada con ID: " + id));
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
