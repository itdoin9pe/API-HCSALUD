package com.saludSystem.application.services.Mantenimiento.impl;

import com.saludSystem.application.services.Mantenimiento.CuentaService;
import com.saludSystem.domain.model.Configuracion.SysSaludEntity;
import com.saludSystem.infrastructure.adapters.out.persistance.repository.Configuracion.SysSaludRepository;
import com.saludSystem.domain.model.Configuracion.UserEntity;
import com.saludSystem.infrastructure.adapters.out.persistance.repository.Configuracion.UserRepository;
import com.saludSystem.infrastructure.adapters.in.response.ApiResponse;
import com.saludSystem.infrastructure.adapters.in.response.ListResponse;
import com.saludSystem.domain.exception.ResourceNotFoundException;
import com.saludSystem.application.dtos.Mantenimiento.PUT.ActualizarCuentaDTO;
import com.saludSystem.application.dtos.Mantenimiento.POST.CrearCuentaDTO;
import com.saludSystem.application.dtos.Mantenimiento.GET.CuentaDTO;
import com.saludSystem.domain.model.Mantenimiento.CuentaEntity;
import com.saludSystem.infrastructure.adapters.out.persistance.repository.Mantenimiento.CuentaRepository;
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
public class CuentaServiceImpl implements CuentaService {

    private final CuentaRepository cuentaRepository;
    private final SysSaludRepository sysSaludRepository;
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    public CuentaServiceImpl(CuentaRepository cuentaRepository, SysSaludRepository sysSaludRepository, UserRepository userRepository, ModelMapper modelMapper) {
        this.cuentaRepository = cuentaRepository;
        this.sysSaludRepository = sysSaludRepository;
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public ApiResponse saveCuenta(CrearCuentaDTO crearCuentaDTO) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();
        UserEntity userEntity = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        SysSaludEntity hospital = sysSaludRepository.findById(userEntity.getHospital().getHospitalId())
                .orElseThrow(() -> new RuntimeException("Hospital no encontrado"));
        CuentaEntity cuentaEntity = new CuentaEntity();
        cuentaEntity.setNombre(crearCuentaDTO.getNombre());
        cuentaEntity.setTotal(crearCuentaDTO.getTotal());
        cuentaEntity.setEstado(crearCuentaDTO.getEstado());
        cuentaEntity.setHospital(hospital);
        cuentaEntity.setUser(userEntity);
        cuentaRepository.save(cuentaEntity);
        return new ApiResponse(true, "Cuenta a pagar registrada correctamente");
    }

    @Override
    public List<CuentaDTO> getCuentaList() {
        return cuentaRepository.findAll().stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    @Override
    public ListResponse<CuentaDTO> getAllCuenta(UUID hospitalId, int page, int rows) {
        Pageable pageable = PageRequest.of(page - 1, rows);
        Page<CuentaEntity> cuentaModelPage = cuentaRepository.findByHospital_HospitalId(hospitalId, pageable);
        List<CuentaDTO> data = cuentaModelPage.getContent().stream().map(this::convertToDTO).collect(Collectors.toList());
        return new ListResponse<>(data, cuentaModelPage.getTotalElements(), cuentaModelPage.getTotalPages(), cuentaModelPage.getNumber() +1 );
    }

    @Override
    public ApiResponse updateCuenta(UUID cuentaPagarId, ActualizarCuentaDTO actualizarCuentaDTO) {
        CuentaEntity cuentaEntity = cuentaRepository.findById(cuentaPagarId).orElseThrow(
                () -> new ResourceNotFoundException("Cuenta no encontrada"));
        Optional.ofNullable(actualizarCuentaDTO.getNombre()).filter(desc -> !desc.isBlank()).ifPresent(cuentaEntity::setNombre);
        Optional.ofNullable(actualizarCuentaDTO.getTotal()).ifPresent(cuentaEntity::setTotal);
        Optional.ofNullable(actualizarCuentaDTO.getEstado()).ifPresent(cuentaEntity::setEstado);
        cuentaRepository.save(cuentaEntity);
        return new ApiResponse(true, "Cuenta a pagar actualizada correctamente");
    }

    @Override
    public CuentaDTO getCuentaById(UUID cuentaPagarId) {
        CuentaEntity cuentaEntity = cuentaRepository.findById(cuentaPagarId).orElseThrow(
                () -> new ResourceNotFoundException("Cuenta no encontrada"));
        return convertToDTO(cuentaEntity);
    }

    @Override
    public ApiResponse deleteCuenta(UUID cuentaPagarId) {
        cuentaRepository.deleteById(cuentaPagarId);
        return new ApiResponse(true, "Cuenta eliminada correctamente");
    }

    private CuentaDTO convertToDTO(CuentaEntity cuentaEntity) {
        return modelMapper.map(cuentaEntity, CuentaDTO.class);
    }

}