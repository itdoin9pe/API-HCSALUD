package com.saludSystem.application.services.Catalogo.impl;

import com.saludSystem.application.dtos.Catalogo.GET.MedicamentoDTO;
import com.saludSystem.application.dtos.Catalogo.POST.CrearMedicamentoDTO;
import com.saludSystem.application.dtos.Catalogo.PUT.ActualizarMedicamentoDTO;
import com.saludSystem.application.services.Catalogo.MedicamentoService;
import com.saludSystem.application.services.GenericServiceImpl;
import com.saludSystem.domain.exception.ResourceNotFoundException;
import com.saludSystem.domain.model.Catalogo.MedicamentoEntity;
import com.saludSystem.domain.model.Configuracion.SysSaludEntity;
import com.saludSystem.domain.model.Configuracion.UserEntity;
import com.saludSystem.infrastructure.adapters.in.response.ApiResponse;
import com.saludSystem.infrastructure.adapters.in.response.ListResponse;
import com.saludSystem.infrastructure.adapters.out.persistance.repository.Catalogo.MedicamentoRepository;
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
public class MedicamentoServiceImpl extends GenericServiceImpl<MedicamentoEntity,
        MedicamentoDTO,
        UUID,
        CrearMedicamentoDTO,
        ActualizarMedicamentoDTO> implements MedicamentoService {

    private final SysSaludRepository sysSaludRepository;

    public MedicamentoServiceImpl(
            MedicamentoRepository repository,
            ModelMapper modelMapper,
            AuthValidator authValidator,
            SysSaludRepository sysSaludRepository) {
        super(
                repository,
                modelMapper,
                authValidator,
                MedicamentoDTO.class,
                entity -> modelMapper.map(entity, MedicamentoDTO.class)
        );
        this.sysSaludRepository = sysSaludRepository;
    }

    @Override
    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    public ApiResponse save(CrearMedicamentoDTO dto) {
        UserEntity userEntity = authValidator.getCurrentUser();
        authValidator.validateAdminAccess();
        SysSaludEntity hospital = sysSaludRepository.findById(userEntity.getHospital().getHospitalId())
                .orElseThrow(() -> new RuntimeException("Hospital no encontrado"));
        MedicamentoEntity entity = convertCreateDtoToEntity(dto);
        entity.setHospital(hospital);
        entity.setUser(userEntity);
        genericRepository.save(entity);
        return new ApiResponse(true, "Medicamento agregado correctamente");
    }

    // Si necesitas métodos específicos que no están en GenericService
    @Override
    public ListResponse<MedicamentoDTO> getAllPaginated(UUID hospitalId, int page, int rows) {
        Pageable pageable = PageRequest.of(page - 1, rows);
        Page<MedicamentoEntity> entityPage = ((MedicamentoRepository)genericRepository).findByHospital_HospitalId(hospitalId, pageable);
        List<MedicamentoDTO> data = entityPage.getContent().stream()
                .map(toDtoConverter)
                .collect(Collectors.toList());
        return new ListResponse<>(
                data,
                entityPage.getTotalElements(),
                entityPage.getTotalPages(),
                entityPage.getNumber() + 1
        );
    }

    @Override
    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    public ApiResponse update(UUID id, ActualizarMedicamentoDTO dto) {
        UserEntity userEntity = authValidator.getCurrentUser();
        authValidator.validateAdminAccess();
        MedicamentoEntity entity = genericRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Medicamento no encontrado"));
        updateEntityFromDto(dto, entity);
        entity.setUser(userEntity); // actualizar quién hizo el cambio, si es necesario
        genericRepository.save(entity);
        return new ApiResponse(true, "Medicamento actualizado correctamente");
    }

    @Override
    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    public ApiResponse delete(UUID id) {
        UserEntity userEntity = authValidator.getCurrentUser();
        authValidator.validateAdminAccess();
        return super.delete(id);
    }

    @Override
    public MedicamentoDTO getById(UUID id) {
        // Puedes añadir lógica adicional si es necesario
        return super.getById(id);
    }

    @Override
    protected MedicamentoEntity convertCreateDtoToEntity(CrearMedicamentoDTO dto) {
        MedicamentoEntity entity = new MedicamentoEntity();
        entity.setNombre(dto.getNombre());
        entity.setFormaFarmaceutica(dto.getFormaFarmaceutica());
        entity.setConcentracion(dto.getConcentracion());
        entity.setContenido(dto.getContenido());
        entity.setEstado(dto.getEstado());
        return entity;
    }

    @Override
    protected void updateEntityFromDto(ActualizarMedicamentoDTO dto, MedicamentoEntity entity) {
        entity.setNombre(dto.getNombre());
        entity.setContenido(dto.getContenido());
        entity.setConcentracion(dto.getConcentracion());
        entity.setFormaFarmaceutica(dto.getFormaFarmaceutica());
        entity.setEstado(dto.getEstado());
    }
}