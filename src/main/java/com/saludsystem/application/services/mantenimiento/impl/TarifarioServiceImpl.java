package com.saludsystem.application.services.mantenimiento.impl;

import com.saludsystem.application.dtos.mantenimiento.get.TarifarioDTO;
import com.saludsystem.application.dtos.mantenimiento.post.CrearTarifarioDTO;
import com.saludsystem.application.dtos.mantenimiento.put.ActualizarTarifarioDTO;
import com.saludsystem.application.services.GenericServiceImpl;
import com.saludsystem.application.services.mantenimiento.TarifarioService;
import com.saludsystem.domain.model.mantenimiento.TarifarioEntity;
import com.saludsystem.infrastructure.adapters.in.response.ApiResponse;
import com.saludsystem.infrastructure.adapters.in.response.ListResponse;

import com.saludsystem.infrastructure.adapters.out.persistance.repository.catalogo.CategoriaRepository;
import com.saludsystem.infrastructure.adapters.out.persistance.repository.catalogo.MedidaRepository;
import com.saludsystem.infrastructure.adapters.out.persistance.repository.catalogo.TipoConceptoRepository;
import com.saludsystem.infrastructure.adapters.out.persistance.repository.mantenimiento.TarifarioRepository;
import com.saludsystem.infrastructure.adapters.out.persistance.repository.operaciones.UnidadRepository;
import com.saludsystem.infrastructure.adapters.out.security.util.AuthValidator;
import org.modelmapper.ModelMapper;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class TarifarioServiceImpl extends GenericServiceImpl<TarifarioEntity, TarifarioDTO, UUID,
        CrearTarifarioDTO, ActualizarTarifarioDTO> implements TarifarioService {

    private final TipoConceptoRepository tipoConceptoRepository;
    private final CategoriaRepository categoriaRepository;
    private final UnidadRepository unidadRepository;
    private final MedidaRepository medidaRepository;

    public TarifarioServiceImpl(TarifarioRepository tarifarioRepository, ModelMapper modelMapper,
                                AuthValidator authValidator, TipoConceptoRepository tipoConceptoRepository, CategoriaRepository categoriaRepository, UnidadRepository unidadRepository, MedidaRepository medidaRepository) {
        super(tarifarioRepository, modelMapper, authValidator, TarifarioDTO.class,
                tarifarioEntity -> modelMapper.map(tarifarioEntity, TarifarioDTO.class));
        this.tipoConceptoRepository = tipoConceptoRepository;
        this.categoriaRepository = categoriaRepository;
        this.unidadRepository = unidadRepository;
        this.medidaRepository = medidaRepository;
    }

    @Override
    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    public ApiResponse save(CrearTarifarioDTO crearTarifarioDTO) {
        return super.save(crearTarifarioDTO);
    }

    @Override
    public ListResponse<TarifarioDTO> getAllPaginated(UUID hospitalId, int page, int rows) {
        return super.getAllPaginated(hospitalId, page, rows);
    }

    @Override
    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    public ApiResponse update(UUID uuid, ActualizarTarifarioDTO actualizarTarifarioDTO) {
        return super.update(uuid, actualizarTarifarioDTO);
    }

    @Override
    public TarifarioDTO getById(UUID uuid) {
        return super.getById(uuid);
    }

    @Override
    public List<TarifarioDTO> getList() {
        return super.getList();
    }

    @Override
    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    public ApiResponse delete(UUID uuid) {
        return super.delete(uuid);
    }

    @Override
    protected TarifarioEntity convertCreateDtoToEntity(CrearTarifarioDTO crearTarifarioDTO) {
        TarifarioEntity entity = new TarifarioEntity();
        tipoConceptoRepository.findById(crearTarifarioDTO.getTipoConceptoId()).ifPresent(entity::setTipoConceptoEntity);
        categoriaRepository.findById(crearTarifarioDTO.getCategoriaId()).ifPresent(entity::setCategoriaEntity);
        unidadRepository.findById(crearTarifarioDTO.getUnidadId()).ifPresent(entity::setUnidadEntity);
        medidaRepository.findById(crearTarifarioDTO.getMedidaId()).ifPresent(entity::setMedidaEntity);
        entity.setGrupo(crearTarifarioDTO.getGrupo());
        entity.setDescripcion(crearTarifarioDTO.getDescripcion());
        entity.setPrecio(crearTarifarioDTO.getPrecio());
        entity.setEstado(crearTarifarioDTO.getEstado());
        return entity;
    }

    @Override
    protected void updateEntityFromDto(ActualizarTarifarioDTO actualizarTarifarioDTO, TarifarioEntity entity) {
        Optional.ofNullable(actualizarTarifarioDTO.getTipoConceptoId())
                .flatMap(tipoConceptoRepository::findById)
                .ifPresent(entity::setTipoConceptoEntity);
        Optional.ofNullable(actualizarTarifarioDTO.getCategoriaId())
                .flatMap(categoriaRepository::findById)
                .ifPresent(entity::setCategoriaEntity);
        Optional.ofNullable(actualizarTarifarioDTO.getUnidadId())
                .flatMap(unidadRepository::findById)
                .ifPresent(entity::setUnidadEntity);
        Optional.ofNullable(actualizarTarifarioDTO.getMedidaId())
                .flatMap(medidaRepository::findById)
                .ifPresent(entity::setMedidaEntity);
        Optional.ofNullable(actualizarTarifarioDTO.getGrupo())
                .filter(s -> !s.isBlank())
                .ifPresent(entity::setGrupo);
        Optional.ofNullable(actualizarTarifarioDTO.getDescripcion())
                .filter(s -> !s.isBlank())
                .ifPresent(entity::setDescripcion);
        Optional.ofNullable(actualizarTarifarioDTO.getPrecio()).ifPresent(entity::setPrecio);
        Optional.ofNullable(actualizarTarifarioDTO.getEstado()).ifPresent(entity::setEstado);
    }
}