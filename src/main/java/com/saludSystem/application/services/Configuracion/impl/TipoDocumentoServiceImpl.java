package com.saludSystem.application.services.Configuracion.impl;

import com.saludSystem.application.services.Configuracion.TipoDocumentoService;
import com.saludSystem.application.services.GenericServiceImpl;
import com.saludSystem.application.dtos.Configuracion.PUT.ActualizarTipoDocumentoDTO;
import com.saludSystem.application.dtos.Configuracion.POST.CrearTipoDocumentoDTO;
import com.saludSystem.application.dtos.Configuracion.GET.TipoDocumentoDTO;
import com.saludSystem.domain.model.Configuracion.TipoDocumentoEntity;
import com.saludSystem.infrastructure.adapters.in.response.ApiResponse;
import com.saludSystem.infrastructure.adapters.in.response.ListResponse;
import com.saludSystem.infrastructure.adapters.out.persistance.repository.Configuracion.TipoDocumentoRepository;
import com.saludSystem.infrastructure.adapters.out.security.util.AuthValidator;
import org.modelmapper.ModelMapper;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class TipoDocumentoServiceImpl extends GenericServiceImpl<
        TipoDocumentoEntity, TipoDocumentoDTO, UUID, CrearTipoDocumentoDTO, ActualizarTipoDocumentoDTO>
        implements TipoDocumentoService {

    public TipoDocumentoServiceImpl(TipoDocumentoRepository tipoDocumentoRepository, ModelMapper modelMapper,
                                    AuthValidator authValidator) {
        super(tipoDocumentoRepository, modelMapper, authValidator, TipoDocumentoDTO.class,
                tipoDocumentoEntity -> modelMapper.map(tipoDocumentoEntity, TipoDocumentoDTO.class));
    }

    @Override
    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    public ApiResponse save(CrearTipoDocumentoDTO crearTipoDocumentoDTO) {
        return super.save(crearTipoDocumentoDTO);
    }

    @Override
    public ListResponse<TipoDocumentoDTO> getAllPaginated(UUID hospitalId, int page, int rows) {
        return super.getAllPaginated(hospitalId, page, rows);
    }

    @Override
    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    public ApiResponse update(UUID uuid, ActualizarTipoDocumentoDTO actualizarTipoDocumentoDTO) {
        return super.update(uuid, actualizarTipoDocumentoDTO);
    }

    @Override
    public TipoDocumentoDTO getById(UUID uuid) {
        return super.getById(uuid);
    }

    @Override
    public List<TipoDocumentoDTO> getList() {
        return super.getList();
    }

    @Override
    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    public ApiResponse delete(UUID uuid) {
        return super.delete(uuid);
    }

    @Override
    protected TipoDocumentoEntity convertCreateDtoToEntity(CrearTipoDocumentoDTO crearTipoDocumentoDTO) {
        TipoDocumentoEntity entity = new TipoDocumentoEntity();
        entity.setTipoComprobante(crearTipoDocumentoDTO.getTipoComprobante());
        entity.setSerie(crearTipoDocumentoDTO.getSerie());
        entity.setInicio(crearTipoDocumentoDTO.getInicio());
        entity.setFin(crearTipoDocumentoDTO.getFin());
        entity.setCorrelativoActual(crearTipoDocumentoDTO.getCorrelativoActual());
        entity.setEstado(crearTipoDocumentoDTO.getEstado());
        return entity;
    }

    @Override
    protected void updateEntityFromDto(ActualizarTipoDocumentoDTO actualizarTipoDocumentoDTO, TipoDocumentoEntity entity) {
        entity.setTipoComprobante(actualizarTipoDocumentoDTO.getTipoComprobante());
        entity.setSerie(actualizarTipoDocumentoDTO.getSerie());
        entity.setInicio(actualizarTipoDocumentoDTO.getInicio());
        entity.setFin(actualizarTipoDocumentoDTO.getFin());
        entity.setCorrelativoActual(actualizarTipoDocumentoDTO.getCorrelativoActual());
        entity.setEstado(actualizarTipoDocumentoDTO.getEstado());
    }
}