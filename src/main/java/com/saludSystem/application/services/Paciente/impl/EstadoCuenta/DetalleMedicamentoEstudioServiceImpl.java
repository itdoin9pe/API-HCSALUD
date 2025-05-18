package com.saludSystem.application.services.Paciente.impl.EstadoCuenta;

import com.saludSystem.application.dtos.Paciente.GET.EstadoCuenta.DetalleMedicamentoEstudioDTO;
import com.saludSystem.application.dtos.Paciente.POST.EstadoCuenta.CrearDetalleMedicamentoEstudioDTO;
import com.saludSystem.application.dtos.Paciente.PUT.EstadoCuenta.ActualizarDetalleMedicamentoEstudioDTO;
import com.saludSystem.application.services.Paciente.EstadoCuenta.DetalleMedicamentoEstudioService;
import com.saludSystem.domain.exception.ResourceNotFoundException;
import com.saludSystem.domain.model.Configuracion.SysSaludEntity;
import com.saludSystem.domain.model.Configuracion.UserEntity;
import com.saludSystem.domain.model.Paciente.EstadoCuenta.DetalleMedicamentosEstudiosEntity;
import com.saludSystem.infrastructure.adapters.in.response.ApiResponse;
import com.saludSystem.infrastructure.adapters.in.response.ListResponse;
import com.saludSystem.infrastructure.adapters.out.persistance.repository.Configuracion.SysSaludRepository;
import com.saludSystem.infrastructure.adapters.out.persistance.repository.Configuracion.UserRepository;
import com.saludSystem.infrastructure.adapters.out.persistance.repository.Paciente.EstadoCuenta.DetalleMedicamentoEstudioRepository;
import com.saludSystem.infrastructure.adapters.out.persistance.repository.Paciente.EstadoCuenta.EstadoCuentaRepository;
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
public class DetalleMedicamentoEstudioServiceImpl implements DetalleMedicamentoEstudioService {

    private final DetalleMedicamentoEstudioRepository detalleMedicamentoEstudioRepository;
    private final SysSaludRepository sysSaludRepository;
    private final UserRepository userRepository;
    private final EstadoCuentaRepository estadoCuentaRepository;
    private final ModelMapper modelMapper;

