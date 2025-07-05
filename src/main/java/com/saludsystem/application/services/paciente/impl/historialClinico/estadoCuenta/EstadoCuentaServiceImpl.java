package com.saludsystem.application.services.paciente.impl.historialClinico.estadoCuenta;

import com.saludsystem.application.dtos.paciente.get.historialclinico.estadocuenta.EstadoCuentaDTO;
import com.saludsystem.application.dtos.paciente.post.historialclinico.estadocuenta.CrearEstadoCuentaDTO;
import com.saludsystem.application.dtos.paciente.put.historialclinico.estadocuenta.ActualizarEstadoCuentaDTO;
import com.saludsystem.application.services.GenericServiceImpl;
import com.saludsystem.application.services.paciente.historialClinico.estadoCuenta.EstadoCuentaService;
import com.saludsystem.domain.exception.ResourceNotFoundException;
import com.saludsystem.domain.model.paciente.EstadoCuenta.EstadoCuentaEntity;
import com.saludsystem.infrastructure.adapters.in.response.ApiResponse;
import com.saludsystem.infrastructure.adapters.in.response.ListResponse;
import com.saludsystem.infrastructure.adapters.out.persistance.repository.paciente.EstadoCuenta.EstadoCuentaRepository;
import com.saludsystem.infrastructure.adapters.out.persistance.repository.paciente.PacienteRepository;
import com.saludsystem.infrastructure.adapters.out.security.util.AuthValidator;
import org.modelmapper.ModelMapper;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class EstadoCuentaServiceImpl extends GenericServiceImpl<EstadoCuentaEntity, EstadoCuentaDTO, UUID,
        CrearEstadoCuentaDTO, ActualizarEstadoCuentaDTO> implements EstadoCuentaService {

    private final PacienteRepository pacienteRepository;

    public EstadoCuentaServiceImpl(
            EstadoCuentaRepository estadoCuentaRepository, ModelMapper modelMapper,
            AuthValidator authValidator, PacienteRepository pacienteRepository) {
        super(estadoCuentaRepository, modelMapper, authValidator, EstadoCuentaDTO.class,
                estadoCuentaEntity -> modelMapper.map(estadoCuentaEntity, EstadoCuentaDTO.class));
        this.pacienteRepository = pacienteRepository;
    }

    @Override
    protected EstadoCuentaEntity convertCreateDtoToEntity(CrearEstadoCuentaDTO crearEstadoCuentaDTO) {
        EstadoCuentaEntity entity = new EstadoCuentaEntity();
        entity.setPacienteEntity(pacienteRepository.findById(crearEstadoCuentaDTO.getPacienteId())
                .orElseThrow( () -> new ResourceNotFoundException("Paciente not found") ));
        entity.setFechaApertura(crearEstadoCuentaDTO.getFechaApertura());
        entity.setEstado(crearEstadoCuentaDTO.getEstado());
        entity.setTotalHospitalizacion(crearEstadoCuentaDTO.getTotalHospitalizacion());
        entity.setTotalMedicamentosEstudios(crearEstadoCuentaDTO.getTotalMedicamentosEstudios());
        entity.setTotalPagado(crearEstadoCuentaDTO.getTotalPagado());
        entity.setSaldoPendiente(crearEstadoCuentaDTO.getSaldoPendiente());
        return entity;
    }

    @Override
    protected void updateEntityFromDto(ActualizarEstadoCuentaDTO actualizarEstadoCuentaDTO, EstadoCuentaEntity entity) {
        entity.setPacienteEntity(pacienteRepository.findById(actualizarEstadoCuentaDTO.getPacienteId())
                .orElseThrow( () -> new ResourceNotFoundException("Paciente not found") ));
        entity.setFechaApertura(actualizarEstadoCuentaDTO.getFechaApertura());
        entity.setEstado(actualizarEstadoCuentaDTO.getEstado());
        entity.setTotalHospitalizacion(actualizarEstadoCuentaDTO.getTotalHospitalizacion());
        entity.setTotalMedicamentosEstudios(actualizarEstadoCuentaDTO.getTotalMedicamentosEstudios());
        entity.setTotalPagado(actualizarEstadoCuentaDTO.getTotalPagado());
        entity.setSaldoPendiente(actualizarEstadoCuentaDTO.getSaldoPendiente());
    }

    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    @Override
    public ApiResponse save(CrearEstadoCuentaDTO crearEstadoCuentaDTO) {
        return super.save(crearEstadoCuentaDTO);
    }

    @Override
    public ListResponse<EstadoCuentaDTO> getAllPaginated(UUID hospitalId, int page, int rows) {
        return super.getAllPaginated(hospitalId, page, rows);
    }

    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    @Override
    public ApiResponse update(UUID uuid, ActualizarEstadoCuentaDTO actualizarEstadoCuentaDTO) {
        return super.update(uuid, actualizarEstadoCuentaDTO);
    }

    @Override
    public EstadoCuentaDTO getById(UUID uuid) {
        return super.getById(uuid);
    }

    @Override
    public List<EstadoCuentaDTO> getList() {
        return super.getList();
    }

    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    @Override
    public ApiResponse delete(UUID uuid) {
        return super.delete(uuid);
    }
}