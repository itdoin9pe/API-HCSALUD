package com.saludSystem.aplicacion.services.modules.Generals.Empresas.impl;
/*
import com.saludSystem.dtos.Generals.Empresa.ActualizarEmpresaDTO;
import com.saludSystem.dtos.Generals.Empresa.CrearEmpresaDTO;
import com.saludSystem.dtos.Generals.Empresa.EmpresaDTO;
import com.saludSystem.dtos.responses.ApiResponse;
import com.saludSystem.dtos.responses.ListResponse;
import com.saludSystem.entities.Empresa;
import com.saludSystem.entities.User;
import com.saludSystem.entities.configuracion.SysSalud;
import com.saludSystem.exception.ResourceNotFoundException;
import com.saludSystem.repositories.modules.Configuration.UserRepository;
import com.saludSystem.repositories.modules.Configuration.SysSaludRepository;
import com.saludSystem.repositories.modules.Generals.EmpresaRepository;
import com.saludSystem.services.modules.Generals.Empresas.EmpresaService;
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
        Empresa empresa = empresaRepository.findById(empresaId)
                .orElseThrow(() -> new ResourceNotFoundException("Empresa no encontrada con Id: " + empresaId));
        EmpresaDTO dto = new EmpresaDTO();
        dto.setEmpresaId(empresa.getEmpresaId());
        dto.setDescripcion(empresa.getDescripcion());
        dto.setEstado(empresa.getEstado());
        return dto;
    }

    @Override
    public ApiResponse updateEmpresa(UUID empresaId, ActualizarEmpresaDTO actualizarEmpresaDTO) {
        Empresa empresa = empresaRepository.findById(empresaId)
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
        String username = authentication.getName();
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new ResourceNotFoundException("Usuario no encontrado"));
        SysSalud sysSalud = sysSaludRepository.findById(user.getHospital().getHospitalId())
                .orElseThrow(() -> new ResourceNotFoundException("Hospital no encontrado"));
        Empresa empresa = new Empresa();
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

    private EmpresaDTO convertToDTO(Empresa empresa) {
        return modelMapper.map(empresa, EmpresaDTO.class);
    }

}

 */