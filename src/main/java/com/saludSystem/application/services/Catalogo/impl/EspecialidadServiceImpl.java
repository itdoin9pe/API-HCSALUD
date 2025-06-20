package com.saludSystem.application.services.Catalogo.impl;

import com.saludSystem.application.dtos.Catalogo.PUT.ActualizarEspecialidadDTO;
import com.saludSystem.application.dtos.Catalogo.POST.CrearEspecialidadDTO;
import com.saludSystem.application.dtos.Catalogo.GET.EspecialidadDTO;
import com.saludSystem.application.services.Catalogo.EspecialidadService;
import com.saludSystem.application.services.GenericServiceImpl;
import com.saludSystem.domain.model.Catalogo.EspecialidadEntity;
import com.saludSystem.infrastructure.adapters.out.persistance.repository.Catalogo.EspecialidadRepository;
import com.saludSystem.infrastructure.adapters.in.response.ApiResponse;
import com.saludSystem.infrastructure.adapters.in.response.ListResponse;
import com.saludSystem.infrastructure.adapters.out.security.util.AuthValidator;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;

@Service
public class EspecialidadServiceImpl extends GenericServiceImpl<EspecialidadEntity, EspecialidadDTO, UUID,
        CrearEspecialidadDTO, ActualizarEspecialidadDTO> implements EspecialidadService {

    public EspecialidadServiceImpl(EspecialidadRepository especialidadRepository, ModelMapper modelMapper, AuthValidator authValidator) {
        super(especialidadRepository, modelMapper, authValidator, EspecialidadDTO.class,
                especialidadEntity -> modelMapper.map(especialidadEntity, EspecialidadDTO.class));
    }

    @Override
    public ApiResponse save(CrearEspecialidadDTO crearEspecialidadDTO) {
        return super.save(crearEspecialidadDTO);
    }

    @Override
    public ListResponse<EspecialidadDTO> getAllPaginated(UUID hospitalId, int page, int rows) {
        return super.getAllPaginated(hospitalId, page, rows);
    }

    @Override
    public ApiResponse update(UUID uuid, ActualizarEspecialidadDTO actualizarEspecialidadDTO) {
        return super.update(uuid, actualizarEspecialidadDTO);
    }

    @Override
    public ApiResponse delete(UUID uuid) {
        return super.delete(uuid);
    }

    @Override
    public EspecialidadDTO getById(UUID uuid) {
        return super.getById(uuid);
    }

    @Override
    public List<EspecialidadDTO> getList() {
        return super.getList();
    }

    @Override
    protected EspecialidadEntity convertCreateDtoToEntity(CrearEspecialidadDTO crearEspecialidadDTO) {
        EspecialidadEntity entity = new EspecialidadEntity();
        entity.setNombre(crearEspecialidadDTO.getNombre());
        entity.setDescripcion(crearEspecialidadDTO.getDescripcion());
        entity.setEstado(crearEspecialidadDTO.getEstado());
        return entity;
    }

    @Override
    protected void updateEntityFromDto(ActualizarEspecialidadDTO actualizarEspecialidadDTO, EspecialidadEntity entity) {
        entity.setNombre(actualizarEspecialidadDTO.getNombre());
        entity.setDescripcion(actualizarEspecialidadDTO.getDescripcion());
        entity.setEstado(actualizarEspecialidadDTO.getEstado());
    }
}