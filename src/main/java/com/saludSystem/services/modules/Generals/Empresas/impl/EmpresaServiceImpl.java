package com.saludSystem.services.modules.Generals.Empresas.impl;

import com.saludSystem.dtos.Generals.Empresa.CrearEmpresaDTO;
import com.saludSystem.dtos.Generals.Empresa.EmpresaDTO;
import com.saludSystem.entities.Empresa;
import com.saludSystem.exception.ResourceNotFoundException;
import com.saludSystem.repositories.modules.Generals.EmpresaRepository;
import com.saludSystem.services.modules.Generals.Empresas.EmpresaService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
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
        return Optional.ofNullable(empresaRepository.findById(id)
                .map(this::convertToDTO)
                .orElseThrow(() -> new ResourceNotFoundException("Empresa no encontrada con Id" + id)));
    }

    @Override
    public EmpresaDTO updateEmpresa(UUID id, EmpresaDTO empresaDTO) {
        Empresa empresa = empresaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Empresa no encontrada con ID: " + id));
        Optional.ofNullable(empresaDTO.getDescripcion()).filter(desc -> !desc.isBlank())
                        .ifPresent(empresa::setDescripcion);
        Optional.ofNullable(empresaDTO.getEstado()).ifPresent(empresa::setEstado);
        Empresa updatedEmpresa = empresaRepository.save(empresa);
        return convertToDTO(updatedEmpresa);
    }

    @Override
    public CrearEmpresaDTO saveEmpresa(CrearEmpresaDTO crearEmpresaDTO){
        Empresa empresa = modelMapper.map(crearEmpresaDTO, Empresa.class);
        empresaRepository.save(empresa);
        return modelMapper.map(empresa, CrearEmpresaDTO.class);
    }

    @Override
    public void deleteEmpresa(UUID id) {
        empresaRepository.deleteById(id);
    }

    private EmpresaDTO convertToDTO(Empresa empresa) {
        return modelMapper.map(empresa, EmpresaDTO.class);
    }

}
