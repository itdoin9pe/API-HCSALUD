package com.saludSystem.services.modules.Generals.Empresas.impl;

import com.saludSystem.dtos.Generals.Empresa.ActualizarEmpresaDTO;
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
    public Optional<EmpresaDTO> getEmpresaById(UUID empresaId) {
        return Optional.ofNullable(empresaRepository.findById(empresaId)
                .map(this::convertToDTO)
                .orElseThrow(() -> new ResourceNotFoundException("Empresa no encontrada con Id" + empresaId)));
    }

    @Override
    public ActualizarEmpresaDTO updateEmpresa(UUID empresaId, ActualizarEmpresaDTO actualizarEmpresaDTO) {
        Empresa empresa = empresaRepository.findById(empresaId)
                .orElseThrow(() -> new ResourceNotFoundException("Empresa no encontrada con ID: " + empresaId));
        Optional.ofNullable(actualizarEmpresaDTO.getDescripcion()).filter(desc -> !desc.isBlank())
                .ifPresent(empresa::setDescripcion);
        Optional.ofNullable(actualizarEmpresaDTO.getEstado()).ifPresent(empresa::setEstado);
        empresaRepository.save(empresa);
        return modelMapper.map(empresa, ActualizarEmpresaDTO.class);
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
