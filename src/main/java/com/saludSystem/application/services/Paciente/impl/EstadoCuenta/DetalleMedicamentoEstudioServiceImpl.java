package com.saludSystem.application.services.Paciente.impl.EstadoCuenta;

import com.saludSystem.application.dtos.Paciente.GET.EstadoCuenta.DetalleMedicamentoEstudioDTO;
import com.saludSystem.application.dtos.Paciente.POST.EstadoCuenta.CrearDetalleMedicamentoEstudioDTO;
import com.saludSystem.application.dtos.Paciente.PUT.EstadoCuenta.ActualizarDetalleMedicamentoEstudioDTO;
import com.saludSystem.application.services.GenericServiceImpl;
import com.saludSystem.application.services.Paciente.EstadoCuenta.DetalleMedicamentoEstudioService;
import com.saludSystem.domain.exception.ResourceNotFoundException;
import com.saludSystem.domain.model.Paciente.EstadoCuenta.DetalleMedicamentosEstudiosEntity;
import com.saludSystem.infrastructure.adapters.in.response.ApiResponse;
import com.saludSystem.infrastructure.adapters.in.response.ListResponse;
import com.saludSystem.infrastructure.adapters.out.persistance.repository.Paciente.EstadoCuenta.DetalleMedicamentoEstudioRepository;
import com.saludSystem.infrastructure.adapters.out.persistance.repository.Paciente.EstadoCuenta.EstadoCuentaRepository;
import com.saludSystem.infrastructure.adapters.out.persistance.repository.Paciente.PacienteRepository;
import com.saludSystem.infrastructure.adapters.out.security.util.AuthValidator;
import org.modelmapper.ModelMapper;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class DetalleMedicamentoEstudioServiceImpl extends GenericServiceImpl<DetalleMedicamentosEstudiosEntity,
        DetalleMedicamentoEstudioDTO, UUID, CrearDetalleMedicamentoEstudioDTO, ActualizarDetalleMedicamentoEstudioDTO>
        implements DetalleMedicamentoEstudioService {

    private final EstadoCuentaRepository estadoCuentaRepository;
    private final PacienteRepository pacienteRepository;

    public DetalleMedicamentoEstudioServiceImpl(
            DetalleMedicamentoEstudioRepository detalleMedicamentoEstudioRepository,
            ModelMapper modelMapper, AuthValidator authValidator, EstadoCuentaRepository estadoCuentaRepository, PacienteRepository pacienteRepository) {
        super(detalleMedicamentoEstudioRepository, modelMapper, authValidator, DetalleMedicamentoEstudioDTO.class,
                detalleMedicamentosEstudiosEntity ->
                        modelMapper.map(detalleMedicamentosEstudiosEntity, DetalleMedicamentoEstudioDTO.class));
        this.estadoCuentaRepository = estadoCuentaRepository;
        this.pacienteRepository = pacienteRepository;
    }

    @Override
    protected DetalleMedicamentosEstudiosEntity convertCreateDtoToEntity(CrearDetalleMedicamentoEstudioDTO crearDetalleMedicamentoEstudioDTO) {
        DetalleMedicamentosEstudiosEntity entity = new DetalleMedicamentosEstudiosEntity();
        entity.setPacienteEntity(pacienteRepository.findById(crearDetalleMedicamentoEstudioDTO.getPacienteId())
                .orElseThrow( () -> new ResourceNotFoundException("Paciente not found")));
        entity.setEstadoCuentaEntity(estadoCuentaRepository.findById(crearDetalleMedicamentoEstudioDTO.getEstadoCuentaId())
                .orElseThrow( () -> new ResourceNotFoundException("Estado de cuenta not found")));
        entity.setTipo(crearDetalleMedicamentoEstudioDTO.getTipo());
        entity.setDescripcion(crearDetalleMedicamentoEstudioDTO.getDescripcion());
        entity.setCantidad(crearDetalleMedicamentoEstudioDTO.getCantidad());
        entity.setCostoUnitario(crearDetalleMedicamentoEstudioDTO.getCostoUnitario());
        entity.setTotalCosto(crearDetalleMedicamentoEstudioDTO.getTotalCosto());
        return entity;
    }

    @Override
    protected void updateEntityFromDto(ActualizarDetalleMedicamentoEstudioDTO actualizarDetalleMedicamentoEstudioDTO, DetalleMedicamentosEstudiosEntity entity) {
        entity.setPacienteEntity(pacienteRepository.findById(actualizarDetalleMedicamentoEstudioDTO.getPacienteId())
                .orElseThrow( () -> new ResourceNotFoundException("Paciente not found")));
        entity.setEstadoCuentaEntity(estadoCuentaRepository.findById(actualizarDetalleMedicamentoEstudioDTO.getEstadoCuentaId())
                .orElseThrow( () -> new ResourceNotFoundException("Estado de cuenta not found")));
        entity.setTipo(actualizarDetalleMedicamentoEstudioDTO.getTipo());
        entity.setDescripcion(actualizarDetalleMedicamentoEstudioDTO.getDescripcion());
        entity.setCantidad(actualizarDetalleMedicamentoEstudioDTO.getCantidad());
        entity.setCostoUnitario(actualizarDetalleMedicamentoEstudioDTO.getCostoUnitario());
        entity.setTotalCosto(actualizarDetalleMedicamentoEstudioDTO.getTotalCosto());
    }

    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    @Override
    public ApiResponse save(CrearDetalleMedicamentoEstudioDTO crearDetalleMedicamentoEstudioDTO) {
        return super.save(crearDetalleMedicamentoEstudioDTO);
    }

    @Override
    public ListResponse<DetalleMedicamentoEstudioDTO> getAllPaginated(UUID hospitalId, int page, int rows) {
        return super.getAllPaginated(hospitalId, page, rows);
    }

    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    @Override
    public ApiResponse update(UUID uuid, ActualizarDetalleMedicamentoEstudioDTO actualizarDetalleMedicamentoEstudioDTO) {
        return super.update(uuid, actualizarDetalleMedicamentoEstudioDTO);
    }

    @Override
    public DetalleMedicamentoEstudioDTO getById(UUID uuid) {
        return super.getById(uuid);
    }

    @Override
    public List<DetalleMedicamentoEstudioDTO> getList() {
        return super.getList();
    }

    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    @Override
    public ApiResponse delete(UUID uuid) {
        return super.delete(uuid);
    }
}