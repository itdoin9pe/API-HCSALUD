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

public abstract class GenericServiceImpl<T extends BaseEntity, DTO, ID, CREATE_DTO, UPDATE_DTO>
        implements GenericService<DTO, ID, CREATE_DTO, UPDATE_DTO> {

    protected final GenericRepository<T> genericRepository;
    protected final ModelMapper modelMapper;
    protected final AuthValidator authValidator;
    protected final Class<DTO> dtoClass;
    protected final Function<T, DTO> toDtoConverter;

    public GenericServiceImpl(GenericRepository<T> genericRepository, ModelMapper modelMapper, AuthValidator authValidator, Class<DTO> dtoClass, Function<T, DTO> toDtoConverter) {
        this.genericRepository = genericRepository;
        this.modelMapper = modelMapper;
        this.authValidator = authValidator;
        this.dtoClass = dtoClass;
        this.toDtoConverter = toDtoConverter;
    }

    @Transactional
    @Override
    public ApiResponse save(CREATE_DTO createDto) {
        UserEntity currentUser = authValidator.getCurrentUser();// Obtener usuario actual y validar acceso
        authValidator.validateAdminAccess(); // Opcional: hacer configurable
        T entity = convertCreateDtoToEntity(createDto); // Convertir DTO a entidad
        entity.setUser(currentUser);        // Asignar información de auditoría
        entity.setHospital(currentUser.getHospital());
        beforeSave(entity, createDto);     // Lógica pre-guardado específica (si es necesaria)
        genericRepository.save(entity);    // Guardar entidad
        return buildSuccessResponse(entity);        // Construir respuesta
    }

    // Método hook para lógica específica antes de guardar
    protected void beforeSave(T entity, CREATE_DTO dto) {
        // Puede ser sobrescrito por implementaciones concretas
    }

    // Método para construir respuesta exitosa
    protected ApiResponse buildSuccessResponse(T entity) {
        return new ApiResponse(true, "Registro creado exitosamente");
    }

    @Override
    public List<DTO> getList() {
        return genericRepository.findAll().stream()
                .map(toDtoConverter)
                .collect(Collectors.toList());
    }

    @Override
    public DTO getById(ID id) {
        T entity = genericRepository.findById((UUID) id)
                .orElseThrow(() -> new ResourceNotFoundException("Registro no encontrado"));
        return toDtoConverter.apply(entity);
    }

    @Transactional
    @Override
    public ApiResponse update(ID id, UPDATE_DTO updateDto) {
        T entity = genericRepository.findById((UUID) id)
                .orElseThrow(() -> new ResourceNotFoundException("Registro no encontrado"));
        updateEntityFromDto(updateDto, entity);
        genericRepository.save(entity);
        return new ApiResponse(true, "Registro actualizado exitosamente");
    }

    @Override
    public ListResponse<DTO> getAllPaginated(UUID hospitalId, int page, int rows) {
        Pageable pageable = PageRequest.of(page - 1, rows);
        Page<T> entityPage = genericRepository.findByHospital_HospitalId(hospitalId, pageable);
        List<DTO> data = entityPage.getContent().stream()
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

    protected abstract T convertCreateDtoToEntity(CREATE_DTO dto);
    protected abstract void updateEntityFromDto(UPDATE_DTO dto, T entity);
}