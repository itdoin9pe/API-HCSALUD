package com.saludSystem.application.services.Mantenimiento.impl;

import com.saludSystem.application.services.Mantenimiento.TipoTarjetaService;
import com.saludSystem.domain.model.Configuracion.SysSaludEntity;
import com.saludSystem.infrastructure.adapters.out.persistance.repository.Configuracion.SysSaludRepository;
import com.saludSystem.domain.model.Configuracion.UserEntity;
import com.saludSystem.infrastructure.adapters.out.persistance.repository.Configuracion.UserRepository;
import com.saludSystem.infrastructure.adapters.in.response.ApiResponse;
import com.saludSystem.infrastructure.adapters.in.response.ListResponse;
import com.saludSystem.domain.exception.ResourceNotFoundException;
import com.saludSystem.application.dtos.Mantenimiento.PUT.ActualizarTipoTarjetaDTO;
import com.saludSystem.application.dtos.Mantenimiento.POST.CrearTipoTarjetaDTO;
import com.saludSystem.application.dtos.Mantenimiento.GET.TipoTarjetaDTO;
import com.saludSystem.domain.model.Mantenimiento.TipoTarjetaEntity;
import com.saludSystem.infrastructure.adapters.out.persistance.repository.Mantenimiento.TipoTarjetaRepository;
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
public class TipoTarjetaServiceImpl implements TipoTarjetaService {

    private final TipoTarjetaRepository tipoTarjetaRepository;
    private final SysSaludRepository sysSaludRepository;
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    public TipoTarjetaServiceImpl(TipoTarjetaRepository tipoTarjetaRepository, SysSaludRepository sysSaludRepository, UserRepository userRepository, ModelMapper modelMapper) {
        this.tipoTarjetaRepository = tipoTarjetaRepository;
        this.sysSaludRepository = sysSaludRepository;
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public ApiResponse saveTipoTarjeta(CrearTipoTarjetaDTO crearTipoTarjetaDTO) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();
        UserEntity user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        SysSaludEntity hospital = sysSaludRepository.findById(user.getHospital().getHospitalId())
                .orElseThrow(() -> new RuntimeException("Hospital no encontrado"));
        TipoTarjetaEntity tipoTarjetaEntity = new TipoTarjetaEntity();
        tipoTarjetaEntity.setDescripcion(crearTipoTarjetaDTO.getDescripcion());
        tipoTarjetaEntity.setEstado(crearTipoTarjetaDTO.getEstado());
        tipoTarjetaEntity.setHospital(hospital);
        tipoTarjetaEntity.setUser(user);
        tipoTarjetaRepository.save(tipoTarjetaEntity);
        return new ApiResponse(true, "Tipo tarjeta registrada correctamente");
    }

    @Override
    public List<TipoTarjetaDTO> getTipoTarjetaList() {
        return tipoTarjetaRepository.findAll().stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    @Override
    public ListResponse<TipoTarjetaDTO> getAllTipoTarjeta(UUID hospitalId, int page, int rows) {
        Pageable pageable = PageRequest.of(page - 1, rows);
        Page<TipoTarjetaEntity> tipoTarjetaModelPage = tipoTarjetaRepository.findByHospital_HospitalId(hospitalId, pageable);
        List<TipoTarjetaDTO> data = tipoTarjetaModelPage.getContent().stream().map(this::convertToDTO).collect(Collectors.toList());
        return new ListResponse<>(data, tipoTarjetaModelPage.getTotalElements(), tipoTarjetaModelPage.getTotalPages(), tipoTarjetaModelPage.getNumber() + 1);
    }

    @Override
    public TipoTarjetaDTO getTipoTarjetaById(UUID tipoTarjetaId) {
        TipoTarjetaEntity tipoTarjetaEntity = tipoTarjetaRepository.findById(tipoTarjetaId)
                .orElseThrow( () -> new ResourceNotFoundException("Tipo de tarjeta no encontrado"));
        return convertToDTO(tipoTarjetaEntity);
    }

    @Override
    public ApiResponse updateTipoTarjeta(UUID tipoTarjetaId, ActualizarTipoTarjetaDTO actualizarTipoTarjetaDTO) {
        TipoTarjetaEntity tipoTarjetaEntity = tipoTarjetaRepository.findById(tipoTarjetaId).orElseThrow(
                () -> new ResourceNotFoundException("Tipo de tarjeta no encontrada"));
        Optional.ofNullable(actualizarTipoTarjetaDTO.getDescripcion()).filter(desc -> !desc.isBlank()).ifPresent(tipoTarjetaEntity::setDescripcion);
        Optional.ofNullable(actualizarTipoTarjetaDTO.getEstado()).ifPresent(tipoTarjetaEntity::setEstado);
        tipoTarjetaRepository.save(tipoTarjetaEntity);
        return new ApiResponse(true, "Tipo tarjeta actualizada correctamente");
    }

    @Override
    public ApiResponse deleteTipoTarjeta(UUID tipoTarjetaId) {
        tipoTarjetaRepository.deleteById(tipoTarjetaId);
        return new ApiResponse(true,  "Tipo Tarjeta eliminado correctamente");
    }

    private TipoTarjetaDTO convertToDTO(TipoTarjetaEntity tipoTarjetaEntity) {
        return modelMapper.map(tipoTarjetaEntity, TipoTarjetaDTO.class);
    }

}