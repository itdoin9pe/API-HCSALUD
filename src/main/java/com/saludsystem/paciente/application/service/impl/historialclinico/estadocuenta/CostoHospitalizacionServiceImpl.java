package com.saludsystem.paciente.application.service.impl.historialclinico.estadocuenta;

import com.saludsystem.paciente.application.dto.get.historialclinico.estadocuenta.CostoHospitalizacionDTO;
import com.saludsystem.paciente.application.dto.post.historialclinico.estadocuenta.CrearCostoHospitalizacionDTO;
import com.saludsystem.paciente.application.dto.put.historialclinico.estadocuenta.ActualizarCostoHospitalizacionDTO;
import com.saludsystem.shared.application.service.GenericServiceImpl;
import com.saludsystem.paciente.application.service.historialclinico.estadocuenta.CostoHospitalizacionService;
import com.saludsystem.shared.domain.exception.ResourceNotFoundException;
import com.saludsystem.paciente.domain.model.estadocuenta.CostoHospitalizacionEntity;
import com.saludsystem.shared.infrastructure.adapters.in.response.ApiResponse;
import com.saludsystem.paciente.infrastructure.adapters.out.persistance.estadocuenta.CostoHospitalizacionRepository;
import com.saludsystem.paciente.infrastructure.adapters.out.persistance.estadocuenta.EstadoCuentaRepository;
import com.saludsystem.shared.infrastructure.security.util.AuthValidator;
import org.modelmapper.ModelMapper;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class CostoHospitalizacionServiceImpl extends GenericServiceImpl<CostoHospitalizacionEntity,
        CostoHospitalizacionDTO, CrearCostoHospitalizacionDTO, ActualizarCostoHospitalizacionDTO, UUID>
        implements CostoHospitalizacionService {

    private final EstadoCuentaRepository estadoCuentaRepository;

    public CostoHospitalizacionServiceImpl(
            CostoHospitalizacionRepository costoHospitalizacionRepository,
            ModelMapper modelMapper, AuthValidator authValidator, EstadoCuentaRepository estadoCuentaRepository) {
        super(costoHospitalizacionRepository, modelMapper, authValidator, CostoHospitalizacionDTO.class
        );
        this.estadoCuentaRepository = estadoCuentaRepository;
    }

    @Override
    protected CostoHospitalizacionEntity convertCreateDtoToEntity(CrearCostoHospitalizacionDTO crearCostoHospitalizacionDTO) {
        CostoHospitalizacionEntity entity = new CostoHospitalizacionEntity();
        entity.setEstadoCuentaEntity(estadoCuentaRepository.findById(crearCostoHospitalizacionDTO.getPacEstadoCuentaId())
                .orElseThrow( () -> new ResourceNotFoundException("Estado de cuenta not found")));
        entity.setFechaIngreso(crearCostoHospitalizacionDTO.getFechaIngreso());
        entity.setFechaAlta(crearCostoHospitalizacionDTO.getFechaAlta());
        entity.setTipoHabitacion(crearCostoHospitalizacionDTO.getTipoHabitacion());
        entity.setCostoPorDia(crearCostoHospitalizacionDTO.getCostoPorDia());
        entity.setCantidadDias(crearCostoHospitalizacionDTO.getCantidadDias());
        entity.setTotalCosto(crearCostoHospitalizacionDTO.getTotalCosto());
        return entity;
    }

    @Override
    protected void updateEntityFromDto(CostoHospitalizacionEntity entity, ActualizarCostoHospitalizacionDTO dto) {
        Optional.ofNullable(dto.getFechaIngreso()).ifPresent(entity::setFechaIngreso);
        Optional.ofNullable(dto.getFechaAlta()).ifPresent(entity::setFechaIngreso);
        Optional.ofNullable(dto.getTipoHabitacion()).ifPresent(entity::setTipoHabitacion);
        Optional.ofNullable(dto.getCostoPorDia()).ifPresent(entity::setCostoPorDia);
        Optional.ofNullable(dto.getCantidadDias()).ifPresent(entity::setCantidadDias);
        Optional.ofNullable(dto.getTotalCosto()).ifPresent(entity::setTotalCosto);
    }

    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    @Override
    public ApiResponse save(CrearCostoHospitalizacionDTO crearCostoHospitalizacionDTO) {
        return super.save(crearCostoHospitalizacionDTO);
    }

    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    @Override
    public ApiResponse update(UUID uuid, ActualizarCostoHospitalizacionDTO updateDto) {
        return super.update(uuid, updateDto);
    }

    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    @Override
    public ApiResponse delete(UUID uuid) {
        return super.delete(uuid);
    }
}