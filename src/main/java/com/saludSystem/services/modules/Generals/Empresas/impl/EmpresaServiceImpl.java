package com.saludSystem.services.modules.Generals.Empresas.impl;

import com.saludSystem.dtos.Generals.EmpresaDTO;
import com.saludSystem.entities.Empresa;
import com.saludSystem.exception.ResourceNotFoundException;
import com.saludSystem.repositories.modules.Generals.EmpresaRepository;
import com.saludSystem.services.modules.Generals.Empresas.EmpresaService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class EmpresaServiceImpl implements EmpresaService {

    private final EmpresaRepository empresaRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public EmpresaServiceImpl(EmpresaRepository empresaRepository, ModelMapper modelMapper){
        this.empresaRepository = empresaRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<EmpresaDTO> getEmpresaList() {
        return empresaRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<EmpresaDTO> getEmpresaById(UUID id) {
        return empresaRepository.findById(id)
                .map(this::convertToDTO);
    }

    @Override
    public EmpresaDTO updateEmpresa(UUID id, EmpresaDTO empresaDTO) {
        Empresa empresa = empresaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Empresa no encontrada con ID: " + id));
        empresa.setDescripcion(empresaDTO.getDescripcion());
        empresa.setEstado(empresaDTO.getEstado());
        Empresa updatedEmpresa = empresaRepository.save(empresa);
        return convertToDTO(updatedEmpresa);
    }

    @Override
    public EmpresaDTO saveEmpresa(EmpresaDTO empresaDTO){
        Empresa empresa = new Empresa();
        empresa.setDescripcion(empresaDTO.getDescripcion());
        empresa.setEstado(empresaDTO.getEstado());
        Empresa savedEmpresa = empresaRepository.save(empresa);
        return convertToDTO(savedEmpresa);
    }

    @Override
    public void deleteEmpresa(UUID id) {
        empresaRepository.deleteById(id);
    }

    private EmpresaDTO convertToDTO(Empresa empresa) {
        EmpresaDTO empresaDTO = new EmpresaDTO();
        empresaDTO.setId(empresa.getId());
        empresaDTO.setDescripcion(empresa.getDescripcion());
        empresaDTO.setEstado(empresa.getEstado());
        return empresaDTO;
    }

}
