package com.saludSystem.application.services.Principal.impl;

import com.saludSystem.application.services.Principal.InformacionClinicaService;
import com.saludSystem.domain.model.Configuracion.SysSaludEntity;
import com.saludSystem.infrastructure.adapters.out.persistance.repository.Configuracion.SysSaludRepository;
import com.saludSystem.domain.model.Configuracion.UserEntity;
import com.saludSystem.infrastructure.adapters.out.persistance.repository.Configuracion.UserRepository;
import com.saludSystem.application.dtos.Principal.PUT.ActualizarInformacionClinicaDTO;
import com.saludSystem.application.dtos.Principal.POST.CrearInformacionClinicaDTO;
import com.saludSystem.application.dtos.Principal.GET.InformacionClinicaDTO;
import com.saludSystem.domain.model.Principal.InformacionClinicaEntity;
import com.saludSystem.infrastructure.adapters.out.persistance.repository.Principal.InformacionClinicaRepository;
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
public class InformacionClinicaServiceImpl implements InformacionClinicaService {

    private final InformacionClinicaRepository informacionClinicaRepository;
    private final UserRepository userRepository;
    private final SysSaludRepository sysSaludRepository;
    private final ModelMapper modelMapper;

    public InformacionClinicaServiceImpl(InformacionClinicaRepository informacionClinicaRepository, UserRepository userRepository, SysSaludRepository sysSaludRepository, ModelMapper modelMapper) {
        this.informacionClinicaRepository = informacionClinicaRepository;
        this.userRepository = userRepository;
        this.sysSaludRepository = sysSaludRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<InformacionClinicaDTO> getInformacionClinicaList() {
        return informacionClinicaRepository.findAll()
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public ApiResponse saveInformacionClinica(CrearInformacionClinicaDTO crearInformacionClinicaDTO) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();
        UserEntity user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        SysSaludEntity hospital = sysSaludRepository.findById(user.getHospital().getHospitalId())
                .orElseThrow(() -> new RuntimeException("Hospital no encontrado"));
        InformacionClinicaEntity informacionClinica = new InformacionClinicaEntity();
        informacionClinica.setNombre(crearInformacionClinicaDTO.getNombre());
        informacionClinica.setEstado(crearInformacionClinicaDTO.getEstado());
        informacionClinica.setUser(user);
        informacionClinica.setHospital(hospital);
        informacionClinicaRepository.save(informacionClinica);
        return new ApiResponse(true, "Informacion Clinica registrada correctamente");
    }

    @Override
    public InformacionClinicaDTO getInformacionClinicaById(UUID informacionClinicaId) {
        InformacionClinicaEntity informacionClinica = informacionClinicaRepository.findById(informacionClinicaId)
                .orElseThrow( () -> new RuntimeException("Informacion clinica no encontrada"));
        return convertToDTO(informacionClinica);
    }

    @Override
    public ApiResponse deleteInformacionClinica(UUID informacionClinicaId) {
        informacionClinicaRepository.deleteById(informacionClinicaId);
        return new ApiResponse(true, "Informacion clinica eliminado correctamente");
    }

    @Override
    public ApiResponse updateInformacionClinica(UUID informacionClinicaId, ActualizarInformacionClinicaDTO actualizarInformacionClinicaDTO) {
        InformacionClinicaEntity informacionClinica = informacionClinicaRepository.findById(informacionClinicaId)
                .orElseThrow(() -> new ResourceNotFoundException("InformacionClinica no encontrada con ID"));
        Optional.ofNullable(actualizarInformacionClinicaDTO.getNombre()).filter(desc -> !desc.isBlank()).ifPresent(informacionClinica::setNombre);
        Optional.ofNullable(actualizarInformacionClinicaDTO.getEstado()).ifPresent(informacionClinica::setEstado);
        informacionClinicaRepository.save(informacionClinica);
        return new ApiResponse(true, "Informacion clinica actualizado correctamente");
    }

    private InformacionClinicaDTO convertToDTO(InformacionClinicaEntity informacionClinica) {
        return modelMapper.map(informacionClinica, InformacionClinicaDTO.class);
    }

}