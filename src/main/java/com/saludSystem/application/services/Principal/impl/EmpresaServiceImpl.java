package com.saludSystem.application.services.Principal.impl;

import com.saludSystem.application.services.Principal.EmpresaService;
import com.saludSystem.domain.model.Configuracion.SysSaludEntity;
import com.saludSystem.infrastructure.adapters.out.persistance.repository.Configuracion.SysSaludRepository;
import com.saludSystem.domain.model.Configuracion.UserEntity;
import com.saludSystem.infrastructure.adapters.out.persistance.repository.Configuracion.UserRepository;
import com.saludSystem.application.dtos.Principal.PUT.ActualizarEmpresaDTO;
import com.saludSystem.application.dtos.Principal.POST.CrearEmpresaDTO;
import com.saludSystem.application.dtos.Principal.GET.EmpresaDTO;
import com.saludSystem.domain.model.Principal.EmpresaEntity;
import com.saludSystem.infrastructure.adapters.out.persistance.repository.Principal.EmpresaRepository;
import com.saludSystem.infrastructure.adapters.in.response.ApiResponse;
import com.saludSystem.domain.exception.ResourceNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class EmpresaServiceImpl implements EmpresaService {

    private final EmpresaRepository empresaRepository;
    private final SysSaludRepository sysSaludRepository;
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    public EmpresaServiceImpl(EmpresaRepository empresaRepository, SysSaludRepository sysSaludRepository, UserRepository userRepository, ModelMapper modelMapper) {
        this.empresaRepository = empresaRepository;
        this.sysSaludRepository = sysSaludRepository;
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<EmpresaDTO> getEmpresaList() {
        return empresaRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public EmpresaDTO getEmpresaById(UUID empresaId) {
        EmpresaEntity empresa = empresaRepository.findById(empresaId)
                .orElseThrow(() -> new ResourceNotFoundException("Empresa no encontrada con Id: " + empresaId));
        return convertToDTO(empresa);
    }

    @Override
    public ApiResponse updateEmpresa(UUID empresaId, ActualizarEmpresaDTO actualizarEmpresaDTO) {
        EmpresaEntity empresa = empresaRepository.findById(empresaId)
                .orElseThrow(() -> new ResourceNotFoundException("Empresa no encontrada con ID: " + empresaId));
        Optional.ofNullable(actualizarEmpresaDTO.getDescripcion()).filter(desc -> !desc.isBlank())
                .ifPresent(empresa::setDescripcion);
        Optional.ofNullable(actualizarEmpresaDTO.getEstado()).ifPresent(empresa::setEstado);
        empresaRepository.save(empresa);
        return new ApiResponse(true, "Empresa actualizada correctamente.");
    }

    @Override
    public ApiResponse saveEmpresa(CrearEmpresaDTO crearEmpresaDTO){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();
        UserEntity user = userRepository.findByEmail(email)
                .orElseThrow(() -> new ResourceNotFoundException("Usuario no encontrado"));
        SysSaludEntity sysSalud = sysSaludRepository.findById(user.getHospital().getHospitalId())
                .orElseThrow(() -> new ResourceNotFoundException("Hospital no encontrado"));
        EmpresaEntity empresa = new EmpresaEntity();
        empresa.setDescripcion(crearEmpresaDTO.getDescripcion());
        empresa.setEstado(crearEmpresaDTO.getEstado());
        empresa.setUser(user);
        empresa.setHospital(sysSalud);
        empresaRepository.save(empresa);
        return new ApiResponse(true, "Empresa registrada correctamente.");
    }

    @Override
    public ApiResponse deleteEmpresa(UUID empresaId) {
        empresaRepository.deleteById(empresaId);
        return new ApiResponse(true, "Empresa eliminada correctamente");
    }

    private EmpresaDTO convertToDTO(EmpresaEntity empresa) {
        return modelMapper.map(empresa, EmpresaDTO.class);
    }

}