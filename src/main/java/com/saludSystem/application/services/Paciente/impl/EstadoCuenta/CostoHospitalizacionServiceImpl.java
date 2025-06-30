package com.saludSystem.application.services.Paciente.impl.EstadoCuenta;

import com.saludSystem.application.dtos.Paciente.GET.EstadoCuenta.CostoHospitalizacionDTO;
import com.saludSystem.application.dtos.Paciente.POST.EstadoCuenta.CrearCostoHospitalizacionDTO;
import com.saludSystem.application.dtos.Paciente.PUT.EstadoCuenta.ActualizarCostoHospitalizacionDTO;
import com.saludSystem.application.services.GenericServiceImpl;
import com.saludSystem.application.services.Paciente.EstadoCuenta.CostoHospitalizacionService;
import com.saludSystem.domain.exception.ResourceNotFoundException;
import com.saludSystem.domain.model.Paciente.EstadoCuenta.CostoHospitalizacionEntity;
import com.saludSystem.infrastructure.adapters.in.response.ApiResponse;
import com.saludSystem.infrastructure.adapters.in.response.ListResponse;
import com.saludSystem.infrastructure.adapters.out.persistance.repository.Paciente.EstadoCuenta.CostoHospitalizacionRepository;
import com.saludSystem.infrastructure.adapters.out.persistance.repository.Paciente.EstadoCuenta.EstadoCuentaRepository;
import com.saludSystem.infrastructure.adapters.out.security.util.AuthValidator;
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
        entity.setEstadoCuentaEntity(estadoCuentaRepository.findById(crearCostoHospitalizacionDTO.getPec_estadoCuentaId())
                .orElseThrow( () -> new ResourceNotFoundException("Estado de cuenta not found")));
        entity.setFechaIngreso(crearCostoHospitalizacionDTO.getFechaIngreso());
        entity.setFechaAlta(crearCostoHospitalizacionDTO.getFechaAlta());
        entity.setTipoHabitacion(crearCostoHospitalizacionDTO.getTipoHabitacion());
        entity.setTipoHabitacion(crearCostoHospitalizacionDTO.getTipoHabitacion());
        entity.setCostoPorDia(crearCostoHospitalizacionDTO.getCostoPorDia());
        entity.setCantidadDias(crearCostoHospitalizacionDTO.getCantidadDias());
        entity.setTotalCosto(crearCostoHospitalizacionDTO.getTotalCosto());
        return entity;
    }

    @Override
    protected void updateEntityFromDto(ActualizarCostoHospitalizacionDTO actualizarCostoHospitalizacionDTO, CostoHospitalizacionEntity entity) {
        entity.setEstadoCuentaEntity(estadoCuentaRepository.findById(actualizarCostoHospitalizacionDTO.getPec_costoHospitalizacionId())
                .orElseThrow( () -> new ResourceNotFoundException("Costo de hospitalizacoin not found")));
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