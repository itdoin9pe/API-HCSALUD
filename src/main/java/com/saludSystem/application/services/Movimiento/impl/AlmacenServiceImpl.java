package com.saludSystem.application.services.Movimiento.impl;

import com.saludSystem.application.dtos.Movimientos.GET.AlmacenDTO;
import com.saludSystem.application.dtos.Movimientos.POST.CrearAlmacenDTO;
import com.saludSystem.application.dtos.Movimientos.PUT.ActualizarAlmacenDTO;
import com.saludSystem.application.services.GenericServiceImpl;
import com.saludSystem.application.services.Movimiento.AlmacenService;
import com.saludSystem.domain.model.Configuracion.UserEntity;
import com.saludSystem.domain.model.Movimientos.AlmacenEntity;
import com.saludSystem.domain.model.SucursalEntity;
import com.saludSystem.infrastructure.adapters.in.response.ApiResponse;
import com.saludSystem.infrastructure.adapters.in.response.ListResponse;
import com.saludSystem.infrastructure.adapters.out.persistance.SucursalRepository;
import com.saludSystem.infrastructure.adapters.out.persistance.repository.Configuracion.SedeRepository;
import com.saludSystem.infrastructure.adapters.out.persistance.repository.Movimiento.AlmacenRepository;
import com.saludSystem.infrastructure.adapters.out.security.util.AuthValidator;
import org.modelmapper.ModelMapper;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class AlmacenServiceImpl extends GenericServiceImpl<AlmacenEntity, AlmacenDTO, UUID,
        CrearAlmacenDTO, ActualizarAlmacenDTO> implements AlmacenService {

    private final SucursalRepository sucursalRepository;
    private final SedeRepository sedeRepository;

    public AlmacenServiceImpl(AlmacenRepository almacenRepository, ModelMapper modelMapper,
                              AuthValidator authValidator, SucursalRepository sucursalRepository, SedeRepository sedeRepository) {
        super(almacenRepository, modelMapper, authValidator, AlmacenDTO.class,
                almacenEntity -> modelMapper.map(almacenEntity, AlmacenDTO.class));
        this.sucursalRepository = sucursalRepository;
        this.sedeRepository = sedeRepository;
    }

    @Override
    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    public ApiResponse save(CrearAlmacenDTO crearAlmacenDTO) {
        return super.save(crearAlmacenDTO);
    }

    @Override
    protected void beforeSave(AlmacenEntity entity, CrearAlmacenDTO crearAlmacenDTO) {
        UserEntity user = authValidator.getCurrentUser();
        // Buscar sede
        sedeRepository.findById(crearAlmacenDTO.getSedeId())
                .ifPresentOrElse(entity::setSedeEntity,
                        () -> { throw new RuntimeException("Sede no encontrada"); });
        // Buscar primera sucursal disponible
        SucursalEntity sucursal = sucursalRepository.findFirstByOrderBySucursalIdAsc()
                .orElseThrow(() -> new RuntimeException("Sucursal no encontrada"));
        entity.setSucursalEntity(sucursal);
    }

    @Override
    public ListResponse<AlmacenDTO> getAllPaginated(UUID hospitalId, int page, int rows) {
        return super.getAllPaginated(hospitalId, page, rows);
    }

    @Override
    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    public ApiResponse update(UUID uuid, ActualizarAlmacenDTO actualizarAlmacenDTO) {
        return super.update(uuid, actualizarAlmacenDTO);
    }

    @Override
    public AlmacenDTO getById(UUID uuid) {
        return super.getById(uuid);
    }

    @Override
    public List<AlmacenDTO> getList() {
        return super.getList();
    }

    @Override
    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    public ApiResponse delete(UUID uuid) {
        return super.delete(uuid);
    }

    @Override
    protected AlmacenEntity convertCreateDtoToEntity(CrearAlmacenDTO crearAlmacenDTO) {
        AlmacenEntity entity = new AlmacenEntity();
        entity.setNombre(crearAlmacenDTO.getNombre());
        entity.setEstado(crearAlmacenDTO.getEstado());
        return entity;
    }

    @Override
    protected void updateEntityFromDto(ActualizarAlmacenDTO actualizarAlmacenDTO, AlmacenEntity entity) {
        entity.setNombre(actualizarAlmacenDTO.getNombre());
        entity.setEstado(actualizarAlmacenDTO.getEstado());
    }
}