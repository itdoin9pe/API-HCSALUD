package com.saludSystem.application.services.Movimiento.impl;

import com.saludSystem.application.dtos.Movimientos.GET.InventarioDTO;
import com.saludSystem.application.dtos.Movimientos.POST.CrearInventarioDTO;
import com.saludSystem.application.dtos.Movimientos.PUT.ActualizarInventarioDTO;
import com.saludSystem.application.services.Movimiento.InventarioProjection;
import com.saludSystem.application.services.Movimiento.InventarioService;
import com.saludSystem.domain.exception.ResourceNotFoundException;
import com.saludSystem.domain.model.Configuracion.SysSaludEntity;
import com.saludSystem.domain.model.Configuracion.UserEntity;
import com.saludSystem.domain.model.Movimientos.InventarioEntity;
import com.saludSystem.infrastructure.adapters.in.response.ApiResponse;
import com.saludSystem.infrastructure.adapters.in.response.ListResponse;
import com.saludSystem.infrastructure.adapters.out.persistance.repository.Configuracion.SysSaludRepository;
import com.saludSystem.infrastructure.adapters.out.persistance.repository.Movimiento.AlmacenRepository;
import com.saludSystem.infrastructure.adapters.out.persistance.repository.Movimiento.InventarioRepository;
import com.saludSystem.infrastructure.adapters.out.persistance.repository.Operaciones.CategoriaMatRepository;
import com.saludSystem.infrastructure.adapters.out.persistance.repository.Operaciones.MarcaRepository;
import com.saludSystem.infrastructure.adapters.out.persistance.repository.Operaciones.ProductoRepository;
import com.saludSystem.infrastructure.adapters.out.persistance.repository.Operaciones.UnidadRepository;
import com.saludSystem.infrastructure.adapters.out.security.util.AuthValidator;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class InventarioServiceImpl implements InventarioService {

    private final InventarioRepository inventarioRepository;
    private final AuthValidator authValidator;
    private final SysSaludRepository sysSaludRepository;
    private final ProductoRepository productoRepository;
    private final MarcaRepository marcaRepository;
    private final CategoriaMatRepository categoriaMatRepository;
    private final AlmacenRepository almacenRepository;
    private final UnidadRepository unidadRepository;
    private final ModelMapper modelMapper;

    public InventarioServiceImpl(InventarioRepository inventarioRepository, AuthValidator authValidator, SysSaludRepository sysSaludRepository, ProductoRepository productoRepository, MarcaRepository marcaRepository, CategoriaMatRepository categoriaMatRepository, AlmacenRepository almacenRepository, UnidadRepository unidadRepository, ModelMapper modelMapper) {
        this.inventarioRepository = inventarioRepository;
        this.authValidator = authValidator;
        this.sysSaludRepository = sysSaludRepository;
        this.productoRepository = productoRepository;
        this.marcaRepository = marcaRepository;
        this.categoriaMatRepository = categoriaMatRepository;
        this.almacenRepository = almacenRepository;
        this.unidadRepository = unidadRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    public ApiResponse saveInventario(CrearInventarioDTO crearInventarioDTO) {
        UserEntity userEntity = authValidator.getCurrentUser();
        authValidator.validateAdminAccess(); // Lanza excepción si no es admin
        SysSaludEntity hospital = sysSaludRepository.findById(userEntity.getHospital().getHospitalId()).orElseThrow(
                () -> new RuntimeException("Hospital no encontrado"));
        InventarioEntity inventario = new InventarioEntity();
        inventario.setProductoEntity(productoRepository.findById(crearInventarioDTO.getProductoId())
                .orElseThrow(() -> new ResourceNotFoundException("Producto no encontrado")));
        inventario.setMarcaMaterialEntity(marcaRepository.findById(crearInventarioDTO.getMarcaMaterialId())
                .orElseThrow(() -> new ResourceNotFoundException("Marca no encontrada")));
        inventario.setCategoriaMatEntity(categoriaMatRepository.findById(crearInventarioDTO.getCategoriaMaterialId())
                .orElseThrow(() -> new ResourceNotFoundException("Categoría no encontrada")));
        inventario.setUnidadEntity(unidadRepository.findById(crearInventarioDTO.getUnidadId())
                .orElseThrow(() -> new ResourceNotFoundException("Unidad no encontrada")));
        inventario.setAlmacenEntity(almacenRepository.findById(crearInventarioDTO.getAlmacenId()).
                orElseThrow(() -> new ResourceNotFoundException("Almacen no encontrado")));
        inventario.setTipoInventarioId(crearInventarioDTO.getTipoInventarioId());
        inventario.setPrecioEntrada(crearInventarioDTO.getPrecioEntrada());
        inventario.setPrecioSalida(crearInventarioDTO.getPrecioSalida());
        inventario.setStock(crearInventarioDTO.getStock());
        inventario.setFecha(crearInventarioDTO.getFecha());
        inventario.setEstado(crearInventarioDTO.getEstado());
        inventario.setHospital(hospital);
        inventario.setUser(userEntity);
        inventarioRepository.save(inventario);
        return new ApiResponse(true, "Registro creado correctamente");
    }

    @Override
    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    public ApiResponse updateInventario(UUID inventarioId, ActualizarInventarioDTO actualizarInventarioDTO) {
        authValidator.validateAdminAccess(); // Lanza excepción si no es admin
        InventarioEntity inventario = inventarioRepository.findById(inventarioId).orElseThrow(
                () -> new ResourceNotFoundException("Inventari no encontrado"));
        Optional.ofNullable(actualizarInventarioDTO.getProductoId()).flatMap(productoRepository::findById).ifPresent(inventario::setProductoEntity);
        Optional.ofNullable(actualizarInventarioDTO.getMarcaMaterialId()).flatMap(marcaRepository::findById).ifPresent(inventario::setMarcaMaterialEntity);
        Optional.ofNullable(actualizarInventarioDTO.getCategoriaMaterialId()).flatMap(categoriaMatRepository::findById).ifPresent(inventario::setCategoriaMatEntity);
        Optional.ofNullable(actualizarInventarioDTO.getUnidadId()).flatMap(unidadRepository::findById).ifPresent(inventario::setUnidadEntity);
        Optional.ofNullable(actualizarInventarioDTO.getAlmacenId()).flatMap(almacenRepository::findById).ifPresent(inventario::setAlmacenEntity);
        Optional.ofNullable(actualizarInventarioDTO.getTipoInventarioId()).ifPresent(inventario::setTipoInventarioId);
        Optional.ofNullable(actualizarInventarioDTO.getPrecioEntrada()).ifPresent(inventario::setPrecioEntrada);
        Optional.ofNullable(actualizarInventarioDTO.getPrecioSalida()).ifPresent(inventario::setPrecioSalida);
        Optional.ofNullable(actualizarInventarioDTO.getStock()).ifPresent(inventario::setStock);
        Optional.ofNullable(actualizarInventarioDTO.getFecha()).ifPresent(inventario::setFecha);
        Optional.ofNullable(actualizarInventarioDTO.getEstado()).ifPresent(inventario::setEstado);
        inventarioRepository.save(inventario);
        return new ApiResponse(true, "Registro actualizado correctamente");
    }

    @Override
    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    public ApiResponse deleteInventario(UUID inventarioId) {
        UserEntity userEntity = authValidator.getCurrentUser();
        authValidator.validateAdminAccess(); // Lanza excepción si no es admin
        inventarioRepository.deleteById(inventarioId);
        return new ApiResponse(true, "Registro eliminado correctamente");
    }

    @Override
    public InventarioDTO getInventarioById(UUID inventarioId) {
        InventarioEntity inventarioEntity = inventarioRepository.findById(inventarioId).orElseThrow(
                () -> new ResourceNotFoundException("Inventario no encontrado"));
        return convertToDTO(inventarioEntity);
    }

    @Transactional(readOnly = true)
    @Override
    public ListResponse<InventarioDTO> getAllInventario(UUID hospitalId, int page, int rows) {
        Pageable pageable = PageRequest.of(page - 1, rows);
        Page<InventarioProjection> projections = productoRepository.findInventarioDataByHospitalId(hospitalId, pageable);
        List<InventarioDTO> data = projections.getContent().stream()
                .map(p -> new InventarioDTO(
                        p.getNombreAlmacen(),
                        p.getNombreProducto(),
                        p.getNombreMarca(),
                        p.getNombreCategoria(),
                        p.getPrecioEntrada(),
                        p.getUnidad(),
                        p.getStock()
                ))
                .collect(Collectors.toList());
        return new ListResponse<>(data, projections.getTotalElements(), projections.getTotalPages(), projections.getNumber() + 1
        );
    }

    private InventarioDTO convertToDTO(InventarioEntity inventarioEntity) {
        return modelMapper.map(inventarioEntity, InventarioDTO.class);
    }
}