package com.saludSystem.application.services.Mantenimiento.impl;

import com.saludSystem.application.services.Mantenimiento.MonedaService;
import com.saludSystem.domain.model.Configuracion.SysSaludEntity;
import com.saludSystem.infrastructure.adapters.out.persistance.repository.Configuracion.SysSaludRepository;
import com.saludSystem.domain.model.Configuracion.UserEntity;
import com.saludSystem.infrastructure.adapters.out.persistance.repository.Configuracion.UserRepository;
import com.saludSystem.infrastructure.adapters.in.response.ApiResponse;
import com.saludSystem.infrastructure.adapters.in.response.ListResponse;
import com.saludSystem.domain.exception.ResourceNotFoundException;
import com.saludSystem.application.dtos.Mantenimiento.PUT.ActualizarMonedaDTO;
import com.saludSystem.application.dtos.Mantenimiento.POST.CrearMonedaDTO;
import com.saludSystem.application.dtos.Mantenimiento.GET.MonedaDTO;
import com.saludSystem.domain.model.Mantenimiento.MonedaEntity;
import com.saludSystem.infrastructure.adapters.out.persistance.repository.Mantenimiento.MonedaRepository;
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
public class MonedaServiceImpl implements MonedaService {

    private final MonedaRepository monedaRepository;
    private final UserRepository userRepository;
    private final SysSaludRepository sysSaludRepository;
    private final ModelMapper modelMapper;

    public MonedaServiceImpl(MonedaRepository monedaRepository, UserRepository userRepository, SysSaludRepository sysSaludRepository, ModelMapper modelMapper) {
        this.monedaRepository = monedaRepository;
        this.userRepository = userRepository;
        this.sysSaludRepository = sysSaludRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public ApiResponse saveMoneda(CrearMonedaDTO crearMonedaDTO) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();
        UserEntity user = userRepository.findByEmail(email).orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        SysSaludEntity hospital = sysSaludRepository.findById(user.getHospital().getHospitalId()).orElseThrow(() -> new RuntimeException("Hospital no encontrado"));
        MonedaEntity monedaEntity = new MonedaEntity();
        monedaEntity.setDescripcion(crearMonedaDTO.getDescripcion());
        monedaEntity.setEstado(crearMonedaDTO.getEstado());
        monedaEntity.setUser(user);
        monedaEntity.setHospital(hospital);
        monedaRepository.save(monedaEntity);
        return new ApiResponse(true, "Moneda registrada correctamente");
    }

    @Override
    public ListResponse<MonedaDTO> getAllMoneda(UUID hospitalId, int page, int rows) {
        Pageable pageable = PageRequest.of(page - 1, rows);
        Page<MonedaEntity> monedaModelPage = monedaRepository.findByHospital_HospitalId(hospitalId, pageable);
        List<MonedaDTO> data = monedaModelPage.getContent().stream().map(this::convertToDTO).collect(Collectors.toList());
        return new ListResponse<>(data, monedaModelPage.getTotalElements(), monedaModelPage.getTotalPages(), monedaModelPage.getNumber() + 1);
    }

    @Override
    public List<MonedaDTO> getMonedaList() {
        return monedaRepository.findAll().stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    @Override
    public MonedaDTO getMonedaById(UUID monedaId) {
        MonedaEntity monedaEntity = monedaRepository.findById(monedaId).orElseThrow(() -> new ResourceNotFoundException("Moneda no encontrada"));
        return convertToDTO(monedaEntity);
    }

    @Override
    public ApiResponse updateMoneda(UUID monedaId, ActualizarMonedaDTO actualizarMonedaDTO) {
        MonedaEntity monedaEntity = monedaRepository.findById(monedaId).orElseThrow(
                () -> new ResourceNotFoundException("Moneda no encontrada"));
        Optional.ofNullable(actualizarMonedaDTO.getDescripcion()).filter(desc -> !desc.isBlank()).ifPresent(monedaEntity::setDescripcion);
        Optional.ofNullable(actualizarMonedaDTO.getEstado()).ifPresent(monedaEntity::setEstado);
        monedaRepository.save(monedaEntity);
        return new ApiResponse(true, "Moneda actualizada correctamente");
    }

    @Override
    public ApiResponse deleteMoneda(UUID monedaId) {
        monedaRepository.deleteById(monedaId);
        return new ApiResponse(true, "Moneda eliminada correctamente");
    }

    private MonedaDTO convertToDTO(MonedaEntity monedaEntity) {
        return modelMapper.map(monedaEntity, MonedaDTO.class);
    }

}