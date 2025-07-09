package com.saludsystem.shared.application.service;

import com.saludsystem.shared.domain.model.BaseEntity;
import com.saludsystem.shared.domain.exception.ResourceNotFoundException;
import com.saludsystem.configuracion.domain.model.UserEntity;
import com.saludsystem.shared.infrastructure.adapters.out.persistance.GenericRepository;
import com.saludsystem.shared.infrastructure.adapters.in.response.ApiResponse;
import com.saludsystem.shared.infrastructure.adapters.in.response.ListResponse;
import com.saludsystem.shared.infrastructure.security.util.AuthValidator;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.UUID;
import java.util.function.Function;

public abstract class GenericServiceImpl<E extends BaseEntity, R, C, U, I>
        implements GenericService<R, C, U, I> {

    protected final GenericRepository<E> genericRepository;
    protected final ModelMapper modelMapper;
    protected final AuthValidator authValidator;
    protected final Class<R> dtoClass;
    protected Function<E, R> toDtoConverter;

    protected GenericServiceImpl(GenericRepository<E> genericRepository, ModelMapper modelMapper, AuthValidator authValidator, Class<R> dtoClass) {
        this.genericRepository = genericRepository;
        this.modelMapper = modelMapper;
        this.authValidator = authValidator;
        this.dtoClass = dtoClass;
        this.toDtoConverter = entity -> modelMapper.map(entity, dtoClass);
    }

    @Transactional
    @Override
    public ApiResponse save(C createDto) {
        UserEntity currentUser = authValidator.getCurrentUser();// Obtener usuario actual y validar acceso
        authValidator.validateAdminAccess(); // Opcional: hacer configurable
        E entity = convertCreateDtoToEntity(createDto); // Convertir DTO a entidad
        entity.setUser(currentUser);        // Asignar información de auditoría
        entity.setHospital(currentUser.getHospital());
        beforeSave(entity, createDto);     // Lógica pre-guardado específica (si es necesaria)
        genericRepository.save(entity);    // Guardar entidad
        return buildSuccessResponse();        // Construir respuesta
    }

    // Método hook para lógica específica antes de guardar
    protected void beforeSave(E entity, C dto) {
        // Puede ser sobrescrito por implementaciones concretas
    }

    // Método para construir respuesta exitosa
    protected ApiResponse buildSuccessResponse() {
        return new ApiResponse(true, "Registro creado exitosamente");
    }

    @Override
    public List<R> getList() {
        return genericRepository.findAll().stream()
                .map(toDtoConverter)
                .toList();
    }

    @Override
    public R getById(I id) {
        E entity = genericRepository.findById((UUID) id)
                .orElseThrow(() -> new ResourceNotFoundException("Registro no encontrado"));
        return toDtoConverter.apply(entity);
    }

    @Transactional
    @Override
    public ApiResponse update(I id, U updateDto) {
        E entity = genericRepository.findById((UUID) id)
                .orElseThrow(() -> new ResourceNotFoundException("Registro no encontrado"));
        updateEntityFromDto(entity, updateDto);
        genericRepository.save(entity);
        return new ApiResponse(true, "Registro actualizado exitosamente");
    }

    @Override
    public ListResponse<R> getAllPaginated(UUID hospitalId, int page, int rows) {
        Pageable pageable = PageRequest.of(page - 1, rows);
        Page<E> entityPage = genericRepository.findByHospital_HospitalId(hospitalId, pageable);
        List<R> data = entityPage.getContent().stream()
                .map(toDtoConverter)
                .toList();
        return new ListResponse<>(
                data,
                entityPage.getTotalElements(),
                entityPage.getTotalPages(),
                entityPage.getNumber() + 1
        );
    }

    @Transactional
    @Override
    public ApiResponse delete(I id) {
        genericRepository.deleteById((UUID) id);
        return new ApiResponse(true, "Registro eliminado exitosamente");
    }

    protected abstract E convertCreateDtoToEntity(C dto);
    protected abstract void updateEntityFromDto(E entity, U dto);
}