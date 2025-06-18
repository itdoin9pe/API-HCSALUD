package com.saludSystem.application.services.Catalogo.impl;

import com.saludSystem.application.dtos.Catalogo.PUT.ActualizarAlergiaDTO;
import com.saludSystem.application.dtos.Catalogo.GET.AlergiaDTO;
import com.saludSystem.application.dtos.Catalogo.POST.CrearAlergiaDTO;
import com.saludSystem.application.services.Catalogo.AlergiaService;
import com.saludSystem.application.services.GenericServiceImpl;
import com.saludSystem.domain.exception.ResourceNotFoundException;
import com.saludSystem.domain.model.Catalogo.AlergiaEntity;
import com.saludSystem.domain.model.Configuracion.SysSaludEntity;
import com.saludSystem.domain.model.Configuracion.UserEntity;
import com.saludSystem.infrastructure.adapters.in.response.ApiResponse;
import com.saludSystem.infrastructure.adapters.in.response.ListResponse;
import com.saludSystem.infrastructure.adapters.out.persistance.repository.Catalogo.AlergiaRepository;
import com.saludSystem.infrastructure.adapters.out.persistance.repository.Configuracion.SysSaludRepository;
import com.saludSystem.infrastructure.adapters.out.security.util.AuthValidator;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class AlergiaServiceImpl extends GenericServiceImpl<AlergiaEntity,
        AlergiaDTO,
        UUID,
        CrearAlergiaDTO,
        ActualizarAlergiaDTO> implements AlergiaService {

    private final SysSaludRepository sysSaludRepository;

    public AlergiaServiceImpl(
            AlergiaRepository alergiaRepository,
            ModelMapper modelMapper,
            AuthValidator authValidator,
            SysSaludRepository sysSaludRepository) {
        super(alergiaRepository,
                modelMapper, authValidator, AlergiaDTO.class,
                alergiaEntity -> modelMapper.map(alergiaEntity, AlergiaDTO.class));
        this.sysSaludRepository = sysSaludRepository;
    }

    @Override
    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    public ApiResponse save(CrearAlergiaDTO dto) {
        UserEntity userEntity = authValidator.getCurrentUser();
        authValidator.validateAdminAccess();
        SysSaludEntity hospital = sysSaludRepository.findById(userEntity.getHospital().getHospitalId())
                .orElseThrow( () -> new ResourceNotFoundException("Hospital no encontrado"));
        AlergiaEntity entity = convertCreateDtoToEntity(dto);
        entity.setUser(userEntity);
        entity.setHospital(hospital);
        genericRepository.save(entity);
        return new ApiResponse(true, "Alergia agregada");
    }

    @Override
    public ListResponse<AlergiaDTO> getAllPaginated(UUID hospitalId, int page, int rows) {
        Pageable pageable = PageRequest.of(page - 1, rows);
        Page<AlergiaEntity> alergiaEntityPage = ((AlergiaRepository)genericRepository).findByHospital_HospitalId(hospitalId, pageable);
        List<AlergiaDTO> data = alergiaEntityPage.getContent().stream().map(toDtoConverter).collect(Collectors.toList());
        return new ListResponse<>(data, alergiaEntityPage.getTotalElements(), alergiaEntityPage.getTotalPages(), alergiaEntityPage.getNumber() + 1);
    }

    @Override
    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    public ApiResponse update(UUID id, ActualizarAlergiaDTO actualizarAlergiaDTO) {
        UserEntity userEntity = authValidator.getCurrentUser();
        authValidator.validateAdminAccess();
        AlergiaEntity alergiaEntity = genericRepository.findById(id)
                .orElseThrow( () -> new ResourceNotFoundException("Alergia no encontrada"));
        updateEntityFromDto(actualizarAlergiaDTO, alergiaEntity);
        alergiaEntity.setUser(userEntity);
        genericRepository.save(alergiaEntity);
        return new ApiResponse(true, "Alergia no encontrada");
    }

    @Override
    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    public ApiResponse delete(UUID id) {
        UserEntity userEntity = authValidator.getCurrentUser();
        authValidator.validateAdminAccess();
        return super.delete(id);
    }

    @Override
    public AlergiaDTO getById(UUID id) {
        return super.getById(id);
    }

    @Override
    @PreAuthorize("hasAuthority('ADMINISTRADOR') or hasAuthority('DOCTOR') or hasAuthority('ENFERMERO')")
    public List<AlergiaDTO> getList() {
        return genericRepository.findAll().stream()
                .map(toDtoConverter)
                .collect(Collectors.toList());
    }

    @Override
    protected AlergiaEntity convertCreateDtoToEntity(CrearAlergiaDTO crearAlergiaDTO) {
        AlergiaEntity entity = new AlergiaEntity();
        entity.setNombre(crearAlergiaDTO.getNombre());
        entity.setEstado(crearAlergiaDTO.getEstado());
        return entity;
    }

    @Override
    protected void updateEntityFromDto(ActualizarAlergiaDTO actualizarAlergiaDTO, AlergiaEntity entity) {
        entity.setNombre(actualizarAlergiaDTO.getNombre());
        entity.setEstado(actualizarAlergiaDTO.getEstado());
    }
}