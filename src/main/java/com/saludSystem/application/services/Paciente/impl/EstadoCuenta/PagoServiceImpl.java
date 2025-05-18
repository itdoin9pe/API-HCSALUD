package com.saludSystem.application.services.Paciente.impl.EstadoCuenta;

import com.saludSystem.application.dtos.Paciente.GET.EstadoCuenta.PagoDTO;
import com.saludSystem.application.dtos.Paciente.POST.EstadoCuenta.CrearPagoDTO;
import com.saludSystem.application.dtos.Paciente.PUT.EstadoCuenta.ActualizarPagoDTO;
import com.saludSystem.application.services.Paciente.EstadoCuenta.PagoService;
import com.saludSystem.domain.exception.ResourceNotFoundException;
import com.saludSystem.domain.model.Configuracion.SysSaludEntity;
import com.saludSystem.domain.model.Configuracion.UserEntity;
import com.saludSystem.domain.model.Paciente.EstadoCuenta.PagoEntity;
import com.saludSystem.infrastructure.adapters.in.response.ApiResponse;
import com.saludSystem.infrastructure.adapters.in.response.ListResponse;
import com.saludSystem.infrastructure.adapters.out.persistance.repository.Configuracion.SysSaludRepository;
import com.saludSystem.infrastructure.adapters.out.persistance.repository.Configuracion.UserRepository;
import com.saludSystem.infrastructure.adapters.out.persistance.repository.Paciente.EstadoCuenta.EstadoCuentaRepository;
import com.saludSystem.infrastructure.adapters.out.persistance.repository.Paciente.EstadoCuenta.PagoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class PagoServiceImpl implements PagoService {

    private final PagoRepository pagoRepository;
    private final SysSaludRepository sysSaludRepository;
    private final UserRepository userRepository;
    private final EstadoCuentaRepository estadoCuentaRepository;
    private final ModelMapper modelMapper;

    public PagoServiceImpl(PagoRepository pagoRepository, SysSaludRepository sysSaludRepository, UserRepository userRepository, EstadoCuentaRepository estadoCuentaRepository, ModelMapper modelMapper) {
        this.pagoRepository = pagoRepository;
        this.sysSaludRepository = sysSaludRepository;
        this.userRepository = userRepository;
        this.estadoCuentaRepository = estadoCuentaRepository;
        this.modelMapper = modelMapper;
    }

    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    @Override
    public ApiResponse savePago(CrearPagoDTO crearPagoDTO) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();
        UserEntity userEntity = userRepository.findByEmail(email).orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        if (!"ADMINISTRADOR".equals(userEntity.getRol().getNombre())) {
            return new ApiResponse(false, "No tienes permisos para realizar esta acción");
        }
        SysSaludEntity hospital = sysSaludRepository.findById(userEntity.getHospital().getHospitalId()).orElseThrow(
                () -> new RuntimeException("Hospital no encontrado"));
        PagoEntity pagoEntity = new PagoEntity();
        pagoEntity.setFechaPago(crearPagoDTO.getFechaPago());
        pagoEntity.setMonto(crearPagoDTO.getMonto());
        pagoEntity.setMetodoPago(crearPagoDTO.getMetodoPago());
        pagoEntity.setReferenciaPago(crearPagoDTO.getReferenciaPago());
        pagoEntity.setUser(userEntity);
        pagoEntity.setHospital(hospital);
        pagoRepository.save(pagoEntity);
        return new ApiResponse(true, "Pago creado correctamente");
    }

    @Override
    public ListResponse<PagoDTO> getAllPago(UUID hospitalId, int page, int rows) {
        Pageable pageable = PageRequest.of(page - 1, rows);
        Page<PagoEntity> pagoEntityPage = pagoRepository.findByHospital_HospitalId(hospitalId, pageable);
        List<PagoDTO> data = pagoEntityPage.getContent().stream().map(this::convertToDTO).collect(Collectors.toList());
        return new ListResponse<>(data, pagoEntityPage.getTotalElements(), pagoEntityPage.getTotalPages(), pagoEntityPage.getNumber() + 1);
    }

    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    @Override
    public ApiResponse updatePago(UUID pec_pagoId, ActualizarPagoDTO actualizarPagoDTO) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();
        UserEntity userEntity = userRepository.findByEmail(email).orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        if (!"ADMINISTRADOR".equals(userEntity.getRol().getNombre())) {
            return new ApiResponse(false, "No tienes permisos para realizar esta acción");
        }
        PagoEntity pagoEntity = pagoRepository.findById(pec_pagoId).orElseThrow(
                () -> new ResourceNotFoundException("Pago no encontrado"));
        Optional.ofNullable(actualizarPagoDTO.getEstadoCuentaId()).flatMap(estadoCuentaRepository::findById).ifPresent(pagoEntity::setEstadoCuentaEntity);
        Optional.ofNullable(actualizarPagoDTO.getFechaPago()).ifPresent(pagoEntity::setFechaPago);
        Optional.ofNullable(actualizarPagoDTO.getMonto()).ifPresent(pagoEntity::setMonto);
        Optional.ofNullable(actualizarPagoDTO.getMetodoPago()).ifPresent(pagoEntity::setMetodoPago);
        Optional.ofNullable(actualizarPagoDTO.getReferenciaPago()).ifPresent(pagoEntity::setReferenciaPago);
        pagoRepository.save(pagoEntity);
        return new ApiResponse(true, "Pago actualizado correctamente");
    }

    @Override
    public PagoDTO getPagoById(UUID pec_pagoId) {
        PagoEntity pagoEntity = pagoRepository.findById(pec_pagoId).orElseThrow(
                () -> new ResourceNotFoundException("Pago no encontrado"));
        return convertToDTO(pagoEntity);
    }

    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    @Override
    public ApiResponse deletePago(UUID pec_pagoId) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();
        UserEntity userEntity = userRepository.findByEmail(email).orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        if (!"ADMINISTRADOR".equals(userEntity.getRol().getNombre())) {
            return new ApiResponse(false, "No tienes permisos para realizar esta acción");
        }
        pagoRepository.deleteById(pec_pagoId);
        return new ApiResponse(true, "Pago eliminado correctamente");
    }

    private PagoDTO convertToDTO(PagoEntity pagoEntity) {
        return modelMapper.map(pagoEntity, PagoDTO.class);
    }

}