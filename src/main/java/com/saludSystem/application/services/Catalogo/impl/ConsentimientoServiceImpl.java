package com.saludSystem.application.services.Catalogo.impl;

import com.saludSystem.application.dtos.Catalogo.PUT.ActualizarConsentimientoDTO;
import com.saludSystem.application.dtos.Catalogo.GET.ConsentimientoDTO;
import com.saludSystem.application.dtos.Catalogo.POST.CrearConsentimientoDTO;
import com.saludSystem.application.services.Catalogo.ConsentimientoService;
import com.saludSystem.infrastructure.adapters.out.persistance.repository.Catalogo.ConsentimientoRepository;
import com.saludSystem.domain.model.Catalogo.ConsentimientoEntity;
import com.saludSystem.domain.model.Configuracion.SysSaludEntity;
import com.saludSystem.infrastructure.adapters.out.persistance.repository.Configuracion.SysSaludRepository;
import com.saludSystem.domain.model.Configuracion.UserEntity;
import com.saludSystem.infrastructure.adapters.out.persistance.repository.Configuracion.UserRepository;
import com.saludSystem.infrastructure.adapters.in.response.ApiResponse;
import com.saludSystem.infrastructure.adapters.in.response.ListResponse;
import com.saludSystem.domain.exception.ResourceNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ConsentimientoServiceImpl implements ConsentimientoService {

    private final ConsentimientoRepository consentimientoRepository;
    private final SysSaludRepository sysSaludRepository;
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    public ConsentimientoServiceImpl(ConsentimientoRepository consentimientoRepository, SysSaludRepository sysSaludRepository, UserRepository userRepository, ModelMapper modelMapper) {
        this.consentimientoRepository = consentimientoRepository;
        this.sysSaludRepository = sysSaludRepository;
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public ApiResponse saveConsentimiento(CrearConsentimientoDTO crearConsentimientoDTO) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();
        UserEntity user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        SysSaludEntity hospital = sysSaludRepository.findById(user.getHospital().getHospitalId())
                .orElseThrow(() -> new RuntimeException("Hospital no encontrado"));
        ConsentimientoEntity consentimientoEntity = new ConsentimientoEntity();
        consentimientoEntity.setNombre(crearConsentimientoDTO.getNombre());
        consentimientoEntity.setObservacion(crearConsentimientoDTO.getObservacion());
        consentimientoEntity.setEstado(crearConsentimientoDTO.getEstado());
        consentimientoEntity.setTexto(crearConsentimientoDTO.getTexto());
        consentimientoEntity.setUser(user);
        consentimientoEntity.setHospital(hospital);
        consentimientoRepository.save(consentimientoEntity);
        return new ApiResponse(true, "Consentimiento registrado correctamente");
    }

    @Override
    public ApiResponse updateConsentimiento(UUID consentimientoId, ActualizarConsentimientoDTO actualizarConsentimientoDTO) {
        ConsentimientoEntity consentimientoEntity = consentimientoRepository.findById(consentimientoId)
                .orElseThrow( () -> new ResourceNotFoundException("Consentimiento no encontrado"));
        Optional.ofNullable(actualizarConsentimientoDTO.getNombre()).filter(desc -> !desc.isBlank()).ifPresent(consentimientoEntity::setNombre);
        Optional.ofNullable(actualizarConsentimientoDTO.getObservacion()).filter(desc -> !desc.isBlank()).ifPresent(consentimientoEntity::setObservacion);
        Optional.ofNullable(actualizarConsentimientoDTO.getEstado()).ifPresent(consentimientoEntity::setEstado);
        Optional.ofNullable(actualizarConsentimientoDTO.getTexto()).filter(desc -> !desc.isBlank()).ifPresent(consentimientoEntity::setTexto);
        consentimientoRepository.save(consentimientoEntity);
        return new ApiResponse(true, "Consentimiento actualizado correctamente");
    }

    @Override
    public ConsentimientoDTO getConsentimientoById(UUID consentimientoId) {
        ConsentimientoEntity consentimientoEntity = consentimientoRepository.findById(consentimientoId).orElseThrow(
                () -> new ResourceNotFoundException("Consentimiento no encontrado"));
        return convertToDTO(consentimientoEntity);
    }

    @Override
    public ApiResponse deleteConsentimiento(UUID consentimientoId) {
        consentimientoRepository.deleteById(consentimientoId);
        return new ApiResponse(true, "Consentimiento eliminado correctamente");
    }

    @Override
    public ListResponse<ConsentimientoDTO> getAllConsentimiento(UUID hospitalId, int page, int rows) {
        Pageable pageable = PageRequest.of(page - 1, rows);
        Page<ConsentimientoEntity> consentimientoModelPage = consentimientoRepository.findByHospital_HospitalId(hospitalId, pageable);
        List<ConsentimientoDTO> data = consentimientoModelPage.getContent().stream().map(this::convertToDTO).collect(Collectors.toList());
        return new ListResponse<>(data, consentimientoModelPage.getTotalElements(), consentimientoModelPage.getTotalPages(), consentimientoModelPage.getNumber() + 1);
    }

    private ConsentimientoDTO convertToDTO(ConsentimientoEntity consentimientoEntity) {
        return modelMapper.map(consentimientoEntity, ConsentimientoDTO.class);
    }

}