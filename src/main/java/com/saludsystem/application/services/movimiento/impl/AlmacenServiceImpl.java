package com.saludsystem.application.services.movimiento.impl;

import com.saludsystem.application.dtos.movimientos.get.AlmacenDTO;
import com.saludsystem.application.dtos.movimientos.post.CrearAlmacenDTO;
import com.saludsystem.application.services.GenericServiceImpl;
import com.saludsystem.application.services.movimiento.AlmacenService;
import com.saludsystem.domain.model.SucursalEntity;
import com.saludsystem.domain.model.configuracion.UserEntity;
import com.saludsystem.domain.model.movimientos.AlmacenEntity;
import com.saludsystem.infrastructure.adapters.in.response.ApiResponse;
import com.saludsystem.infrastructure.adapters.in.response.ListResponse;
import com.saludsystem.infrastructure.adapters.out.persistance.SucursalRepository;
import com.saludsystem.infrastructure.adapters.out.persistance.repository.configuracion.SedeRepository;
import com.saludsystem.infrastructure.adapters.out.persistance.repository.movimiento.AlmacenRepository;
import com.saludsystem.infrastructure.adapters.out.security.util.AuthValidator;
import org.modelmapper.ModelMapper;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class AlmacenServiceImpl extends GenericServiceImpl<AlmacenEntity, CrearAlmacenDTO, AlmacenDTO, UUID>
        implements AlmacenService {

    private final SucursalRepository sucursalRepository;
    private final SedeRepository sedeRepository;

    public AlmacenServiceImpl(
            AlmacenRepository almacenRepository, ModelMapper modelMapper,
            AuthValidator authValidator, SucursalRepository sucursalRepository, SedeRepository sedeRepository) {
        super(almacenRepository, modelMapper, authValidator, AlmacenDTO.class);
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
    public ApiResponse update(UUID uuid, CrearAlmacenDTO updateDto) {
        return super.update(uuid, updateDto);
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
    protected void updateEntityFromDto(AlmacenEntity entity, CrearAlmacenDTO dto) {
        Optional.ofNullable(dto.getNombre()).ifPresent(entity::setNombre);
        Optional.ofNullable(dto.getEstado()).ifPresent(entity::setEstado);
    }
}