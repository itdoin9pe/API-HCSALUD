package com.saludsystem.mantenimiento.application.service.impl;

import com.saludsystem.mantenimiento.application.dto.res.TarifarioResponse;
import com.saludsystem.mantenimiento.application.dto.req.TarifarioRequest;
import com.saludsystem.shared.application.service.GenericServiceImpl;
import com.saludsystem.mantenimiento.application.service.TarifarioService;
import com.saludsystem.mantenimiento.domain.model.TarifarioEntity;
import com.saludsystem.shared.infrastructure.adapters.in.response.ApiResponse;
import com.saludsystem.shared.infrastructure.adapters.in.response.ListResponse;
import com.saludsystem.catalogo.infrastructure.adapters.out.persistance.CategoriaRepository;
import com.saludsystem.catalogo.infrastructure.adapters.out.persistance.MedidaRepository;
import com.saludsystem.catalogo.infrastructure.adapters.out.persistance.TipoConceptoRepository;
import com.saludsystem.mantenimiento.infrastructure.adapters.out.persistance.TarifarioRepository;
import com.saludsystem.operaciones.infrastructure.adapters.out.persistance.UnidadRepository;
import com.saludsystem.shared.infrastructure.security.util.AuthValidator;
import org.modelmapper.ModelMapper;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class TarifarioServiceImpl extends GenericServiceImpl<TarifarioEntity, TarifarioRequest, TarifarioResponse, UUID>
        implements TarifarioService {

    private final TipoConceptoRepository tipoConceptoRepository;
    private final CategoriaRepository categoriaRepository;
    private final UnidadRepository unidadRepository;
    private final MedidaRepository medidaRepository;

    public TarifarioServiceImpl(
            TarifarioRepository tarifarioRepository, ModelMapper modelMapper,
            AuthValidator authValidator, TipoConceptoRepository tipoConceptoRepository,
            CategoriaRepository categoriaRepository, UnidadRepository unidadRepository,
            MedidaRepository medidaRepository) {
        super(tarifarioRepository, modelMapper, authValidator, TarifarioResponse.class);
        this.tipoConceptoRepository = tipoConceptoRepository;
        this.categoriaRepository = categoriaRepository;
        this.unidadRepository = unidadRepository;
        this.medidaRepository = medidaRepository;
    }

    @Override
    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    public ApiResponse save(TarifarioRequest tarifarioRequest) {
        return super.save(tarifarioRequest);
    }

    @Override
    public ListResponse<TarifarioResponse> getAllPaginated(UUID hospitalId, int page, int rows) {
        return super.getAllPaginated(hospitalId, page, rows);
    }

    @Override
    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    public ApiResponse update(UUID uuid, TarifarioRequest updateDto) {
        return super.update(uuid, updateDto);
    }

    @Override
    public TarifarioResponse getById(UUID uuid) {
        return super.getById(uuid);
    }

    @Override
    public List<TarifarioResponse> getList() {
        return super.getList();
    }

    @Override
    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    public ApiResponse delete(UUID uuid) {
        return super.delete(uuid);
    }

    @Override
    protected TarifarioEntity convertCreateDtoToEntity(TarifarioRequest tarifarioRequest) {
        TarifarioEntity entity = new TarifarioEntity();
        tipoConceptoRepository.findById(tarifarioRequest.getTipoConceptoId()).ifPresent(entity::setTipoConceptoEntity);
        categoriaRepository.findById(tarifarioRequest.getCategoriaId()).ifPresent(entity::setCategoriaEntity);
        unidadRepository.findById(tarifarioRequest.getUnidadId()).ifPresent(entity::setUnidadEntity);
        medidaRepository.findById(tarifarioRequest.getMedidaId()).ifPresent(entity::setMedidaEntity);
        entity.setGrupo(tarifarioRequest.getGrupo());
        entity.setDescripcion(tarifarioRequest.getDescripcion());
        entity.setPrecio(tarifarioRequest.getPrecio());
        entity.setEstado(tarifarioRequest.getEstado());
        return entity;
    }

    @Override
    protected void updateEntityFromDto(TarifarioEntity entity, TarifarioRequest dto) {
        Optional.ofNullable(dto.getTipoConceptoId())
                .flatMap(tipoConceptoRepository::findById)
                .ifPresent(entity::setTipoConceptoEntity);
        Optional.ofNullable(dto.getCategoriaId())
                .flatMap(categoriaRepository::findById)
                .ifPresent(entity::setCategoriaEntity);
        Optional.ofNullable(dto.getUnidadId())
                .flatMap(unidadRepository::findById)
                .ifPresent(entity::setUnidadEntity);
        Optional.ofNullable(dto.getMedidaId())
                .flatMap(medidaRepository::findById)
                .ifPresent(entity::setMedidaEntity);
        Optional.ofNullable(dto.getGrupo())
                .filter(s -> !s.isBlank())
                .ifPresent(entity::setGrupo);
        Optional.ofNullable(dto.getDescripcion())
                .filter(s -> !s.isBlank())
                .ifPresent(entity::setDescripcion);
        Optional.ofNullable(dto.getPrecio()).ifPresent(entity::setPrecio);
        Optional.ofNullable(dto.getEstado()).ifPresent(entity::setEstado);
    }
}