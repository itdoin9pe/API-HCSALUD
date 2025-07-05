package com.saludsystem.application.services.paciente.impl.historialclinico.estadocuenta;

import com.saludsystem.application.dtos.paciente.get.historialclinico.estadocuenta.CostoHospitalizacionDTO;
import com.saludsystem.application.dtos.paciente.post.historialclinico.estadocuenta.CrearCostoHospitalizacionDTO;
import com.saludsystem.application.dtos.paciente.put.historialclinico.estadocuenta.ActualizarCostoHospitalizacionDTO;
import com.saludsystem.application.services.GenericServiceImpl;
import com.saludsystem.application.services.paciente.historialclinico.estadocuenta.CostoHospitalizacionService;
import com.saludsystem.domain.exception.ResourceNotFoundException;
import com.saludsystem.domain.model.paciente.EstadoCuenta.CostoHospitalizacionEntity;
import com.saludsystem.infrastructure.adapters.in.response.ApiResponse;
import com.saludsystem.infrastructure.adapters.in.response.ListResponse;
import com.saludsystem.infrastructure.adapters.out.persistance.repository.paciente.EstadoCuenta.CostoHospitalizacionRepository;
import com.saludsystem.infrastructure.adapters.out.persistance.repository.paciente.EstadoCuenta.EstadoCuentaRepository;
import com.saludsystem.infrastructure.adapters.out.security.util.AuthValidator;
import org.modelmapper.ModelMapper;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CostoHospitalizacionServiceImpl extends GenericServiceImpl<CostoHospitalizacionEntity,
        CostoHospitalizacionDTO, UUID, CrearCostoHospitalizacionDTO, ActualizarCostoHospitalizacionDTO>
        implements CostoHospitalizacionService {

    private final EstadoCuentaRepository estadoCuentaRepository;

    public CostoHospitalizacionServiceImpl(
            CostoHospitalizacionRepository costoHospitalizacionRepository,
            ModelMapper modelMapper, AuthValidator authValidator, EstadoCuentaRepository estadoCuentaRepository) {
        super(costoHospitalizacionRepository, modelMapper, authValidator, CostoHospitalizacionDTO.class,
                costoHospitalizacionEntity
                        -> modelMapper.map(costoHospitalizacionEntity, CostoHospitalizacionDTO.class));
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
    protected void updateEntityFromDto(ActualizarCostoHospitalizacionDTO actualizarCostoHospitalizacionDTO, CostoHospitalizacionEntity entity) {
        entity.setFechaIngreso(actualizarCostoHospitalizacionDTO.getFechaIngreso());
        entity.setFechaAlta(actualizarCostoHospitalizacionDTO.getFechaAlta());
        entity.setTipoHabitacion(actualizarCostoHospitalizacionDTO.getTipoHabitacion());
        entity.setTipoHabitacion(actualizarCostoHospitalizacionDTO.getTipoHabitacion());
        entity.setCostoPorDia(actualizarCostoHospitalizacionDTO.getCostoPorDia());
        entity.setCantidadDias(actualizarCostoHospitalizacionDTO.getCantidadDias());
        entity.setTotalCosto(actualizarCostoHospitalizacionDTO.getTotalCosto());
    }

    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    @Override
    public ApiResponse save(CrearCostoHospitalizacionDTO crearCostoHospitalizacionDTO) {
        return super.save(crearCostoHospitalizacionDTO);
    }

    @Override
    public ListResponse<CostoHospitalizacionDTO> getAllPaginated(UUID hospitalId, int page, int rows) {
        return super.getAllPaginated(hospitalId, page, rows);
    }

    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    @Override
    public ApiResponse update(UUID uuid, ActualizarCostoHospitalizacionDTO actualizarCostoHospitalizacionDTO) {
        return super.update(uuid, actualizarCostoHospitalizacionDTO);
    }

    @Override
    public CostoHospitalizacionDTO getById(UUID uuid) {
        return super.getById(uuid);
    }

    @Override
    public List<CostoHospitalizacionDTO> getList() {
        return super.getList();
    }

    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    @Override
    public ApiResponse delete(UUID uuid) {
        return super.delete(uuid);
    }
}