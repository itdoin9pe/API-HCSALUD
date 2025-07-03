package com.saludsystem.application.services.movimiento.impl;

import com.saludsystem.application.dtos.movimientos.get.CompraDetalleDTO;
import com.saludsystem.application.dtos.movimientos.post.CrearCompraDetalleDTO;
import com.saludsystem.application.dtos.movimientos.put.ActualizarCompraDetalleDTO;
import com.saludsystem.application.services.movimiento.CompraDetalleService;
import com.saludsystem.domain.exception.ResourceNotFoundException;
import com.saludsystem.domain.model.configuracion.SysSaludEntity;
import com.saludsystem.domain.model.configuracion.UserEntity;
import com.saludsystem.domain.model.movimientos.CompraDetalleEntity;
import com.saludsystem.domain.model.operaciones.ProductoEntity;
import com.saludsystem.infrastructure.adapters.in.response.ApiResponse;
import com.saludsystem.infrastructure.adapters.in.response.ListResponse;
import com.saludsystem.infrastructure.adapters.out.persistance.repository.configuracion.SysSaludRepository;
import com.saludsystem.infrastructure.adapters.out.persistance.repository.configuracion.UserRepository;
import com.saludsystem.infrastructure.adapters.out.persistance.repository.movimiento.CompraDetalleRepository;
import com.saludsystem.infrastructure.adapters.out.persistance.repository.operaciones.ProductoRepository;
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
    public ApiResponse saveCompraDetalle(CrearCompraDetalleDTO crearCompraDetalleDTO) {
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
        Optional<ProductoEntity> productoEntity = productoRepository.findById(crearCompraDetalleDTO.getProductoId());
        productoEntity.ifPresent(compraDetalleEntity::setProductoEntity);
        compraDetalleEntity.setCantidad(crearCompraDetalleDTO.getCantidad());
        compraDetalleEntity.setPrecioUnitario(crearCompraDetalleDTO.getPrecioUnitario());
        compraDetalleEntity.setIgv(crearCompraDetalleDTO.getIgv());
        compraDetalleEntity.setPrecioVenta(crearCompraDetalleDTO.getPrecioVenta());
        compraDetalleEntity.setSubtotal(crearCompraDetalleDTO.getSubtotal());
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
    public CompraDetalleDTO getCompraDetalleById(UUID compraDetalleId) {
        CompraDetalleEntity compraDetalleEntity = compraDetalleRepository.findById(compraDetalleId).orElseThrow(
                () -> new ResourceNotFoundException("Detalle de la compra no encontrada"));
        return convertToDto(compraDetalleEntity);
    }

    @Override
    public ListResponse<CompraDetalleDTO> getAllCompraDetalle(UUID hospitalId, int page, int rows) {
        Pageable pageable = PageRequest.of(page - 1, rows);
        Page<CompraDetalleEntity> compraDetalleEntityPage = compraDetalleRepository.findByHospital_HospitalId(hospitalId, pageable);
        List<CompraDetalleDTO> data = compraDetalleEntityPage.getContent().stream().map(this::convertToDto).collect(Collectors.toList());
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

    private CompraDetalleDTO convertToDto(CompraDetalleEntity compraDetalleEntity) {
        return modelMapper.map(compraDetalleEntity, CompraDetalleDTO.class);
    }

}