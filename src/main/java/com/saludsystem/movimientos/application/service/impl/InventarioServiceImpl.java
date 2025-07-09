package com.saludsystem.movimientos.application.service.impl;

import com.saludsystem.movimientos.application.dto.post.CrearInventarioDTO;
import com.saludsystem.movimientos.application.dto.get.InventarioDTO;
import com.saludsystem.movimientos.application.dto.put.ActualizarInventarioDTO;
import com.saludsystem.movimientos.application.service.InventarioProjection;
import com.saludsystem.movimientos.application.service.InventarioService;
import com.saludsystem.shared.domain.exception.ResourceNotFoundException;
import com.saludsystem.configuracion.domain.model.SysSaludEntity;
import com.saludsystem.configuracion.domain.model.UserEntity;
import com.saludsystem.movimientos.domain.model.InventarioEntity;
import com.saludsystem.shared.infrastructure.adapters.in.response.ApiResponse;
import com.saludsystem.shared.infrastructure.adapters.in.response.ListResponse;
import com.saludsystem.configuracion.infrastructure.adapters.out.persistance.SysSaludRepository;
import com.saludsystem.movimientos.infrastructure.adapters.out.persistance.AlmacenRepository;
import com.saludsystem.movimientos.infrastructure.adapters.out.persistance.InventarioRepository;
import com.saludsystem.operaciones.infrastructure.adapters.out.persistance.CategoriaMatRepository;
import com.saludsystem.operaciones.infrastructure.adapters.out.persistance.MarcaRepository;
import com.saludsystem.operaciones.infrastructure.adapters.out.persistance.ProductoRepository;
import com.saludsystem.operaciones.infrastructure.adapters.out.persistance.UnidadRepository;
import com.saludsystem.shared.infrastructure.security.util.AuthValidator;
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
    public ApiResponse saveInventario(CrearInventarioDTO inventarioDTO) {
        authValidator.validateAdminAccess(); // Lanza excepción si no es admin
        var user = authValidator.getCurrentUser();
        SysSaludEntity hospital = sysSaludRepository.findById(user.getHospital().getHospitalId()).orElseThrow(
                () -> new RuntimeException("Hospital no encontrado"));
        InventarioEntity inventario = new InventarioEntity();
        inventario.setProductoEntity(productoRepository.findById(inventarioDTO.getProductoId())
                .orElseThrow(() -> new ResourceNotFoundException("Producto no encontrado")));
        inventario.setMarcaMaterialEntity(marcaRepository.findById(inventarioDTO.getMarcaMaterialId())
                .orElseThrow(() -> new ResourceNotFoundException("Marca no encontrada")));
        inventario.setCategoriaMatEntity(categoriaMatRepository.findById(inventarioDTO.getCategoriaMaterialId())
                .orElseThrow(() -> new ResourceNotFoundException("Categoría no encontrada")));
        inventario.setUnidadEntity(unidadRepository.findById(inventarioDTO.getUnidadId())
                .orElseThrow(() -> new ResourceNotFoundException("Unidad no encontrada")));
        inventario.setAlmacenEntity(almacenRepository.findById(inventarioDTO.getAlmacenId()).
                orElseThrow(() -> new ResourceNotFoundException("Almacen no encontrado")));
        inventario.setTipoInventarioId(inventarioDTO.getTipoInventarioId());
        inventario.setPrecioEntrada(inventarioDTO.getPrecioEntrada());
        inventario.setPrecioSalida(inventarioDTO.getPrecioSalida());
        inventario.setStock(inventarioDTO.getStock());
        inventario.setFecha(inventarioDTO.getFecha());
        inventario.setEstado(inventarioDTO.getEstado());
        inventario.setHospital(hospital);
        inventario.setUser(user);
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
                )).toList();
        return new ListResponse<>(data, projections.getTotalElements(), projections.getTotalPages(), projections.getNumber() + 1
        );
    }

    private InventarioDTO convertToDTO(InventarioEntity inventarioEntity) {
        return modelMapper.map(inventarioEntity, InventarioDTO.class);
    }
}