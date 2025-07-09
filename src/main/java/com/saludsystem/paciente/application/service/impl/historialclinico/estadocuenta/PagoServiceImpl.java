package com.saludsystem.paciente.application.service.impl.historialclinico.estadocuenta;

import com.saludsystem.paciente.application.dto.get.historialclinico.estadocuenta.PagoDTO;
import com.saludsystem.paciente.application.dto.post.historialclinico.estadocuenta.CrearPagoDTO;
import com.saludsystem.paciente.application.dto.put.historialclinico.estadocuenta.ActualizarPagoDTO;
import com.saludsystem.shared.application.service.GenericServiceImpl;
import com.saludsystem.paciente.application.service.historialclinico.estadocuenta.PagoService;
import com.saludsystem.shared.domain.exception.ResourceNotFoundException;
import com.saludsystem.paciente.domain.model.EstadoCuenta.PagoEntity;
import com.saludsystem.shared.infrastructure.adapters.in.response.ApiResponse;
import com.saludsystem.paciente.infrastructure.adapters.out.persistance.estadocuenta.EstadoCuentaRepository;
import com.saludsystem.paciente.infrastructure.adapters.out.persistance.estadocuenta.PagoRepository;
import com.saludsystem.shared.infrastructure.security.util.AuthValidator;
import org.modelmapper.ModelMapper;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class PagoServiceImpl extends GenericServiceImpl<PagoEntity, PagoDTO, CrearPagoDTO,
        ActualizarPagoDTO, UUID> implements PagoService {

    private final EstadoCuentaRepository estadoCuentaRepository;

    public PagoServiceImpl(PagoRepository pagoRepository, ModelMapper modelMapper, AuthValidator authValidator,
                           EstadoCuentaRepository estadoCuentaRepository) {
        super(pagoRepository, modelMapper, authValidator, PagoDTO.class
        );
        this.estadoCuentaRepository = estadoCuentaRepository;
    }

    @Override
    protected PagoEntity convertCreateDtoToEntity(CrearPagoDTO crearPagoDTO) {
        PagoEntity entity = new PagoEntity();
        entity.setEstadoCuentaEntity(estadoCuentaRepository.findById(crearPagoDTO.getPacEstadoCuentaId())
                .orElseThrow( () -> new ResourceNotFoundException("Estado de cuenta not found")));
        entity.setFechaPago(crearPagoDTO.getFechaPago());
        entity.setMonto(crearPagoDTO.getMonto());
        entity.setMetodoPago(crearPagoDTO.getMetodoPago());
        entity.setReferenciaPago(crearPagoDTO.getReferenciaPago());
        return entity;
    }

    @Override
    protected void updateEntityFromDto(PagoEntity entity, ActualizarPagoDTO dto) {
        entity.setFechaPago(dto.getFechaPago());
        entity.setMonto(dto.getMonto());
        entity.setMetodoPago(dto.getMetodoPago());
        entity.setReferenciaPago(dto.getReferenciaPago());
    }

    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    @Override
    public ApiResponse save(CrearPagoDTO crearPagoDTO) {
        return super.save(crearPagoDTO);
    }

    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    @Override
    public ApiResponse update(UUID uuid, ActualizarPagoDTO updateDto) {
        return super.update(uuid, updateDto);
    }

    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    @Override
    public ApiResponse delete(UUID uuid) {
        return super.delete(uuid);
    }
}