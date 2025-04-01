package com.saludSystem.Generals.adapter.Empresa.aplicacion.services;

import com.saludSystem.Configuracion.SysSalud.dominio.SysSaludModel;
import com.saludSystem.Configuracion.SysSalud.infraestructura.repositories.SysSaludRepository;
import com.saludSystem.Configuracion.Usuario.dominio.UserModel;
import com.saludSystem.Configuracion.Usuario.infraestructura.repositories.UserRepository;
import com.saludSystem.Generals.adapter.Empresa.aplicacion.dtos.ActualizarEmpresaDTO;
import com.saludSystem.Generals.adapter.Empresa.aplicacion.dtos.CrearEmpresaDTO;
import com.saludSystem.Generals.adapter.Empresa.aplicacion.dtos.EmpresaDTO;
import com.saludSystem.Generals.adapter.Empresa.dominio.EmpresaModel;
import com.saludSystem.Generals.adapter.Empresa.infraestructura.repositories.EmpresaRepository;
import com.saludSystem.Generals.response.ApiResponse;
import com.saludSystem.Generals.security.exception.ResourceNotFoundException;
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
        EmpresaModel empresa = empresaRepository.findById(empresaId)
                .orElseThrow(() -> new ResourceNotFoundException("Empresa no encontrada con Id: " + empresaId));
        return convertToDTO(empresa);
    }

    @Override
    public ApiResponse updateEmpresa(UUID empresaId, ActualizarEmpresaDTO actualizarEmpresaDTO) {
        EmpresaModel empresa = empresaRepository.findById(empresaId)
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
        UserModel user = userRepository.findByEmail(email)
                .orElseThrow(() -> new ResourceNotFoundException("Usuario no encontrado"));
        SysSaludModel sysSalud = sysSaludRepository.findById(user.getHospital().getHospitalId())
                .orElseThrow(() -> new ResourceNotFoundException("Hospital no encontrado"));
        EmpresaModel empresa = new EmpresaModel();
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

    private EmpresaDTO convertToDTO(EmpresaModel empresa) {
        return modelMapper.map(empresa, EmpresaDTO.class);
    }

}