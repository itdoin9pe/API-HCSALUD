package com.saludSystem.application.services.Mantenimiento.impl;

import com.saludSystem.application.services.Mantenimiento.TipoGastoService;
import com.saludSystem.domain.model.Configuracion.SysSaludEntity;
import com.saludSystem.infrastructure.adapters.out.persistance.repository.Configuracion.SysSaludRepository;
import com.saludSystem.domain.model.Configuracion.UserEntity;
import com.saludSystem.infrastructure.adapters.out.persistance.repository.Configuracion.UserRepository;
import com.saludSystem.infrastructure.adapters.in.response.ApiResponse;
import com.saludSystem.infrastructure.adapters.in.response.ListResponse;
import com.saludSystem.domain.exception.ResourceNotFoundException;
import com.saludSystem.application.dtos.Mantenimiento.PUT.ActualizarTipoGastoDTO;
import com.saludSystem.application.dtos.Mantenimiento.POST.CrearTipoGastoDTO;
import com.saludSystem.application.dtos.Mantenimiento.GET.TipoGastoDTO;
import com.saludSystem.domain.model.Mantenimiento.TipoGastoEntity;
import com.saludSystem.infrastructure.adapters.out.persistance.repository.Mantenimiento.TipoGastoRepository;
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
public class TipoGastoServiceImpl implements TipoGastoService {

    private final TipoGastoRepository tipoGastoRepository;
    private final SysSaludRepository sysSaludRepository;
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    public TipoGastoServiceImpl(TipoGastoRepository tipoGastoRepository, SysSaludRepository sysSaludRepository, UserRepository userRepository, ModelMapper modelMapper) {
        this.tipoGastoRepository = tipoGastoRepository;
        this.sysSaludRepository = sysSaludRepository;
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public ApiResponse saveTipoGasto(CrearTipoGastoDTO crearTipoGastoDTO) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();
        UserEntity userEntity = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        SysSaludEntity hospital = sysSaludRepository.findById(userEntity.getHospital().getHospitalId())
                .orElseThrow(() -> new RuntimeException("Hospital no encontrado"));
        TipoGastoEntity tipoGastoEntity = new TipoGastoEntity();
        tipoGastoEntity.setNombre(crearTipoGastoDTO.getNombre());
        tipoGastoEntity.setEstado(crearTipoGastoDTO.getEstado());
        tipoGastoEntity.setHospital(hospital);
        tipoGastoEntity.setUser(userEntity);
        tipoGastoRepository.save(tipoGastoEntity);
        return new ApiResponse(true, "Concepto de gasto registrado correctamente");
    }

    @Override
    public List<TipoGastoDTO> getTipoGastoList() {
        return tipoGastoRepository.findAll().stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    @Override
    public ListResponse<TipoGastoDTO> getAllTipoGasto(UUID hospitalId, int page, int rows) {
        Pageable pageable = PageRequest.of(page - 1, rows);
        Page<TipoGastoEntity> tipoGastoModelPage = tipoGastoRepository.findByHospital_HospitalId(hospitalId, pageable);
        List<TipoGastoDTO> data = tipoGastoModelPage.getContent().stream().map(this::convertToDTO).collect(Collectors.toList());
        return new ListResponse<>(data, tipoGastoModelPage.getTotalElements(), tipoGastoModelPage.getTotalPages(), tipoGastoModelPage.getNumber() +1 );
    }

    @Override
    public TipoGastoDTO getTipoGastoById(UUID conceptoGastoId) {
        TipoGastoEntity tipoGastoEntity = tipoGastoRepository.findById(conceptoGastoId)
                .orElseThrow( () -> new ResourceNotFoundException("Concepto de gasto no encontrado"));
        return convertToDTO(tipoGastoEntity);
    }

    @Override
    public ApiResponse updateTipoGasto(UUID conceptoGastoId, ActualizarTipoGastoDTO actualizarTipoGastoDTO) {
        TipoGastoEntity tipoGastoEntity = tipoGastoRepository.findById(conceptoGastoId)
                .orElseThrow( () -> new ResourceNotFoundException("Concepto de gasto no encontrado"));
        Optional.ofNullable(actualizarTipoGastoDTO.getNombre()).filter(desc -> !desc.isBlank()).ifPresent(tipoGastoEntity::setNombre);
        Optional.ofNullable(actualizarTipoGastoDTO.getEstado()).ifPresent(tipoGastoEntity::setEstado);
        tipoGastoRepository.save(tipoGastoEntity);
        return new ApiResponse(true, "Concepto de gasto actualizado correctamente");
    }

    @Override
    public ApiResponse deleteTipoGasto(UUID conceptoGastoId) {
        tipoGastoRepository.deleteById(conceptoGastoId);
        return new ApiResponse(true, "Concepto de gasto eliminado correctamente");
    }

    private TipoGastoDTO convertToDTO(TipoGastoEntity tipoGastoEntity) {
        return modelMapper.map(tipoGastoEntity, TipoGastoDTO.class);
    }

}