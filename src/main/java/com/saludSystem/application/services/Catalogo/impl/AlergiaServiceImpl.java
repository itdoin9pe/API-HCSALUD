package com.saludSystem.application.services.Catalogo.impl;

import com.saludSystem.application.dtos.Catalogo.PUT.ActualizarAlergiaDTO;
import com.saludSystem.application.dtos.Catalogo.GET.AlergiaDTO;
import com.saludSystem.application.dtos.Catalogo.POST.CrearAlergiaDTO;
import com.saludSystem.application.services.Catalogo.AlergiaService;
import com.saludSystem.application.services.GenericServiceImpl;
import com.saludSystem.domain.model.Catalogo.AlergiaEntity;
import com.saludSystem.infrastructure.adapters.in.response.ApiResponse;
import com.saludSystem.infrastructure.adapters.in.response.ListResponse;
import com.saludSystem.infrastructure.adapters.out.persistance.repository.Catalogo.AlergiaRepository;
import com.saludSystem.infrastructure.adapters.out.persistance.repository.Configuracion.SysSaludRepository;
import com.saludSystem.infrastructure.adapters.out.security.util.AuthValidator;
import org.modelmapper.ModelMapper;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class AlergiaServiceImpl extends GenericServiceImpl<AlergiaEntity, AlergiaDTO, UUID, CrearAlergiaDTO,
        ActualizarAlergiaDTO> implements AlergiaService {

    private final SysSaludRepository sysSaludRepository;

    public AlergiaServiceImpl(AlergiaRepository alergiaRepository, ModelMapper modelMapper, AuthValidator authValidator,
            SysSaludRepository sysSaludRepository) {
        super(alergiaRepository,
                modelMapper, authValidator, AlergiaDTO.class,
                alergiaEntity -> modelMapper.map(alergiaEntity, AlergiaDTO.class));
        this.sysSaludRepository = sysSaludRepository;
    }

    @Override
    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    public ApiResponse save(CrearAlergiaDTO dto) {
        return super.save(dto);
    }

    @Override
    public ListResponse<AlergiaDTO> getAllPaginated(UUID hospitalId, int page, int rows) {
        return super.getAllPaginated(hospitalId, page, rows);
    }

    @Override
    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    public ApiResponse update(UUID id, ActualizarAlergiaDTO actualizarAlergiaDTO) {
        return super.update(id, actualizarAlergiaDTO);
    }

    @Override
    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    public ApiResponse delete(UUID id) {
        return super.delete(id);
    }

    @Override
    public AlergiaDTO getById(UUID id) {
        return super.getById(id);
    }

    @Override
    public List<AlergiaDTO> getList() {
        return super.getList();
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