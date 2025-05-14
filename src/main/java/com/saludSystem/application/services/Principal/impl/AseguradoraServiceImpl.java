package com.saludSystem.application.services.Principal.impl;

import com.saludSystem.application.services.Principal.AseguradoraService;
import com.saludSystem.domain.model.Configuracion.SysSaludEntity;
import com.saludSystem.infrastructure.adapters.out.persistance.repository.Configuracion.SysSaludRepository;
import com.saludSystem.domain.model.Configuracion.UserEntity;
import com.saludSystem.infrastructure.adapters.out.persistance.repository.Configuracion.UserRepository;
import com.saludSystem.application.dtos.Principal.PUT.ActualizarAseguradoraDTO;
import com.saludSystem.application.dtos.Principal.GET.AseguradoraDTO;
import com.saludSystem.application.dtos.Principal.POST.CrearAseguradoraDTO;
import com.saludSystem.domain.model.Principal.AseguradoraEntity;
import com.saludSystem.infrastructure.adapters.out.persistance.repository.Principal.AseguradoraRepository;
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
public class AseguradoraServiceImpl implements AseguradoraService {
    
    private final AseguradoraRepository aseguradoraRepository;
    private final UserRepository userRepository;
    private final SysSaludRepository sysSaludRepository;
    private final ModelMapper modelMapper;

    public AseguradoraServiceImpl(AseguradoraRepository aseguradoraRepository, UserRepository userRepository, SysSaludRepository sysSaludRepository, ModelMapper modelMapper) {
        this.aseguradoraRepository = aseguradoraRepository;
        this.userRepository = userRepository;
        this.sysSaludRepository = sysSaludRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public ApiResponse saveAseguradora(CrearAseguradoraDTO crearAseguradoraDTO) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();
        UserEntity user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        SysSaludEntity hospital = sysSaludRepository.findById(user.getHospital().getHospitalId())
                .orElseThrow(() -> new RuntimeException("Hospital no encontrado"));
        AseguradoraEntity aseguradora = new AseguradoraEntity();
        aseguradora.setDescripcion(crearAseguradoraDTO.getDescripcion());
        aseguradora.setEstado(crearAseguradoraDTO.getEstado());
        aseguradora.setUser(user);
        aseguradora.setHospital(hospital);
        aseguradoraRepository.save(aseguradora);
        return new ApiResponse(true, "Aseguradora creada Correctamente");
    }

    @Override
    public List<AseguradoraDTO> getAseguradoraList() {
        return aseguradoraRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public AseguradoraDTO getAseguradoraById(UUID aseguradoraId) {
        AseguradoraEntity aseguradora = aseguradoraRepository.findById(aseguradoraId)
                .orElseThrow(() -> new RuntimeException("Aseguradora no encontrada"));
        return convertToDTO(aseguradora);
    }

    @Override
    public ApiResponse updateAseguradora(UUID aseguradoraId, ActualizarAseguradoraDTO actualizarAseguradoraDTO) {
        AseguradoraEntity aseguradora = aseguradoraRepository.findById(aseguradoraId).orElseThrow(
                () -> new ResourceNotFoundException("Aseguradora no encontrada"));
        Optional.ofNullable(actualizarAseguradoraDTO.getDescripcion()).filter(desc -> !desc.isBlank()).ifPresent(aseguradora::setDescripcion);
        Optional.ofNullable(actualizarAseguradoraDTO.getEstado()).ifPresent(aseguradora::setEstado);
        aseguradoraRepository.save(aseguradora);
        return new ApiResponse(true, "Aseguradora actualizada correctamente");
    }

    @Override
    public ApiResponse deleteAseguradora(UUID aseguradoraId) {
        aseguradoraRepository.deleteById(aseguradoraId);
        return new ApiResponse(true, "Aseguradora eliminada correctamente");
    }

    @Override
    public ListResponse<AseguradoraDTO> getAllAseguradoras(UUID hospitalId, int page, int rows) {
        Pageable pageable = PageRequest.of(page - 1, rows);
        Page<AseguradoraEntity> aseguradoraModelPage = aseguradoraRepository.findByHospital_HospitalId(hospitalId, pageable);
        List<AseguradoraDTO> data = aseguradoraModelPage.getContent().stream().map(this::convertToDTO).collect(Collectors.toList());
        return new ListResponse<>(data, aseguradoraModelPage.getTotalElements(), aseguradoraModelPage.getTotalPages(), aseguradoraModelPage.getNumber() + 1);
    }

    private AseguradoraDTO convertToDTO(AseguradoraEntity aseguradora) {
        return modelMapper.map(aseguradora, AseguradoraDTO.class);
    }

}