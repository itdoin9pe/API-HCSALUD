package com.saludsystem.movimientos.application.service.impl;

import com.saludsystem.movimientos.application.dto.post.CrearCompraDetalleDTO;
import com.saludsystem.movimientos.application.dto.get.CompraDetalleDTO;
import com.saludsystem.movimientos.application.dto.put.ActualizarCompraDetalleDTO;
import com.saludsystem.movimientos.application.service.CompraDetalleService;
import com.saludsystem.shared.domain.exception.ResourceNotFoundException;
import com.saludsystem.configuracion.domain.model.SysSaludEntity;
import com.saludsystem.configuracion.domain.model.UserEntity;
import com.saludsystem.movimientos.domain.model.CompraDetalleEntity;
import com.saludsystem.operaciones.domain.model.ProductoEntity;
import com.saludsystem.shared.infrastructure.adapters.in.response.ApiResponse;
import com.saludsystem.shared.infrastructure.adapters.in.response.ListResponse;
import com.saludsystem.configuracion.infrastructure.adapters.out.persistance.SysSaludRepository;
import com.saludsystem.configuracion.infrastructure.adapters.out.persistance.UserRepository;
import com.saludsystem.movimientos.infrastructure.adapters.out.persistance.CompraDetalleRepository;
import com.saludsystem.operaciones.infrastructure.adapters.out.persistance.ProductoRepository;
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
public class CompraDetalleServiceImpl implements CompraDetalleService {

    private final CompraDetalleRepository compraDetalleRepository;
    private final SysSaludRepository sysSaludRepository;
    private final UserRepository userRepository;
    private final ProductoRepository productoRepository;
    private final ModelMapper modelMapper;

    public CompraDetalleServiceImpl(CompraDetalleRepository compraDetalleRepository, SysSaludRepository sysSaludRepository, UserRepository userRepository, ProductoRepository productoRepository, ModelMapper modelMapper) {
        this.compraDetalleRepository = compraDetalleRepository;
        this.sysSaludRepository = sysSaludRepository;
        this.userRepository = userRepository;
        this.productoRepository = productoRepository;
        this.modelMapper = modelMapper;
    }

    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    @Override
    public ApiResponse saveCompraDetalle(CompraDetalleDTO compraDetalleDTO) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();
        UserEntity userEntity = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        if (!"ADMINISTRADOR".equals(userEntity.getRol().getNombre())) {
            return new ApiResponse(false, "No tienes permisos para realizar esta acción");
        }
        SysSaludEntity hospital = sysSaludRepository.findById(userEntity.getHospital().getHospitalId())
                .orElseThrow(() -> new RuntimeException("Hospital no encontrado"));
        CompraDetalleEntity compraDetalleEntity = new CompraDetalleEntity();
        Optional<ProductoEntity> productoEntity = productoRepository.findById(compraDetalleDTO.getProductoId());
        productoEntity.ifPresent(compraDetalleEntity::setProductoEntity);
        compraDetalleEntity.setCantidad(compraDetalleDTO.getCantidad());
        compraDetalleEntity.setPrecioUnitario(compraDetalleDTO.getPrecioUnitario());
        compraDetalleEntity.setIgv(compraDetalleDTO.getIgv());
        compraDetalleEntity.setPrecioVenta(compraDetalleDTO.getPrecioVenta());
        compraDetalleEntity.setSubtotal(compraDetalleDTO.getSubtotal());
        compraDetalleRepository.save(compraDetalleEntity);
        return new ApiResponse(true, "Compra detalle agregada correctamente");
    }

    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    @Override
    public ApiResponse updateCompraDetalle(UUID compraDetalleId, ActualizarCompraDetalleDTO actualizarCompraDetalleDTO) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();
        UserEntity userEntity = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        if (!"ADMINISTRADOR".equals(userEntity.getRol().getNombre())) {
            return new ApiResponse(false, "No tienes permisos para realizar esta acción");
        }
        CompraDetalleEntity compraDetalleEntity = compraDetalleRepository.findById(compraDetalleId).orElseThrow(
                () -> new ResourceNotFoundException("Detalle de la compra no encontrada"));
        Optional.ofNullable(actualizarCompraDetalleDTO.getProductoId()).
                flatMap(productoRepository::findById).ifPresent(compraDetalleEntity::setProductoEntity);
        Optional.ofNullable(actualizarCompraDetalleDTO.getCantidad()).ifPresent(compraDetalleEntity::setCantidad);
        Optional.ofNullable(actualizarCompraDetalleDTO.getPrecioUnitario()).ifPresent(compraDetalleEntity::setPrecioUnitario);
        Optional.ofNullable(actualizarCompraDetalleDTO.getIgv()).ifPresent(compraDetalleEntity::setIgv);
        Optional.ofNullable(actualizarCompraDetalleDTO.getPrecioVenta()).ifPresent(compraDetalleEntity::setPrecioVenta);
        Optional.ofNullable(actualizarCompraDetalleDTO.getSubtotal()).ifPresent(compraDetalleEntity::setSubtotal);
        compraDetalleRepository.save(compraDetalleEntity);
        return new ApiResponse(true, "Compra detalle actualizada correctamente");
    }

    @Override
    public CrearCompraDetalleDTO getCompraDetalleById(UUID compraDetalleId) {
        CompraDetalleEntity compraDetalleEntity = compraDetalleRepository.findById(compraDetalleId).orElseThrow(
                () -> new ResourceNotFoundException("Detalle de la compra no encontrada"));
        return convertToDto(compraDetalleEntity);
    }

    @Override
    public ListResponse<CrearCompraDetalleDTO> getAllCompraDetalle(UUID hospitalId, int page, int rows) {
        Pageable pageable = PageRequest.of(page - 1, rows);
        Page<CompraDetalleEntity> compraDetalleEntityPage = compraDetalleRepository.findByHospital_HospitalId(hospitalId, pageable);
        List<CrearCompraDetalleDTO> data = compraDetalleEntityPage.getContent().stream().map(this::convertToDto).collect(Collectors.toList());
        return new ListResponse<>(data, compraDetalleEntityPage.getTotalElements(), compraDetalleEntityPage.getTotalPages(), compraDetalleEntityPage.getNumber() + 1);
    }

    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    @Override
    public ApiResponse deleteCompraDetalle(UUID compraDetalleId) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();
        UserEntity userEntity = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        if (!"ADMINISTRADOR".equals(userEntity.getRol().getNombre())) {
            return new ApiResponse(false, "No tienes permisos para realizar esta acción");
        }
        CompraDetalleEntity compraDetalleEntity = compraDetalleRepository.findById(compraDetalleId).orElseThrow(
                () -> new ResourceNotFoundException("Detalle de la compra no encontrada"));
        compraDetalleRepository.deleteById(compraDetalleId);
        return new ApiResponse(true, "Compra detalle retirada correctamente");
    }

    private CrearCompraDetalleDTO convertToDto(CompraDetalleEntity compraDetalleEntity) {
        return modelMapper.map(compraDetalleEntity, CrearCompraDetalleDTO.class);
    }

}