    public DetalleMedicamentoEstudioServiceImpl(DetalleMedicamentoEstudioRepository detalleMedicamentoEstudioRepository, SysSaludRepository sysSaludRepository, UserRepository userRepository, EstadoCuentaRepository estadoCuentaRepository, ModelMapper modelMapper) {
        this.detalleMedicamentoEstudioRepository = detalleMedicamentoEstudioRepository;
        this.sysSaludRepository = sysSaludRepository;
        this.userRepository = userRepository;
        this.estadoCuentaRepository = estadoCuentaRepository;
        this.modelMapper = modelMapper;
    }

    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    @Override
    public ApiResponse saveDetalleMedicamentoEstudio(CrearDetalleMedicamentoEstudioDTO crearDetalleMedicamentoEstudioDTO) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();
        UserEntity userEntity = userRepository.findByEmail(email).orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        if (!"ADMINISTRADOR".equals(userEntity.getRol().getNombre())) {
            return new ApiResponse(false, "No tienes permisos para realizar esta acción");
        }
        SysSaludEntity hospital = sysSaludRepository.findById(userEntity.getHospital().getHospitalId()).orElseThrow(
                () -> new RuntimeException("Hospital no encontrado"));
        DetalleMedicamentosEstudiosEntity detalleMedicamentosEstudiosEntity = new DetalleMedicamentosEstudiosEntity();
        detalleMedicamentosEstudiosEntity.setEstadoCuentaEntity(estadoCuentaRepository.findById(crearDetalleMedicamentoEstudioDTO.getEstadoCuentaId())
                .orElseThrow( () -> new ResourceNotFoundException("Estado de cuenta no encontrado") ));
        detalleMedicamentosEstudiosEntity.setTipo(crearDetalleMedicamentoEstudioDTO.getTipo());
        detalleMedicamentosEstudiosEntity.setDescripcion(crearDetalleMedicamentoEstudioDTO.getDescripcion());
        detalleMedicamentosEstudiosEntity.setCantidad(crearDetalleMedicamentoEstudioDTO.getCantidad());
        detalleMedicamentosEstudiosEntity.setCostoUnitario(crearDetalleMedicamentoEstudioDTO.getCostoUnitario());
        detalleMedicamentosEstudiosEntity.setTotalCosto(crearDetalleMedicamentoEstudioDTO.getTotalCosto());
        detalleMedicamentosEstudiosEntity.setHospital(hospital);
        detalleMedicamentosEstudiosEntity.setUser(userEntity);
        detalleMedicamentoEstudioRepository.save(detalleMedicamentosEstudiosEntity);
        return new ApiResponse(true, "Detalle del medicamento agregado correctamente");
    }

    @Override
    public ListResponse<DetalleMedicamentoEstudioDTO> getAllDetalleMedicamentoEstudio(UUID hospitalId, int page, int rows) {
        Pageable pageable = PageRequest.of(page - 1, rows);
        Page<DetalleMedicamentosEstudiosEntity> detalleMedicamentosEstudiosEntityPage = detalleMedicamentoEstudioRepository.findByHospital_HospitalId(hospitalId, pageable);
        List<DetalleMedicamentoEstudioDTO> data = detalleMedicamentosEstudiosEntityPage.getContent().stream().map(this::convertToDTO).collect(Collectors.toList());
        return new ListResponse<>(data, detalleMedicamentosEstudiosEntityPage.getTotalElements(), detalleMedicamentosEstudiosEntityPage.getTotalPages(),
                detalleMedicamentosEstudiosEntityPage.getNumber() + 1);
    }

    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    @Override
    public ApiResponse updateDetalleMedicamento(UUID pec_detalleMedicamentoId, ActualizarDetalleMedicamentoEstudioDTO actualizarDetalleMedicamentoEstudioDTO) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();
        UserEntity userEntity = userRepository.findByEmail(email).orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        if (!"ADMINISTRADOR".equals(userEntity.getRol().getNombre())) {
            return new ApiResponse(false, "No tienes permisos para realizar esta acción");
        }
        DetalleMedicamentosEstudiosEntity detalleMedicamentosEstudiosEntity = detalleMedicamentoEstudioRepository.findById(
                pec_detalleMedicamentoId).orElseThrow( () -> new ResourceNotFoundException("Detalle del estudio no encontrado"));
        Optional.ofNullable(actualizarDetalleMedicamentoEstudioDTO.getEstadoCuentaId()).flatMap(estadoCuentaRepository::findById).ifPresent(detalleMedicamentosEstudiosEntity::setEstadoCuentaEntity);
        Optional.of(actualizarDetalleMedicamentoEstudioDTO.getTipo()).filter(desc -> !desc.isBlank()).ifPresent(detalleMedicamentosEstudiosEntity::setTipo);
        Optional.of(actualizarDetalleMedicamentoEstudioDTO.getDescripcion()).filter(desc -> !desc.isBlank()).ifPresent(detalleMedicamentosEstudiosEntity::setDescripcion);
        Optional.of(actualizarDetalleMedicamentoEstudioDTO.getCantidad()).ifPresent(detalleMedicamentosEstudiosEntity::setCantidad);
        Optional.of(actualizarDetalleMedicamentoEstudioDTO.getCostoUnitario()).ifPresent(detalleMedicamentosEstudiosEntity::setCostoUnitario);
        Optional.of(actualizarDetalleMedicamentoEstudioDTO.getTotalCosto()).ifPresent(detalleMedicamentosEstudiosEntity::setTotalCosto);
        detalleMedicamentoEstudioRepository.save(detalleMedicamentosEstudiosEntity);
        return new ApiResponse(true, "Detalle del estudio actualizado correctamente");
    }

    @Override
    public DetalleMedicamentoEstudioDTO getDetalleMedicamentoById(UUID pec_detalleMedicamentoId) {
        DetalleMedicamentosEstudiosEntity detalleMedicamentosEstudiosEntity = detalleMedicamentoEstudioRepository.findById(
                pec_detalleMedicamentoId).orElseThrow( () -> new ResourceNotFoundException("Detalle del estudio no encontrado"));
        return convertToDTO(detalleMedicamentosEstudiosEntity);
    }

    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    @Override
    public ApiResponse deleteDetalleMedicamentoEstudio(UUID pec_detalleMedicamentoId) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();
        UserEntity userEntity = userRepository.findByEmail(email).orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        if (!"ADMINISTRADOR".equals(userEntity.getRol().getNombre())) {
            return new ApiResponse(false, "No tienes permisos para realizar esta acción");
        }
        detalleMedicamentoEstudioRepository.deleteById(pec_detalleMedicamentoId);
        return new ApiResponse(true, "Detalles del estudio de medicamentos eliminado correctamente");
    }

    private DetalleMedicamentoEstudioDTO convertToDTO(DetalleMedicamentosEstudiosEntity detalleMedicamentosEstudiosEntity) {
        return modelMapper.map(detalleMedicamentosEstudiosEntity, DetalleMedicamentoEstudioDTO.class);
    }

}