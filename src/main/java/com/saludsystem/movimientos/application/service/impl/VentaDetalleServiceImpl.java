package com.saludsystem.movimientos.application.service.impl;

import com.saludsystem.movimientos.application.dto.get.VentaDetalleDTO;
import com.saludsystem.movimientos.application.dto.post.CrearVentaDetalleDTO;
import com.saludsystem.movimientos.application.dto.put.ActualizarVentaDetalleDTO;
import com.saludsystem.movimientos.application.service.VentaDetalleService;
import com.saludsystem.shared.domain.exception.ResourceNotFoundException;
import com.saludsystem.configuracion.domain.model.SysSaludEntity;
import com.saludsystem.movimientos.domain.model.VentaDetalleEntity;
import com.saludsystem.operaciones.domain.model.ProductoEntity;
import com.saludsystem.shared.infrastructure.adapters.in.response.ApiResponse;
import com.saludsystem.shared.infrastructure.adapters.in.response.ListResponse;
import com.saludsystem.configuracion.infrastructure.adapters.out.persistance.SysSaludRepository;
import com.saludsystem.movimientos.infrastructure.adapters.out.persistance.VentaDetalleRepository;
import com.saludsystem.operaciones.infrastructure.adapters.out.persistance.ProductoRepository;
import com.saludsystem.shared.infrastructure.security.util.AuthValidator;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class VentaDetalleServiceImpl implements VentaDetalleService {

    private final VentaDetalleRepository ventaDetalleRepository;
    private final SysSaludRepository sysSaludRepository;
    private final ProductoRepository productoRepository;
    private final ModelMapper modelMapper;
    private final AuthValidator authValidator;

    public VentaDetalleServiceImpl(VentaDetalleRepository ventaDetalleRepository, SysSaludRepository sysSaludRepository, ProductoRepository productoRepository, ModelMapper modelMapper, AuthValidator authValidator) {
        this.ventaDetalleRepository = ventaDetalleRepository;
        this.sysSaludRepository = sysSaludRepository;
        this.productoRepository = productoRepository;
        this.modelMapper = modelMapper;
        this.authValidator = authValidator;
    }

    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    @Override
    public ApiResponse saveVentaDetalle(VentaDetalleDTO crearVentaDetalleDTO) {
        authValidator.validateAdminAccess(); // Lanza excepción si no es admin
        var user = authValidator.getCurrentUser();
        SysSaludEntity hospital = sysSaludRepository.findById(user.getHospital().getHospitalId()).orElseThrow(
                () -> new RuntimeException("Hospital no encontrado"));
        VentaDetalleEntity ventaDetalleEntity = new VentaDetalleEntity();
        Optional<ProductoEntity> productoEntity = productoRepository.findById(crearVentaDetalleDTO.getProductoId());
        productoEntity.ifPresent(ventaDetalleEntity::setProductoEntity);
        ventaDetalleEntity.setCodigoProducto(crearVentaDetalleDTO.getCodigoProducto());
        ventaDetalleEntity.setCantidad(crearVentaDetalleDTO.getCantidad());
        ventaDetalleEntity.setPrecio(BigDecimal.valueOf(crearVentaDetalleDTO.getPrecioUnitario()));
        ventaDetalleEntity.setSubtotal(BigDecimal.valueOf(crearVentaDetalleDTO.getSubtotal()));
        ventaDetalleEntity.setHospital(hospital);
        ventaDetalleEntity.setUser(user);
        ventaDetalleRepository.save(ventaDetalleEntity);
        return new ApiResponse(true, "Detalle de venta crada correctamente");
    }

    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    @Override
    public ApiResponse deleteVentaDetalle(UUID ventaDetalleId) {
        authValidator.validateAdminAccess(); // Lanza excepción si no es admin
        ventaDetalleRepository.deleteById(ventaDetalleId);
        return new ApiResponse(true, "Detalle de venta eliminado correctamente");
    }

    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    @Override
    public ApiResponse updateVentaDetalle(UUID ventaDetalleId, ActualizarVentaDetalleDTO actualizarVentaDetalleDTO) {
        authValidator.validateAdminAccess(); // Lanza excepción si no es admin
        VentaDetalleEntity ventaDetalleEntity = ventaDetalleRepository.findById(ventaDetalleId).orElseThrow(() -> new ResourceNotFoundException("Detalle de venta no econtrado"));
        Optional.ofNullable(actualizarVentaDetalleDTO.getProductoId()).flatMap(productoRepository::findById).ifPresent(ventaDetalleEntity::setProductoEntity);
        Optional.ofNullable(actualizarVentaDetalleDTO.getCantidad()).ifPresent(ventaDetalleEntity::setCantidad);
        Optional.ofNullable(actualizarVentaDetalleDTO.getCodigoProducto()).filter(desc -> !desc.isBlank()).ifPresent(ventaDetalleEntity::setCodigoProducto);
        Optional.ofNullable(actualizarVentaDetalleDTO.getPrecioUnitario()).ifPresent(precio -> ventaDetalleEntity.setPrecio(BigDecimal.valueOf(precio)));
        Optional.ofNullable(actualizarVentaDetalleDTO.getSubtotal()).ifPresent(subtotal -> ventaDetalleEntity.setSubtotal(BigDecimal.valueOf(subtotal)));
        ventaDetalleRepository.save(ventaDetalleEntity);
        return new ApiResponse(true, "Detalle de venta actualizado correctamente");
    }

    @Override
    public CrearVentaDetalleDTO getVentaDetalleById(UUID ventaDetalleId) {
        VentaDetalleEntity ventaDetalleEntity = ventaDetalleRepository.findById(ventaDetalleId).orElseThrow(() -> new ResourceNotFoundException("Detalle de venta no econtrado"));
        return convertToDTO(ventaDetalleEntity);
    }

    @Override
    public ListResponse<CrearVentaDetalleDTO> getAllVentaDetalle(UUID hospitalId, int page, int rows) {
        Pageable pageable = PageRequest.of(page - 1, rows);
        Page<VentaDetalleEntity> ventaDetalleEntityPage = ventaDetalleRepository.findByHospital_HospitalId(hospitalId, pageable);
        List<CrearVentaDetalleDTO> data = ventaDetalleEntityPage.getContent().stream().map(this::convertToDTO).toList();
        return new ListResponse<>(data, ventaDetalleEntityPage.getTotalElements(), ventaDetalleEntityPage.getTotalPages(), ventaDetalleEntityPage.getNumber() + 1);
    }

    private CrearVentaDetalleDTO convertToDTO(VentaDetalleEntity ventaDetalleEntity) {
        return modelMapper.map(ventaDetalleEntity, CrearVentaDetalleDTO.class);
    }

}