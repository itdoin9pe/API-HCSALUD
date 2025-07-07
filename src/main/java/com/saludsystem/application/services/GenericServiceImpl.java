package com.saludsystem.application.services;

import com.saludsystem.domain.exception.ResourceNotFoundException;
import com.saludsystem.domain.model.BaseEntity;
import com.saludsystem.domain.model.configuracion.UserEntity;
import com.saludsystem.infrastructure.adapters.in.response.ApiResponse;
import com.saludsystem.infrastructure.adapters.in.response.ListResponse;
import com.saludsystem.infrastructure.adapters.out.persistance.repository.GenericRepository;
import com.saludsystem.infrastructure.adapters.out.security.util.AuthValidator;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.UUID;
import java.util.function.Function;
import java.util.stream.Collectors;

public abstract class GenericServiceImpl<E extends BaseEntity, REQ, RES, ID>
        implements GenericService<REQ, RES, ID> {

    protected final GenericRepository<E> genericRepository;
    protected final ModelMapper modelMapper;
    protected final AuthValidator authValidator;
    protected final Class<RES> dtoClass;
    protected Function<E, RES> toDtoConverter;

    protected GenericServiceImpl(GenericRepository<E> genericRepository, ModelMapper modelMapper, AuthValidator authValidator, Class<RES> dtoClass) {
        this.genericRepository = genericRepository;
        this.modelMapper = modelMapper;
        this.authValidator = authValidator;
        this.dtoClass = dtoClass;
        this.toDtoConverter = toDtoConverter;
    }

    @Transactional
    @Override
    public ApiResponse save(REQ createDto) {
        UserEntity currentUser = authValidator.getCurrentUser();// Obtener usuario actual y validar acceso
        authValidator.validateAdminAccess(); // Opcional: hacer configurable
        E entity = convertCreateDtoToEntity(createDto); // Convertir DTO a entidad
        entity.setUser(currentUser);        // Asignar información de auditoría
        entity.setHospital(currentUser.getHospital());
        beforeSave(entity, createDto);     // Lógica pre-guardado específica (si es necesaria)
        genericRepository.save(entity);    // Guardar entidad
        return buildSuccessResponse(entity);        // Construir respuesta
    }

    // Método hook para lógica específica antes de guardar
    protected void beforeSave(E entity, REQ dto) {
        // Puede ser sobrescrito por implementaciones concretas
    }

    // Método para construir respuesta exitosa
    protected ApiResponse buildSuccessResponse(E entity) {
        return new ApiResponse(true, "Registro creado exitosamente");
    }

    @Override
    public List<RES> getList() {
        return genericRepository.findAll().stream()
                .map(toDtoConverter)
                .collect(Collectors.toList());
    }

    @Override
    public RES getById(ID id) {
        E entity = genericRepository.findById((UUID) id)
                .orElseThrow(() -> new ResourceNotFoundException("Registro no encontrado"));
        return toDtoConverter.apply(entity);
    }

    @Transactional
    @Override
    public ApiResponse update(ID id, REQ updateDto) {
        E entity = genericRepository.findById((UUID) id)
                .orElseThrow(() -> new ResourceNotFoundException("Registro no encontrado"));
        updateEntityFromDto(entity, updateDto);
        genericRepository.save(entity);
        return new ApiResponse(true, "Registro actualizado exitosamente");
    }

    @Override
    public ListResponse<RES> getAllPaginated(UUID hospitalId, int page, int rows) {
        Pageable pageable = PageRequest.of(page - 1, rows);
        Page<E> entityPage = genericRepository.findByHospital_HospitalId(hospitalId, pageable);
        List<RES> data = entityPage.getContent().stream()
                .map(toDtoConverter)
                .collect(Collectors.toList());
        return new ListResponse<>(
                data,
                entityPage.getTotalElements(),
                entityPage.getTotalPages(),
                entityPage.getNumber() + 1
        );
    }

    @Transactional
    @Override
    public ApiResponse delete(ID id) {
        genericRepository.deleteById((UUID) id);
        return new ApiResponse(true, "Registro eliminado exitosamente");
    }

    protected abstract E convertCreateDtoToEntity(REQ dto);
    protected abstract void updateEntityFromDto(E entity, REQ dto);
}