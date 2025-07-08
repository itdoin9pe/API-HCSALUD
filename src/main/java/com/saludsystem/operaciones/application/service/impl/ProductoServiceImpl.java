package com.saludsystem.operaciones.application.service.impl;

import com.saludsystem.operaciones.application.dto.res.ProductoResponse;
import com.saludsystem.operaciones.application.dto.req.ProductoRequest;
import com.saludsystem.operaciones.application.dto.req.ActualizarProductoDTO;
import com.saludsystem.operaciones.application.service.ProductoService;
import com.saludsystem.operaciones.domain.model.*;
import com.saludsystem.operaciones.infrastructure.adapters.out.persistance.*;
import com.saludsystem.shared.domain.exception.ResourceNotFoundException;
import com.saludsystem.configuracion.domain.model.SysSaludEntity;
import com.saludsystem.configuracion.domain.model.UserEntity;
import com.saludsystem.shared.infrastructure.adapters.in.response.ApiResponse;
import com.saludsystem.shared.infrastructure.adapters.in.response.ListResponse;
import com.saludsystem.configuracion.infrastructure.adapters.out.persistance.SysSaludRepository;
import com.saludsystem.configuracion.infrastructure.adapters.out.persistance.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ProductoServiceImpl implements ProductoService {

    private final ProductoRepository productoRepository;
    private final SysSaludRepository sysSaludRepository;
    private final UserRepository userRepository;
    private final MarcaRepository marcaRepository;
    private final CategoriaMatRepository categoriaMatRepository;
    private final PresentacionReposirory presentacionReposirory;
    private final TipoMaterialRepository tipoMaterialRepository;
    private final UnidadRepository unidadRepository;
    private final ModelMapper modelMapper;

    public ProductoServiceImpl(ProductoRepository productoRepository, SysSaludRepository sysSaludRepository, UserRepository userRepository, MarcaRepository marcaRepository, CategoriaMatRepository categoriaMatRepository, PresentacionReposirory presentacionReposirory, TipoMaterialRepository tipoMaterialRepository, UnidadRepository unidadRepository, ModelMapper modelMapper) {
        this.productoRepository = productoRepository;
        this.sysSaludRepository = sysSaludRepository;
        this.userRepository = userRepository;
        this.marcaRepository = marcaRepository;
        this.categoriaMatRepository = categoriaMatRepository;
        this.presentacionReposirory = presentacionReposirory;
        this.tipoMaterialRepository = tipoMaterialRepository;
        this.unidadRepository = unidadRepository;
        this.modelMapper = modelMapper;
    }

    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    @Override
    public ApiResponse saveProducto(ProductoRequest productoRequest) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();
        UserEntity userEntity = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        if (!"ADMINISTRADOR".equals(userEntity.getRol().getNombre())) {
            return new ApiResponse(false, "No tienes permisos para realizar esta acción");
        }
        SysSaludEntity hospital = sysSaludRepository.findById(userEntity.getHospital().getHospitalId())
                .orElseThrow(() -> new RuntimeException("Hospital no encontrado"));
        ProductoEntity productoEntity = new ProductoEntity();
        productoEntity.setDescripcion(productoRequest.getDescripcion());
        productoEntity.setNombre(productoRequest.getNombre());
        productoEntity.setCodigo(productoRequest.getCodigo());
        Optional<MarcaEntity> marcaEntity = marcaRepository.findById(productoRequest.getMarcaMaterialesId());
        marcaEntity.ifPresent(productoEntity::setMarcaEntity);
        Optional<CategoriaMatEntity> categoriaMatEntity = categoriaMatRepository.findById(productoRequest.getCategoriaMaterialId());
        categoriaMatEntity.ifPresent(productoEntity::setCategoriaMatEntity);
        Optional<PresentacionEntity> presentacionEntity = presentacionReposirory.findById(productoRequest.getPresentacionId());
        presentacionEntity.ifPresent(productoEntity::setPresentacionEntity);
        Optional<TipoMaterialEntity> tipoMaterialEntity = tipoMaterialRepository.findById(productoRequest.getTipoMaterialId());
        tipoMaterialEntity.ifPresent(productoEntity::setTipoMaterialEntity);
        Optional<UnidadEntity> unidadEntity = unidadRepository.findById(productoRequest.getUnidadId());
        unidadEntity.ifPresent(productoEntity::setUnidadEntity);
        productoEntity.setPrecioCompra(productoRequest.getPrecioCompra());
        productoEntity.setPrecioVenta(productoRequest.getPrecioVenta());
        productoEntity.setStock(productoRequest.getStock());
        productoEntity.setCodigoBarras(productoRequest.getCodigoBarras());
        productoEntity.setLote(productoRequest.getLote());
        productoEntity.setFecha(productoRequest.getFecha());
        productoEntity.setEstadoVenta(productoRequest.getEstadoVenta());
        productoEntity.setEstadoCompra(productoRequest.getEstadoCompra());
        productoEntity.setEstadoProducto(productoRequest.getEstadoProducto());
        productoEntity.setHospital(hospital);
        productoEntity.setUser(userEntity);
        productoRepository.save(productoEntity);
        return new ApiResponse(true, "Producto registrado correctamente");
    }

    @Override
    public ListResponse<ProductoResponse> getAllProducto(UUID hospitalId, int page, int rows) {
        Pageable pageable = PageRequest.of(page - 1, rows);
        Page<ProductoEntity> productoEntityPage = productoRepository.findByHospital_HospitalId(hospitalId, pageable);
        List<ProductoResponse> data = productoEntityPage.getContent().stream().map(this::convertToDTO).collect(Collectors.toList());
        return new ListResponse<>(data, productoEntityPage.getTotalElements(), productoEntityPage.getTotalPages(), productoEntityPage.getNumber() + 1);
    }

    @Override
    public List<ProductoResponse> getProductoList() {
        return productoRepository.findAll().stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    @Override
    public ProductoResponse getProductoById(UUID productoId) {
        ProductoEntity productoEntity = productoRepository.findById(productoId).orElseThrow(
                () -> new ResourceNotFoundException("Producto no encontrado"));
        return convertToDTO(productoEntity);
    }

    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    @Override
    public ApiResponse updateProducto(UUID productoId, ActualizarProductoDTO actualizarProductoDTO) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();
        UserEntity userEntity = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        if (!"ADMINISTRADOR".equals(userEntity.getRol().getNombre())) {
            return new ApiResponse(false, "No tienes permisos para realizar esta acción");
        }
        ProductoEntity productoEntity = productoRepository.findById(productoId).orElseThrow(
                () -> new ResourceNotFoundException("Producto no encontrado"));
        Optional.ofNullable(actualizarProductoDTO.getDescripcion()).filter(desc -> !desc.isBlank()).ifPresent(productoEntity::setDescripcion);
        Optional.ofNullable(actualizarProductoDTO.getNombre()).filter(desc -> !desc.isBlank()).ifPresent(productoEntity::setNombre);
        Optional.ofNullable(actualizarProductoDTO.getCodigo()).filter(desc -> !desc.isBlank()).ifPresent(productoEntity::setCodigo);
        Optional.ofNullable(actualizarProductoDTO.getMarcaMaterialesId()).flatMap(marcaRepository::findById).ifPresent(productoEntity::setMarcaEntity);
        Optional.ofNullable(actualizarProductoDTO.getCategoriaMaterialId()).flatMap(categoriaMatRepository::findById).ifPresent(productoEntity::setCategoriaMatEntity);
        Optional.ofNullable(actualizarProductoDTO.getPresentacionId()).flatMap(presentacionReposirory::findById).ifPresent(productoEntity::setPresentacionEntity);
        Optional.ofNullable(actualizarProductoDTO.getTipoMaterialId()).flatMap(tipoMaterialRepository::findById).ifPresent(productoEntity::setTipoMaterialEntity);
        Optional.ofNullable(actualizarProductoDTO.getUnidadId()).flatMap(unidadRepository::findById).ifPresent(productoEntity::setUnidadEntity);
        Optional.ofNullable(actualizarProductoDTO.getPrecioCompra()).ifPresent(productoEntity::setPrecioCompra);
        Optional.ofNullable(actualizarProductoDTO.getPrecioVenta()).ifPresent(productoEntity::setPrecioVenta);
        Optional.ofNullable(actualizarProductoDTO.getStock()).ifPresent(productoEntity::setStock);
        Optional.ofNullable(actualizarProductoDTO.getCodigoBarras()).filter(desc -> !desc.isBlank()).ifPresent(productoEntity::setDescripcion);
        Optional.ofNullable(actualizarProductoDTO.getLote()).filter(desc -> !desc.isBlank()).ifPresent(productoEntity::setDescripcion);
        Optional.ofNullable(actualizarProductoDTO.getFecha()).ifPresent(productoEntity::setFecha);
        Optional.ofNullable(actualizarProductoDTO.getEstadoVenta()).filter(desc -> !desc.isBlank()).ifPresent(productoEntity::setDescripcion);
        Optional.ofNullable(actualizarProductoDTO.getEstadoCompra()).filter(desc -> !desc.isBlank()).ifPresent(productoEntity::setDescripcion);
        Optional.ofNullable(actualizarProductoDTO.getEstadoProducto()).ifPresent(productoEntity::setEstadoProducto);
        productoRepository.save(productoEntity);
        return new ApiResponse(true, "Producto actualizado correctamente");
    }

    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    @Override
    public ApiResponse deleteProducto(UUID productoId) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();
        UserEntity userEntity = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        if (!"ADMINISTRADOR".equals(userEntity.getRol().getNombre())) {
            return new ApiResponse(false, "No tienes permisos para realizar esta acción");
        }
        productoRepository.deleteById(productoId);
        return new ApiResponse(true, "Producto eliminado correctamente");
    }

    private ProductoResponse convertToDTO(ProductoEntity productoEntity) {
        return modelMapper.map(productoEntity, ProductoResponse.class);
    }

}