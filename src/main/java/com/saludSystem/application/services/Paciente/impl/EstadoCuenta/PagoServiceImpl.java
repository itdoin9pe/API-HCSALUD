package com.saludSystem.application.services.Paciente.impl.EstadoCuenta;

import com.saludSystem.application.dtos.Paciente.GET.EstadoCuenta.PagoDTO;
import com.saludSystem.application.dtos.Paciente.POST.EstadoCuenta.CrearPagoDTO;
import com.saludSystem.application.dtos.Paciente.PUT.EstadoCuenta.ActualizarPagoDTO;
import com.saludSystem.application.services.GenericServiceImpl;
import com.saludSystem.application.services.Paciente.EstadoCuenta.PagoService;
import com.saludSystem.domain.exception.ResourceNotFoundException;
import com.saludSystem.domain.model.Paciente.EstadoCuenta.PagoEntity;
import com.saludSystem.infrastructure.adapters.in.response.ApiResponse;
import com.saludSystem.infrastructure.adapters.in.response.ListResponse;
import com.saludSystem.infrastructure.adapters.out.persistance.repository.Paciente.EstadoCuenta.EstadoCuentaRepository;
import com.saludSystem.infrastructure.adapters.out.persistance.repository.Paciente.EstadoCuenta.PagoRepository;
import com.saludSystem.infrastructure.adapters.out.security.util.AuthValidator;
import org.modelmapper.ModelMapper;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class PagoServiceImpl extends GenericServiceImpl<PagoEntity, PagoDTO, UUID,
        CrearPagoDTO, ActualizarPagoDTO> implements PagoService {

    private final EstadoCuentaRepository estadoCuentaRepository;

    public PagoServiceImpl(PagoRepository pagoRepository, ModelMapper modelMapper, AuthValidator authValidator, EstadoCuentaRepository estadoCuentaRepository) {
        super(pagoRepository, modelMapper, authValidator, PagoDTO.class,
                pagoEntity -> modelMapper.map(pagoEntity, PagoDTO.class));
        this.estadoCuentaRepository = estadoCuentaRepository;
    }

    @Override
    protected PagoEntity convertCreateDtoToEntity(CrearPagoDTO crearPagoDTO) {
        PagoEntity entity = new PagoEntity();
        entity.setEstadoCuentaEntity(estadoCuentaRepository.findById(crearPagoDTO.getEstadoCuentaId())
                .orElseThrow( () -> new ResourceNotFoundException("Estado de cuenta not found")));
        entity.setFechaPago(crearPagoDTO.getFechaPago());
        entity.setMonto(crearPagoDTO.getMonto());
        entity.setMetodoPago(crearPagoDTO.getMetodoPago());
        entity.setReferenciaPago(crearPagoDTO.getReferenciaPago());
        return entity;
    }

    @Override
    protected void updateEntityFromDto(ActualizarPagoDTO actualizarPagoDTO, PagoEntity entity) {
        entity.setEstadoCuentaEntity(estadoCuentaRepository.findById(actualizarPagoDTO.getEstadoCuentaId())
                .orElseThrow( () -> new ResourceNotFoundException("Estado de cuenta not found")));
        entity.setFechaPago(actualizarPagoDTO.getFechaPago());
        entity.setMonto(actualizarPagoDTO.getMonto());
        entity.setMetodoPago(actualizarPagoDTO.getMetodoPago());
        entity.setReferenciaPago(actualizarPagoDTO.getReferenciaPago());
    }

    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    @Override
    public ApiResponse save(CrearPagoDTO crearPagoDTO) {
        return super.save(crearPagoDTO);
    }

    @Override
    public ListResponse<PagoDTO> getAllPaginated(UUID hospitalId, int page, int rows) {
        return super.getAllPaginated(hospitalId, page, rows);
    }

    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    @Override
    public ApiResponse update(UUID uuid, ActualizarPagoDTO actualizarPagoDTO) {
        return super.update(uuid, actualizarPagoDTO);
    }

    @Override
    public List<PagoDTO> getList() {
        return super.getList();
    }

    @Override
    public PagoDTO getById(UUID uuid) {
        return super.getById(uuid);
    }

    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    @Override
    public ApiResponse delete(UUID uuid) {
        return super.delete(uuid);
    }
}