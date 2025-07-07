package com.saludsystem.application.services.paciente.impl.historialclinico.estadocuenta;

import com.saludsystem.application.dtos.paciente.get.historialclinico.estadocuenta.PagoDTO;
import com.saludsystem.application.dtos.paciente.post.historialclinico.estadocuenta.CrearPagoDTO;
import com.saludsystem.application.services.GenericServiceImpl;
import com.saludsystem.application.services.paciente.historialclinico.estadocuenta.PagoService;
import com.saludsystem.domain.exception.ResourceNotFoundException;
import com.saludsystem.domain.model.paciente.EstadoCuenta.PagoEntity;
import com.saludsystem.infrastructure.adapters.in.response.ApiResponse;
import com.saludsystem.infrastructure.adapters.in.response.ListResponse;
import com.saludsystem.infrastructure.adapters.out.persistance.repository.paciente.EstadoCuenta.EstadoCuentaRepository;
import com.saludsystem.infrastructure.adapters.out.persistance.repository.paciente.EstadoCuenta.PagoRepository;
import com.saludsystem.infrastructure.adapters.out.security.util.AuthValidator;
import org.modelmapper.ModelMapper;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class PagoServiceImpl extends GenericServiceImpl<PagoEntity, CrearPagoDTO, PagoDTO, UUID> implements PagoService {

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
        entity.setEstadoCuentaEntity(estadoCuentaRepository.findById(crearPagoDTO.getEstadoCuentaId())
                .orElseThrow( () -> new ResourceNotFoundException("Estado de cuenta not found")));
        entity.setFechaPago(crearPagoDTO.getFechaPago());
        entity.setMonto(crearPagoDTO.getMonto());
        entity.setMetodoPago(crearPagoDTO.getMetodoPago());
        entity.setReferenciaPago(crearPagoDTO.getReferenciaPago());
        return entity;
    }

    @Override
    protected void updateEntityFromDto(PagoEntity entity, CrearPagoDTO dto) {
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

    @Override
    public ListResponse<PagoDTO> getAllPaginated(UUID hospitalId, int page, int rows) {
        return super.getAllPaginated(hospitalId, page, rows);
    }

    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    @Override
    public ApiResponse update(UUID uuid, CrearPagoDTO updateDto) {
        return super.update(uuid, updateDto);
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